/* Copyright (C) 2013 Interactive Brokers LLC. All rights reserved.  This code is subject to the terms
 * and conditions of the IB API Non-Commercial License or the IB API Commercial License, as applicable. */

package com.onenow.execution;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.ib.client.ComboLeg;
import com.ib.client.DeltaNeutralContract;
import com.ib.client.EWrapper;
import com.ib.client.ExecutionFilter;
import com.ib.client.Order;
import com.ib.client.OrderComboLeg;
import com.ib.client.ScannerSubscription;
import com.ib.client.TagValue;
import com.ib.client.Util;
import com.ib.client.Types.SecType;
import com.onenow.execution.EClientErrors.CodeMsgPair;
import java.util.logging.Level;
import com.onenow.util.TimeParser;
import com.onenow.util.Watchr;

public class EClientSocket {

    // Client version history
    //
    // 	6 = Added parentId to orderStatus
    // 	7 = The new execDetails event returned for an order filled status and reqExecDetails
    //     Also market depth is available.
    // 	8 = Added lastFillPrice to orderStatus() event and permId to execution details
    //  9 = Added 'averageCost', 'unrealizedPNL', and 'unrealizedPNL' to updatePortfolio event
    // 10 = Added 'serverId' to the 'open order' & 'order status' events.
    //      We send back all the API open orders upon connection.
    //      Added new methods reqAllOpenOrders, reqAutoOpenOrders()
    //      Added FA support - reqExecution has filter.
    //                       - reqAccountUpdates takes acct code.
    // 11 = Added permId to openOrder event.
    // 12 = requsting open order attributes ignoreRth, hidden, and discretionary
    // 13 = added goodAfterTime
    // 14 = always send size on bid/ask/last tick
    // 15 = send allocation description string on openOrder
    // 16 = can receive account name in account and portfolio updates, and fa params in openOrder
    // 17 = can receive liquidation field in exec reports, and notAutoAvailable field in mkt data
    // 18 = can receive good till date field in open order messages, and request intraday backfill
    // 19 = can receive rthOnly flag in ORDER_STATUS
    // 20 = expects TWS time string on connection after server version >= 20.
    // 21 = can receive bond contract details.
    // 22 = can receive price magnifier in version 2 contract details message
    // 23 = support for scanner
    // 24 = can receive volatility order parameters in open order messages
	// 25 = can receive HMDS query start and end times
	// 26 = can receive option vols in option market data messages
	// 27 = can receive delta neutral order type and delta neutral aux price in place order version 20: API 8.85
	// 28 = can receive option model computation ticks: API 8.9
	// 29 = can receive trail stop limit price in open order and can place them: API 8.91
	// 30 = can receive extended bond contract def, new ticks, and trade count in bars
	// 31 = can receive EFP extensions to scanner and market data, and combo legs on open orders
	//    ; can receive RT bars
	// 32 = can receive TickType.LAST_TIMESTAMP
	//    ; can receive "whyHeld" in order status messages
	// 33 = can receive ScaleNumComponents and ScaleComponentSize is open order messages
	// 34 = can receive whatIf orders / order state
	// 35 = can receive contId field for Contract objects
	// 36 = can receive outsideRth field for Order objects
	// 37 = can receive clearingAccount and clearingIntent for Order objects
	// 38 = can receive multiplier and primaryExchange in portfolio updates
	//    ; can receive cumQty and avgPrice in execution
	//    ; can receive fundamental data
	//    ; can receive underComp for Contract objects
	//    ; can receive reqId and end marker in contractDetails/bondContractDetails
 	//    ; can receive ScaleInitComponentSize and ScaleSubsComponentSize for Order objects
	// 39 = can receive underConId in contractDetails
	// 40 = can receive algoStrategy/algoParams in openOrder
	// 41 = can receive end marker for openOrder
	//    ; can receive end marker for account download
	//    ; can receive end marker for executions download
	// 42 = can receive deltaNeutralValidation
	// 43 = can receive longName(companyName)
	//    ; can receive listingExchange
	//    ; can receive RTVolume tick
	// 44 = can receive end market for ticker snapshot
	// 45 = can receive notHeld field in openOrder
	// 46 = can receive contractMonth, industry, category, subcategory fields in contractDetails
	//    ; can receive timeZoneId, tradingHours, liquidHours fields in contractDetails
	// 47 = can receive gamma, vega, theta, undPrice fields in TICK_OPTION_COMPUTATION
	// 48 = can receive exemptCode in openOrder
	// 49 = can receive hedgeType and hedgeParam in openOrder
	// 50 = can receive optOutSmartRouting field in openOrder
	// 51 = can receive smartComboRoutingParams in openOrder
	// 52 = can receive deltaNeutralConId, deltaNeutralSettlingFirm, deltaNeutralClearingAccount and deltaNeutralClearingIntent in openOrder
	// 53 = can receive orderRef in execution
	// 54 = can receive scale order fields (PriceAdjustValue, PriceAdjustInterval, ProfitOffset, AutoReset,
	//      InitPosition, InitFillQty and RandomPercent) in openOrder
	// 55 = can receive orderComboLegs (price) in openOrder
	// 56 = can receive trailingPercent in openOrder
	// 57 = can receive commissionReport message
	// 58 = can receive CUSIP/ISIN/etc. in contractDescription/bondContractDescription
	// 59 = can receive evRule, evMultiplier in contractDescription/bondContractDescription/executionDetails
	//      can receive multiplier in executionDetails
	// 60 = can receive deltaNeutralOpenClose, deltaNeutralShortSale, deltaNeutralShortSaleSlot and deltaNeutralDesignatedLocation in openOrder
	// 61 = can receive multiplier in openOrder
	//      can receive tradingClass in openOrder, updatePortfolio, execDetails and position
	// 62 = can receive avgCost in position message
	// 63 = can receive verifyMessageAPI, verifyCompleted, displayGroupList and displayGroupUpdated messages
	// 64 = can receive solicited attrib in openOrder message
	// 65 = can receive verifyAndAuthMessageAPI and verifyAndAuthCompleted messages

    public static final int MIN_VERSION = 100; // envelope encoding, applicable to useV100Plus mode only
    public static final int MAX_VERSION = 100; // ditto
    private static final int REDIRECT_MSG_ID = -1;
    private static final int REDIRECT_COUNT_MAX = 2;

    private static final int CLIENT_VERSION = 65;
    private static final int SERVER_VERSION = 38;
    
    // FA msg data types
    public static final int GROUPS = 1;
    public static final int PROFILES = 2;
    public static final int ALIASES = 3;

    public static String faMsgTypeName(int faDataType) {
        switch (faDataType) {
            case GROUPS:
                return "GROUPS";
            case PROFILES:
                return "PROFILES";
            case ALIASES:
                return "ALIASES";
        }
        return null;
    }

    // outgoing msg id's
    private static final int REQ_MKT_DATA = 1;
    private static final int CANCEL_MKT_DATA = 2;
    protected static final int PLACE_ORDER = 3;
    private static final int CANCEL_ORDER = 4;
    private static final int REQ_OPEN_ORDERS = 5;
    private static final int REQ_ACCOUNT_DATA = 6;
    private static final int REQ_EXECUTIONS = 7;
    private static final int REQ_IDS = 8;
    private static final int REQ_CONTRACT_DATA = 9;
    private static final int REQ_MKT_DEPTH = 10;
    private static final int CANCEL_MKT_DEPTH = 11;
    private static final int REQ_NEWS_BULLETINS = 12;
    private static final int CANCEL_NEWS_BULLETINS = 13;
    private static final int SET_SERVER_LOGLEVEL = 14;
    private static final int REQ_AUTO_OPEN_ORDERS = 15;
    private static final int REQ_ALL_OPEN_ORDERS = 16;
    private static final int REQ_MANAGED_ACCTS = 17;
    private static final int REQ_FA = 18;
    private static final int REPLACE_FA = 19;
    private static final int REQ_HISTORICAL_DATA = 20;
    private static final int EXERCISE_OPTIONS = 21;
    private static final int REQ_SCANNER_SUBSCRIPTION = 22;
    private static final int CANCEL_SCANNER_SUBSCRIPTION = 23;
    private static final int REQ_SCANNER_PARAMETERS = 24;
    private static final int CANCEL_HISTORICAL_DATA = 25;
    private static final int REQ_CURRENT_TIME = 49;
    private static final int REQ_REAL_TIME_BARS = 50;
    private static final int CANCEL_REAL_TIME_BARS = 51;
    private static final int REQ_FUNDAMENTAL_DATA = 52;
    private static final int CANCEL_FUNDAMENTAL_DATA = 53;
    private static final int REQ_CALC_IMPLIED_VOLAT = 54;
    private static final int REQ_CALC_OPTION_PRICE = 55;
    private static final int CANCEL_CALC_IMPLIED_VOLAT = 56;
    private static final int CANCEL_CALC_OPTION_PRICE = 57;
    private static final int REQ_GLOBAL_CANCEL = 58;
    private static final int REQ_MARKET_DATA_TYPE = 59;
    private static final int REQ_POSITIONS = 61;
    private static final int REQ_ACCOUNT_SUMMARY = 62;
    private static final int CANCEL_ACCOUNT_SUMMARY = 63;
    private static final int CANCEL_POSITIONS = 64;
    private static final int VERIFY_REQUEST = 65;
    private static final int VERIFY_MESSAGE = 66;
    private static final int QUERY_DISPLAY_GROUPS = 67;
    private static final int SUBSCRIBE_TO_GROUP_EVENTS = 68;
    private static final int UPDATE_DISPLAY_GROUP = 69;
    private static final int UNSUBSCRIBE_FROM_GROUP_EVENTS = 70;
    private static final int START_API = 71;
    private static final int VERIFY_AND_AUTH_REQUEST = 72;
    private static final int VERIFY_AND_AUTH_MESSAGE = 73;

	private static final int MIN_SERVER_VER_REAL_TIME_BARS = 34;
	private static final int MIN_SERVER_VER_SCALE_ORDERS = 35;
	private static final int MIN_SERVER_VER_SNAPSHOT_MKT_DATA = 35;
	private static final int MIN_SERVER_VER_SSHORT_COMBO_LEGS = 35;
	private static final int MIN_SERVER_VER_WHAT_IF_ORDERS = 36;
	private static final int MIN_SERVER_VER_CONTRACT_CONID = 37;
	private static final int MIN_SERVER_VER_PTA_ORDERS = 39;
	private static final int MIN_SERVER_VER_FUNDAMENTAL_DATA = 40;
	private static final int MIN_SERVER_VER_UNDER_COMP = 40;
	private static final int MIN_SERVER_VER_CONTRACT_DATA_CHAIN = 40;
	private static final int MIN_SERVER_VER_SCALE_ORDERS2 = 40;
	private static final int MIN_SERVER_VER_ALGO_ORDERS = 41;
	private static final int MIN_SERVER_VER_EXECUTION_DATA_CHAIN = 42;
	private static final int MIN_SERVER_VER_NOT_HELD = 44;
	private static final int MIN_SERVER_VER_SEC_ID_TYPE = 45;
	private static final int MIN_SERVER_VER_PLACE_ORDER_CONID = 46;
	private static final int MIN_SERVER_VER_REQ_MKT_DATA_CONID = 47;
    private static final int MIN_SERVER_VER_REQ_CALC_IMPLIED_VOLAT = 49;
    private static final int MIN_SERVER_VER_REQ_CALC_OPTION_PRICE = 50;
    private static final int MIN_SERVER_VER_CANCEL_CALC_IMPLIED_VOLAT = 50;
    private static final int MIN_SERVER_VER_CANCEL_CALC_OPTION_PRICE = 50;
    private static final int MIN_SERVER_VER_SSHORTX_OLD = 51;
    private static final int MIN_SERVER_VER_SSHORTX = 52;
    private static final int MIN_SERVER_VER_REQ_GLOBAL_CANCEL = 53;
    private static final int MIN_SERVER_VER_HEDGE_ORDERS = 54;
    private static final int MIN_SERVER_VER_REQ_MARKET_DATA_TYPE = 55;
    private static final int MIN_SERVER_VER_OPT_OUT_SMART_ROUTING = 56;
    private static final int MIN_SERVER_VER_SMART_COMBO_ROUTING_PARAMS = 57;
    private static final int MIN_SERVER_VER_DELTA_NEUTRAL_CONID = 58;
    private static final int MIN_SERVER_VER_SCALE_ORDERS3 = 60;
    private static final int MIN_SERVER_VER_ORDER_COMBO_LEGS_PRICE = 61;
    private static final int MIN_SERVER_VER_TRAILING_PERCENT = 62;
    protected static final int MIN_SERVER_VER_DELTA_NEUTRAL_OPEN_CLOSE = 66;
    private static final int MIN_SERVER_VER_ACCT_SUMMARY = 67;
    protected static final int MIN_SERVER_VER_TRADING_CLASS = 68;
    protected static final int MIN_SERVER_VER_SCALE_TABLE = 69;
    protected static final int MIN_SERVER_VER_LINKING = 70;
    protected static final int MIN_SERVER_VER_ALGO_ID = 71;
    protected static final int MIN_SERVER_VER_OPTIONAL_CAPABILITIES = 72;
    protected static final int MIN_SERVER_VER_ORDER_SOLICITED = 73;
    protected static final int MIN_SERVER_VER_LINKING_AUTH = 74;
    protected static final int MIN_SERVER_VER_PRIMARYEXCH = 75;

    private EWrapper m_eWrapper;    	// msg handler
    protected DataOutputStream m_dos;   // the socket output stream
    private boolean m_connected;        // true if we are connected
    private EReader m_reader;           // thread which reads msgs from socket
    protected int m_serverVersion;
    private String m_TwsTime;
    private int m_clientId;
    private boolean m_extraAuth;
    private boolean m_useV100Plus;
    private String m_optionalCapabilities;
    private String m_connectOptions; // iServer rails are used for Connection if this is not null
    private String m_host;           // Actual host, directly set or redirected
    private int m_redirectCount;

    public int serverVersion()          { return m_serverVersion;   }
    public String TwsConnectionTime()   { return m_TwsTime; }
    public EWrapper wrapper() 		{ return m_eWrapper; }
    public EReader reader()             { return m_reader; }
    public boolean isConnected() 		{ return m_connected; }

    // set
    protected synchronized void setExtraAuth(boolean extraAuth) { m_extraAuth = extraAuth; }
    public void OptionalCapabilities(String val) 		{ m_optionalCapabilities = val; }

    // get
    public String OptionalCapabilities() { return m_optionalCapabilities; }
    public String connectedHost()        { return m_host; } // Host that was connected/redirected

    public EClientSocket( EWrapper eWrapper) {
        m_eWrapper = eWrapper;
        m_clientId = -1;
        m_extraAuth = false;
        m_optionalCapabilities = "";
        m_connected = false;
        m_serverVersion = 0;
        m_redirectCount = 0;
    }
    
    // iServer rails are used for Connection if connectOptions != null
    public void setUseV100Plus(String connectOptions) { 
    	Watchr.log(Level.INFO, "CONNECTION setUseV100Plus");
    	if( m_connected ) {
            m_eWrapper.error(EClientErrors.NO_VALID_ID, EClientErrors.ALREADY_CONNECTED.code(),
                    EClientErrors.ALREADY_CONNECTED.msg());
    		return;
  		}
    	m_connectOptions = connectOptions; 
    	m_useV100Plus = true; 
   	} 

    public synchronized void eConnect( String host, int port, int clientId) {
        eConnect(host, port, clientId, false);
    }
    
    public synchronized void eConnect( String host, int port, int clientId, boolean extraAuth) {
        // already connected?
        m_host = checkConnected(host);

        m_clientId = clientId;
        m_extraAuth = extraAuth;
        m_redirectCount = 0;

        if(m_host == null){
            return;
        }

        Socket socket = new Socket();
        
        boolean tryToConnect = true;
        while(tryToConnect) {
	        try{
	        	tryToConnect = false;

	        	Watchr.log(Level.INFO, "TRYING TO CONNECT TO GATEWAY/TWS: " + m_host + " " + port, "\n", "");

	            socket = new Socket( m_host, port);
	            eConnect(socket); // TODO: why CONNECT_FAIL exception on Gateway connection 
	        }
	        catch( Exception e) {
	        	tryToConnect = true;
	        	
	        	Watchr.log(Level.SEVERE, "... COULD NOT CONNECT TO GATEWAY/TWS: " + e.getMessage(), "\n", "");

	            connectionError(); 
	        	e.printStackTrace();
	        	eDisconnect();
	        	TimeParser.wait(10);
	        }
        }        
    }

    protected void connectionError() {
    	
    	Watchr.log(Level.INFO, "CONNECTION ERROR WITH GATEWAY/TWS");

        m_eWrapper.error( EClientErrors.NO_VALID_ID, EClientErrors.CONNECT_FAIL.code(),
                EClientErrors.CONNECT_FAIL.msg());
        m_reader = null;
    }

    protected String checkConnected(String host) {
    	String s = "CHECKING IF CONNECTED WITH GATEWAY/TWS";
		Watchr.log(Level.SEVERE, s, "", "");

        if( m_connected) {
            m_eWrapper.error(EClientErrors.NO_VALID_ID, EClientErrors.ALREADY_CONNECTED.code(),
                    EClientErrors.ALREADY_CONNECTED.msg());
            return null;
        }
        if( IsEmpty(host) ) {
            host = "127.0.0.1";
        }
        return host;
    }

    public EReader createReader(EClientSocket socket, DataInputStream dis) {
        return new EReader(socket, dis);
    }

    public synchronized void eConnect(Socket socket, int clientId) throws IOException {
        m_clientId = clientId;
        m_redirectCount = 0;
        eConnect(socket);
    }
    
    private synchronized void eConnect(Socket socket) throws IOException {
        // create io streams
        m_dos = new DataOutputStream( socket.getOutputStream() );

        // send client version (unless logon via iserver and/or Version > 100)
        if( !m_useV100Plus || m_connectOptions == null ) {
        	send( CLIENT_VERSION); // Do not add length prefix here, because Server does not know Client's version yet
        }
        else {
        	// Switch to GW API (Version 100+ requires length prefix)
        	sendV100APIHeader();
        }

        // start reader thread
        m_reader = createReader(this, new DataInputStream(socket.getInputStream()));
 
        
        if( m_useV100Plus ) {
            m_reader.setUseV100Plus();
        }
        
        // check server version
    	if( !m_reader.readMessageToInternalBuf() ) {
    	    return;
    	}
        m_serverVersion = m_reader.readInt();
        
        // Handle redirect
        if( m_useV100Plus && m_serverVersion == REDIRECT_MSG_ID ) {
            ++m_redirectCount;
            if ( m_redirectCount > REDIRECT_COUNT_MAX ) {
                eDisconnect();
                m_eWrapper.error( "Redirect count exceeded" );
                return;
            }
            String newAddress = m_reader.readStr();
            int defaultPort = socket.getPort();
            eDisconnect( false );
            performRedirect( newAddress, defaultPort );
        	return;
        }
        Watchr.log(Level.INFO, "CHECKING IF UNSUPORTED VERSION");
        Watchr.log(Level.INFO, "Server Version:" + m_serverVersion);
        
        if ( m_serverVersion >= 20 ){
        	// currently with Unified both server version and time sent in one message
            m_TwsTime = m_reader.readStr();
            Watchr.log(Level.INFO, "TWS Time at connection:" + m_TwsTime);

        }
    	if( m_useV100Plus && (m_serverVersion < MIN_VERSION || m_serverVersion > MAX_VERSION) ) {
    		eDisconnect();
    		m_eWrapper.error(EClientErrors.NO_VALID_ID, EClientErrors.UNSUPPORTED_VERSION.code(), EClientErrors.UNSUPPORTED_VERSION.msg());
    		return;
   		}
        if( m_serverVersion < SERVER_VERSION) {
        	eDisconnect();
            m_eWrapper.error( EClientErrors.NO_VALID_ID, EClientErrors.UPDATE_TWS.code(), EClientErrors.UPDATE_TWS.msg());
            return;
        }

        // set connected flag
        m_connected = true;

        // Send the client id
        if ( m_serverVersion >= 3 ){
            if ( m_serverVersion < MIN_SERVER_VER_LINKING) {
                send( m_clientId);
            }
            else if (!m_extraAuth){
                startAPI();
            }
        }

        m_reader.start();

    }

    private void performRedirect( String address, int defaultPort ) throws IOException {
        
		Watchr.log(Level.INFO, "Server Redirect: " + address);

        // Get host:port from address string and reconnect (note: port is optional)
        String[] array = address.split(":");
        m_host = array[0]; // reset connected host
        int newPort;
        try {
            newPort = ( array.length > 1 ) ? Integer.parseInt(array[1]) : defaultPort;
        }
        catch ( NumberFormatException e ) {      	
        	Watchr.log(Level.SEVERE, "Warning: redirect port is invalid, using default port..." + e.getMessage());
            newPort = defaultPort;
        }
        eConnect( new Socket( m_host, newPort ) );
    }

    public synchronized void eDisconnect() {
        eDisconnect( true );
    }
    
    private synchronized void eDisconnect( boolean resetState ) {
        // not connected?
        if( m_dos == null) {
            return;
        }

        if ( resetState ) {
            m_connected = false;
            m_extraAuth = false;
            m_clientId = -1;
            m_serverVersion = 0;
            m_TwsTime = "";
            m_redirectCount = 0;
        }

        FilterOutputStream dos = m_dos;
        m_dos = null;

        EReader reader = m_reader;
        m_reader = null;

        try {
            // stop reader thread; reader thread will close input stream
            if( reader != null) {
                reader.interrupt();
            }
        }
        catch( Exception e) {
        	Watchr.log(Level.WARNING, "Reader interrupt");
        }

        try {
            // close output stream
            if( dos != null) {
                dos.close();
            }
        }
        catch( Exception e) {
        	Watchr.log(Level.WARNING, "Dos close");
        }
    }

    public synchronized void startAPI() {

    	Watchr.log(Level.INFO, "~ startAPI");

        // not connected?
        if( !m_connected) {
            notConnected();
            return;
        }

        final int VERSION = 2;

        try {
        	EWireBuilder b = prepareBuffer(); 
        	
            b.append(START_API);
            b.append(VERSION);
            b.append(m_clientId);
            
            if (m_serverVersion >= MIN_SERVER_VER_OPTIONAL_CAPABILITIES) {
                b.append(m_optionalCapabilities);
            }
            closeAndSend(b);
        }
        catch( Exception e) {
        	Watchr.log(Level.SEVERE, "FAILED TO START API: " + e.getMessage());

            error( EClientErrors.NO_VALID_ID,
                   EClientErrors.FAIL_SEND_STARTAPI, "" + e);
            close();
        }
    }

    public synchronized void cancelScannerSubscription( int tickerId) {
    	
    	Watchr.log(Level.INFO,"~ cancelScannerSubscription");

        // not connected?
        if( !m_connected) {
            notConnected();
            return;
        }

        if (m_serverVersion < 24) {
        	Watchr.log(Level.WARNING, "API SCANNER UNSUPPORTED");

        	error(EClientErrors.NO_VALID_ID, EClientErrors.UPDATE_TWS,
        		"  It does not support API scanner subscription.");
        	return;
        }

        final int VERSION = 1;

        // send cancel mkt data msg
        try {
            EWireBuilder b = prepareBuffer(); 

            b.append( CANCEL_SCANNER_SUBSCRIPTION);
            b.append( VERSION);
            b.append( tickerId);
            
            closeAndSend(b);
        }
        catch( Exception e) {
            error( tickerId, EClientErrors.FAIL_SEND_CANSCANNER, "" + e);
            close();
        }
    }

    public synchronized void reqScannerParameters() {
    	Watchr.log(Level.INFO,"~ reqScannerParameters");

        // not connected?
        if( !m_connected) {
            notConnected();
            return;
        }

        if (m_serverVersion < 24) {
        	Watchr.log(Level.WARNING, "API SCANNER UNSUPPORTED");

        	error(EClientErrors.NO_VALID_ID, EClientErrors.UPDATE_TWS,
        			"  It does not support API scanner subscription.");
          return;
        }

        final int VERSION = 1;

        try {
            EWireBuilder b = prepareBuffer(); 

            b.append(REQ_SCANNER_PARAMETERS);
            b.append(VERSION);

            closeAndSend(b);
        }
        catch( Exception e) {
        	Watchr.log(Level.SEVERE, "API SCANNER PARAMETER ERROR: " + e.getMessage());

            error( EClientErrors.NO_VALID_ID,
                   EClientErrors.FAIL_SEND_REQSCANNERPARAMETERS, "" + e);
            close();
        }
    }

    public synchronized void reqScannerSubscription( int tickerId, ScannerSubscription subscription, ArrayList<TagValue> scannerSubscriptionOptions) {
    	
    	Watchr.log(Level.INFO, "~ reqScannerSubscription") ;
		
    	// not connected?
        if( !m_connected) {
            notConnected();
            return;
        }

        if (m_serverVersion < 24) {
        	Watchr.log(Level.WARNING, "API SCANNER UNSUPPORTED");

        	error(EClientErrors.NO_VALID_ID, EClientErrors.UPDATE_TWS,
        			"  It does not support API scanner subscription.");
          return;
        }

        final int VERSION = 4;

        try {
            EWireBuilder b = prepareBuffer(); 

            b.append(REQ_SCANNER_SUBSCRIPTION);
            b.append(VERSION);
            b.append(tickerId);
            b.appendMax(subscription.numberOfRows());
            b.append(subscription.instrument());
            b.append(subscription.locationCode());
            b.append(subscription.scanCode());
            b.appendMax(subscription.abovePrice());
            b.appendMax(subscription.belowPrice());
            b.appendMax(subscription.aboveVolume());
            b.appendMax(subscription.marketCapAbove());
            b.appendMax(subscription.marketCapBelow());
            b.append(subscription.moodyRatingAbove());
            b.append(subscription.moodyRatingBelow());
            b.append(subscription.spRatingAbove());
            b.append(subscription.spRatingBelow());
            b.append(subscription.maturityDateAbove());
            b.append(subscription.maturityDateBelow());
            b.appendMax(subscription.couponRateAbove());
            b.appendMax(subscription.couponRateBelow());
            b.append(subscription.excludeConvertible());
            if (m_serverVersion >= 25) {
                b.appendMax(subscription.averageOptionVolumeAbove());
                b.append(subscription.scannerSettingPairs());
            }
            if (m_serverVersion >= 27) {
                b.append(subscription.stockTypeFilter());
            }
            
            // send scannerSubscriptionOptions parameter
            if(m_serverVersion >= MIN_SERVER_VER_LINKING) {
                StringBuilder scannerSubscriptionOptionsStr = new StringBuilder();
                int scannerSubscriptionOptionsCount = scannerSubscriptionOptions == null ? 0 : scannerSubscriptionOptions.size();
                if( scannerSubscriptionOptionsCount > 0) {
                    for( int i = 0; i < scannerSubscriptionOptionsCount; ++i) {
                        TagValue tagValue = (TagValue)scannerSubscriptionOptions.get(i);
                        scannerSubscriptionOptionsStr.append( tagValue.m_tag);
                        scannerSubscriptionOptionsStr.append( "=");
                        scannerSubscriptionOptionsStr.append( tagValue.m_value);
                        scannerSubscriptionOptionsStr.append( ";");
                    }
                }
                b.append( scannerSubscriptionOptionsStr.toString());
            }
            closeAndSend(b);
        }
        catch( Exception e) {
            error( tickerId, EClientErrors.FAIL_SEND_REQSCANNER, "" + e);
            close();
        }
    }

    /**
     * Request market data
     * @param tickerId
     * @param contract
     * @param genericTickList
     * @param snapshot
     * @param mktDataOptions
     */
    public synchronized void reqMktData(int tickerId, Contract contract,
    		String genericTickList, boolean snapshot, List<TagValue> mktDataOptions) {
    	
    	Watchr.log(Level.INFO, "~ reqMktData");

    	String req = "== " + "Request Market Data" + " ";
    	req = req + "-TickerId " + tickerId + " ";
    	req = req + "-Contract " + contract.toString() + " ";
    	req = req + "-TickList: " + genericTickList + " ";
    	req = req + "-Snapshot " + snapshot + " ";
    	req = req + "-MktDataOptions " + mktDataOptions.toString();
		Watchr.log(Level.INFO, req);
    	
        if (!m_connected) {
        	Watchr.log(Level.WARNING, "COULD NOT CONNECT: reqMktData");

            error(EClientErrors.NO_VALID_ID, EClientErrors.NOT_CONNECTED, "");
            return;
        }

        if (m_serverVersion < MIN_SERVER_VER_SNAPSHOT_MKT_DATA && snapshot) {
        	error(tickerId, EClientErrors.UPDATE_TWS,
        			"  It does not support snapshot market data requests.");
        	return;
        }

        if (m_serverVersion < MIN_SERVER_VER_UNDER_COMP) {
        	if (contract.underComp() != null) {
        		error(tickerId, EClientErrors.UPDATE_TWS,
        			"  It does not support delta-neutral orders.");
        		return;
        	}
        }

        if (m_serverVersion < MIN_SERVER_VER_REQ_MKT_DATA_CONID) {
            if (contract.conid() > 0) {
                error(tickerId, EClientErrors.UPDATE_TWS,
                    "  It does not support conId parameter.");
                return;
            }
        }

        if (m_serverVersion < MIN_SERVER_VER_TRADING_CLASS) {
            if (!IsEmpty(contract.tradingClass())) {
                error(tickerId, EClientErrors.UPDATE_TWS,
                    "  It does not support tradingClass parameter in reqMarketData.");
                return;
            }
        }

        final int VERSION = 11;

        try {
            // send req mkt data msg
            EWireBuilder b = prepareBuffer(); 

            b.append(REQ_MKT_DATA);
            b.append(VERSION);
            b.append(tickerId);

            // send contract fields
            if (m_serverVersion >= MIN_SERVER_VER_REQ_MKT_DATA_CONID) {
                b.append(contract.conid());
            }
            b.append(contract.symbol());
            b.append(contract.getSecType());
            b.append(contract.expiry());
            b.send(contract.strike());
            b.append(contract.getRight());
            if (m_serverVersion >= 15) {
                b.append(contract.multiplier());
            }
            b.append(contract.exchange());
            if (m_serverVersion >= 14) {
                b.append(contract.primaryExch());
            }
            b.append(contract.currency());
            if(m_serverVersion >= 2) {
                b.append( contract.localSymbol());
            }
            if(m_serverVersion >= MIN_SERVER_VER_TRADING_CLASS) {
                b.append( contract.tradingClass());
            }
            if(m_serverVersion >= 8 && SecType.BAG.name().equalsIgnoreCase(contract.getSecType())) {
                if ( contract.comboLegs() == null ) {
                    b.append( 0);
                }
                else {
                    b.append( contract.comboLegs().size());

                    ComboLeg comboLeg;
                    for (int i=0; i < contract.comboLegs().size(); i ++) {
                        comboLeg = contract.comboLegs().get(i);
                        b.append( comboLeg.conid());
                        b.append( comboLeg.ratio());
                        b.append( comboLeg.getAction());
                        b.append( comboLeg.exchange());
                    }
                }
            }

            if (m_serverVersion >= MIN_SERVER_VER_UNDER_COMP) {
         	   if (contract.underComp() != null) {
         		   DeltaNeutralContract underComp = contract.underComp();
         		   b.send( true);
         		   b.append( underComp.conid());
         		   b.send( underComp.delta());
         		   b.send( underComp.price());
         	   }
         	   else {
         		   b.send( false);
         	   }
            }

            if (m_serverVersion >= 31) {
            	/*
            	 * Note: Even though SHORTABLE tick type supported only
            	 *       starting server version 33 it would be relatively
            	 *       expensive to expose this restriction here.
            	 *
            	 *       Therefore we are relying on TWS doing validation.
            	 */
            	b.append( genericTickList);
            }
            if (m_serverVersion >= MIN_SERVER_VER_SNAPSHOT_MKT_DATA) {
            	b.send (snapshot);
            }
            
            // send mktDataOptions parameter
            if(m_serverVersion >= MIN_SERVER_VER_LINKING) {
                StringBuilder mktDataOptionsStr = new StringBuilder();
                int mktDataOptionsCount = mktDataOptions == null ? 0 : mktDataOptions.size();
                if( mktDataOptionsCount > 0) {
                    for( int i = 0; i < mktDataOptionsCount; ++i) {
                        TagValue tagValue = (TagValue)mktDataOptions.get(i);
                        mktDataOptionsStr.append( tagValue.m_tag);
                        mktDataOptionsStr.append( "=");
                        mktDataOptionsStr.append( tagValue.m_value);
                        mktDataOptionsStr.append( ";");
                    }
                }
                b.append( mktDataOptionsStr.toString());
            }
            closeAndSend(b);
        }
        catch( Exception e) {
            error( tickerId, EClientErrors.FAIL_SEND_REQMKT, "" + e);
            close();
        }
    }

    public synchronized void cancelHistoricalData( int tickerId ) {
    	
    	Watchr.log(Level.INFO, "~ cancelHistoricalData");

        // not connected?
        if( !m_connected) {
            notConnected();
            return;
        }

        if (m_serverVersion < 24) {
        	Watchr.log(Level.WARNING, "COULD NOT CANCEL: HistoricalData");

        	error(EClientErrors.NO_VALID_ID, EClientErrors.UPDATE_TWS,
        			"  It does not support historical data query cancellation.");
          return;
        }

        final int VERSION = 1;

        // send cancel mkt data msg
        try {
            EWireBuilder b = prepareBuffer(); 

            b.append( CANCEL_HISTORICAL_DATA);
            b.append( VERSION);
            b.append( tickerId);

            closeAndSend(b);
        }
        catch( Exception e) {
            error( tickerId, EClientErrors.FAIL_SEND_CANHISTDATA, "" + e);
            close();
        }
    }

    public void cancelRealTimeBars(int tickerId) {
    	
    	Watchr.log(Level.INFO, "~ cancelRealTimeBars");
		
        // not connected?
        if( !m_connected) {
            notConnected();
            return;
        }

        if (m_serverVersion < MIN_SERVER_VER_REAL_TIME_BARS) {
        	Watchr.log(Level.WARNING, "COULD NOT CANCEL: RealTime");

            error(EClientErrors.NO_VALID_ID, EClientErrors.UPDATE_TWS,
                  "  It does not support realtime bar data query cancellation.");
            return;
        }

        final int VERSION = 1;

        // send cancel mkt data msg
        try {
            EWireBuilder b = prepareBuffer(); 

            b.append( CANCEL_REAL_TIME_BARS);
            b.append( VERSION);
            b.append( tickerId);

            closeAndSend(b);
        }
        catch( Exception e) {
            error( tickerId, EClientErrors.FAIL_SEND_CANRTBARS, "" + e);
            close();
        }
    }

    /** Note that formatData parameter affects intra-day bars only; 1-day bars always return with date in YYYYMMDD format. */
    public synchronized void reqHistoricalData( int tickerId, Contract contract,
                                                String endDateTime, String durationStr,
                                                String barSizeSetting, String whatToShow,
                                                int useRTH, int formatDate, List<TagValue> chartOptions) {
    	
    	Watchr.log(Level.INFO, "~ reqHistoricalData");

    	String req = "";
    	req = req + "==" + "Requesting Historical Data" + "\n";
    	req = req + "-TickerId " + tickerId + "\n";
    	req = req + " ||| " + "Contract: " + "\n" + contract.toString() + " ||| ";
    	req = req + "-EndDateTime " + endDateTime + "\n";
    	req = req + "-DurationStr " + durationStr + "\n";
    	req = req + "-BarSize " + barSizeSetting + "\n";
    	req = req + "-WhatToShow " + whatToShow + "\n";
    	req = req + "-UseRTH " + useRTH + "\n";
    	req = req + "-FormatDate " + formatDate + "\n";
    	req = req + "-ChartOptions " + chartOptions.toString();
		Watchr.log(Level.INFO, req);

    	
//    	EXAMPLE
//    	...Requesting Historical Data
//    	tickerId 10000001
//    	contract conid	0
//    	symbol	IBM
//    	secType	STK
//    	strike	0.0
//    	exchange	SMART
//    	currency	USD
//    	primaryExch	ISLAND
//    	endDateTime 20120101 12:00:00
//    	durationStr 1 W
//    	barSizeSetting 1 hour
//    	whatToShow TRADES
//    	useRTH 0
//    	formatDate 2
//    	chartOptions []
//    	READ MESSAGE ID 17
    	
        // not connected?
        if( !m_connected) {
            notConnected();
            return;
        }

        final int VERSION = 6;

        try {
          if (m_serverVersion < 16) {
        	  Watchr.log(Level.WARNING, "COULD NOT BACKFILL: HistoricalData");
        	  error(EClientErrors.NO_VALID_ID, EClientErrors.UPDATE_TWS,
                  "  It does not support historical data backfill.");
            return;
          }

          if (m_serverVersion < MIN_SERVER_VER_TRADING_CLASS) {
              if (!IsEmpty(contract.tradingClass()) || (contract.conid() > 0)) {
                  error(tickerId, EClientErrors.UPDATE_TWS,
                      "  It does not support conId and tradingClass parameters in reqHistroricalData.");
                  return;
              }
          }

          EWireBuilder b = prepareBuffer(); 
          

          b.append(REQ_HISTORICAL_DATA);
          b.append(VERSION);
          b.append(tickerId);

          // send contract fields
          if (m_serverVersion >= MIN_SERVER_VER_TRADING_CLASS) {
              b.append(contract.conid());
          }
          b.append(contract.symbol());
          b.append(contract.getSecType());
          b.append(contract.expiry());
          b.send(contract.strike());
          b.append(contract.getRight());
          b.append(contract.multiplier());
          b.append(contract.exchange());
          b.append(contract.primaryExch());
          b.append(contract.currency());
          b.append(contract.localSymbol());
          if (m_serverVersion >= MIN_SERVER_VER_TRADING_CLASS) {
              b.append(contract.tradingClass());
          }
          if (m_serverVersion >= 31) {
        	  b.append(contract.includeExpired() ? 1 : 0);
          }
          if (m_serverVersion >= 20) {
              b.append(endDateTime);
              b.append(barSizeSetting);
          }
          b.append(durationStr);
          b.append(useRTH);
          b.append(whatToShow);
          if (m_serverVersion > 16) {
              b.append(formatDate);
          }
          if ( SecType.BAG.name().equalsIgnoreCase(contract.getSecType()) ) {
              if (contract.comboLegs() == null) {
                  b.append(0);
              }
              else {
                  b.append(contract.comboLegs().size());

                  ComboLeg comboLeg;
                  for (int i = 0; i < contract.comboLegs().size(); i++) {
                      comboLeg = contract.comboLegs().get(i);
                      b.append(comboLeg.conid());
                      b.append(comboLeg.ratio());
                      b.append(comboLeg.getAction());
                      b.append(comboLeg.exchange());
                  }
              }
          }
          
          // send chartOptions parameter
          if(m_serverVersion >= MIN_SERVER_VER_LINKING) {
              StringBuilder chartOptionsStr = new StringBuilder();
              int chartOptionsCount = chartOptions == null ? 0 : chartOptions.size();
              if( chartOptionsCount > 0) {
                  for( int i = 0; i < chartOptionsCount; ++i) {
                      TagValue tagValue = (TagValue)chartOptions.get(i);
                      chartOptionsStr.append( tagValue.m_tag);
                      chartOptionsStr.append( "=");
                      chartOptionsStr.append( tagValue.m_value);
                      chartOptionsStr.append( ";");
                  }
              }
              b.append( chartOptionsStr.toString());
          }
          // THE WIRE
          
          // System.out.println("HISTORY WIRE " + b.toString());
          // HIST WIRE 20 6 10000035 0 BAC STK  0.0   SMART ISLAND USD   0 20150505 16:30:00 1 hour 1 D 0 TRADES 2   (MINE asking for Day on BAC)
          // HIST WIRE 20 6 10000001 0 IBM STK  0.0   SMART ISLAND USD   0 20120101 12:00:00 1 hour 1 W 0 TRADES 2   (API asking for Week on IBM)
          // b = new EWireBuilder("20 6 10000001 0 IBM STK  0.0   SMART ISLAND USD   0 20120101 12:00:00 1 hour 1 W 0 TRADES 2");
          closeAndSend(b);
        }
        catch (Exception e) {
          error(tickerId, EClientErrors.FAIL_SEND_REQHISTDATA, "" + e);
          close();
        }
        
    }

    public synchronized void reqRealTimeBars(	int tickerId, Contract contract, 
    											int barSize, String whatToShow, boolean useRTH, 
    											ArrayList<TagValue> realTimeBarsOptions) {
    	
    	Watchr.log(Level.INFO, "~ reqRealTimeBars");

        // not connected?
        if( !m_connected) {
            notConnected();
            return;
        }

        if (m_serverVersion < MIN_SERVER_VER_REAL_TIME_BARS) {
        	Watchr.log(Level.WARNING, "UNSUPPORTED: RealTime");

            error(EClientErrors.NO_VALID_ID, EClientErrors.UPDATE_TWS,
                  "  It does not support real time bars.");
            return;
        }
        if (m_serverVersion < MIN_SERVER_VER_TRADING_CLASS) {
            if (!IsEmpty(contract.tradingClass()) || (contract.conid() > 0)) {
                  error(tickerId, EClientErrors.UPDATE_TWS,
                      "  It does not support conId and tradingClass parameters in reqRealTimeBars.");
                  return;
            }
        }

        final int VERSION = 3;

        try {
            // send req mkt data msg
            EWireBuilder b = prepareBuffer(); 

            b.append(REQ_REAL_TIME_BARS);
            b.append(VERSION);
            b.append(tickerId);

            // send contract fields
            if (m_serverVersion >= MIN_SERVER_VER_TRADING_CLASS) {
                b.append(contract.conid());
            }
            b.append(contract.symbol());
            b.append(contract.getSecType());
            b.append(contract.expiry());
            b.send(contract.strike());
            b.append(contract.getRight());
            b.append(contract.multiplier());
            b.append(contract.exchange());
            b.append(contract.primaryExch());
            b.append(contract.currency());
            b.append(contract.localSymbol());
            if (m_serverVersion >= MIN_SERVER_VER_TRADING_CLASS) {
                b.append(contract.tradingClass());
            }
            b.append(barSize);  // this parameter is not currently used
            b.append(whatToShow);
            b.send(useRTH);

            // send realTimeBarsOptions parameter
            if(m_serverVersion >= MIN_SERVER_VER_LINKING) {
                StringBuilder realTimeBarsOptionsStr = new StringBuilder();
                int realTimeBarsOptionsCount = realTimeBarsOptions == null ? 0 : realTimeBarsOptions.size();
                if( realTimeBarsOptionsCount > 0) {
                    for( int i = 0; i < realTimeBarsOptionsCount; ++i) {
                        TagValue tagValue = (TagValue)realTimeBarsOptions.get(i);
                        realTimeBarsOptionsStr.append( tagValue.m_tag);
                        realTimeBarsOptionsStr.append( "=");
                        realTimeBarsOptionsStr.append( tagValue.m_value);
                        realTimeBarsOptionsStr.append( ";");
                    }
                }
                b.append( realTimeBarsOptionsStr.toString());
            }

            // WIRE
            closeAndSend(b);
            Watchr.log(Level.FINEST, "REAL-TIME WIRE " + b.toString());

        }
        catch( Exception e) {
            error( tickerId, EClientErrors.FAIL_SEND_REQRTBARS, "" + e);
            close();
        }
    }

    public synchronized void reqContractDetails(int reqId, Contract contract) {

    	Watchr.log(Level.INFO, "~ reqContractDetails");

        // not connected?
        if( !m_connected) {
            notConnected();
            return;
        }

        // This feature is only available for versions of TWS >=4
        if( m_serverVersion < 4) {
        	Watchr.log(Level.WARNING, "UNSUPPORTED: TWS version");

            message(EClientErrors.NO_VALID_ID, EClientErrors.UPDATE_TWS.code(),
                            EClientErrors.UPDATE_TWS.msg());
            return;
        }

        if( m_serverVersion < MIN_SERVER_VER_SEC_ID_TYPE) {
            if (!IsEmpty(contract.getSecIdType()) || !IsEmpty(contract.secId())) {
        		error(reqId, EClientErrors.UPDATE_TWS,
        			"  It does not support secIdType and secId parameters.");
        		return;
        	}
        }

        if (m_serverVersion < MIN_SERVER_VER_TRADING_CLASS) {
            if (!IsEmpty(contract.tradingClass())) {
                  error(reqId, EClientErrors.UPDATE_TWS,
                      "  It does not support tradingClass parameter in reqContractDetails.");
                  return;
            }
        }
        if (m_serverVersion < MIN_SERVER_VER_LINKING) {
            if (!IsEmpty(contract.primaryExch())) {
        		error(reqId, EClientErrors.UPDATE_TWS,
                    "  It does not support primaryExchange parameter in reqContractDetails.");
                return;
            }
        }
        
        final int VERSION = 8;

        try {
            // send req mkt data msg
            EWireBuilder b = prepareBuffer(); 

            b.append( REQ_CONTRACT_DATA);
            b.append( VERSION);

            if (m_serverVersion >= MIN_SERVER_VER_CONTRACT_DATA_CHAIN) {
            	b.append( reqId);
            }

            // send contract fields
            if (m_serverVersion >= MIN_SERVER_VER_CONTRACT_CONID) {
            	b.append(contract.conid());
            }
            b.append( contract.symbol());
            b.append( contract.getSecType());
            b.append( contract.expiry());
            b.send( contract.strike());
            b.append( contract.getRight());
            if (m_serverVersion >= 15) {
                b.append(contract.multiplier());
            }
            
            if (m_serverVersion >= MIN_SERVER_VER_PRIMARYEXCH)
            {
            	b.append(contract.exchange());
            	b.append(contract.primaryExch());
            }
            else if (m_serverVersion >= MIN_SERVER_VER_LINKING)
            {
                if (!IsEmpty(contract.primaryExch()) && (contract.exchange() == "BEST" || contract.exchange() == "SMART"))
                {
                   	b.append(contract.exchange() + ":" + contract.primaryExch());
                }
                else
                {
                	b.append(contract.exchange());
                }
            }
            
            b.append( contract.currency());
            b.append( contract.localSymbol());
            if (m_serverVersion >= MIN_SERVER_VER_TRADING_CLASS) {
                b.append(contract.tradingClass());
            }
            if (m_serverVersion >= 31) {
                b.send(contract.includeExpired());
            }
            if (m_serverVersion >= MIN_SERVER_VER_SEC_ID_TYPE) {
            	b.append( contract.getSecIdType());
            	b.append( contract.secId());
            }
            closeAndSend(b);
        }
        catch( Exception e) {
        	Watchr.log(Level.SEVERE, "CLIENT ERROR: REQUEST CONTRACT DETAILS.." + e.getMessage());
            error( EClientErrors.NO_VALID_ID, EClientErrors.FAIL_SEND_REQCONTRACT, "" + e);
            close();
        }
    }

    public synchronized void reqMktDepth( int tickerId, Contract contract, int numRows, ArrayList<TagValue> mktDepthOptions) {
        
    	Watchr.log(Level.INFO, "~ reqMktDepth");
    	
    	// not connected?
        if( !m_connected) {
            notConnected();
            return;
        }

        // This feature is only available for versions of TWS >=6
        if( m_serverVersion < 6) {
        	Watchr.log(Level.WARNING, "UNSUPPORTED: TWS >=6");

            message(EClientErrors.NO_VALID_ID, EClientErrors.UPDATE_TWS.code(),
                    EClientErrors.UPDATE_TWS.msg());
            return;
        }

        if (m_serverVersion < MIN_SERVER_VER_TRADING_CLASS) {
            if (!IsEmpty(contract.tradingClass()) || (contract.conid() > 0)) {
                  error(tickerId, EClientErrors.UPDATE_TWS,
                      "  It does not support conId and tradingClass parameters in reqMktDepth.");
                  return;
            }
        }

        final int VERSION = 5;

        try {
            // send req mkt data msg
            EWireBuilder b = prepareBuffer(); 

            b.append( REQ_MKT_DEPTH);
            b.append( VERSION);
            b.append( tickerId);

            // send contract fields
            if (m_serverVersion >= MIN_SERVER_VER_TRADING_CLASS) {
                b.append(contract.conid());
            }
            b.append( contract.symbol());
            b.append( contract.getSecType());
            b.append( contract.expiry());
            b.send( contract.strike());
            b.append( contract.getRight());
            if (m_serverVersion >= 15) {
              b.append(contract.multiplier());
            }
            b.append( contract.exchange());
            b.append( contract.currency());
            b.append( contract.localSymbol());
            if (m_serverVersion >= MIN_SERVER_VER_TRADING_CLASS) {
                b.append(contract.tradingClass());
            }
            if (m_serverVersion >= 19) {
                b.append( numRows);
            }
            
            // send mktDepthOptions parameter
            if(m_serverVersion >= MIN_SERVER_VER_LINKING) {
                StringBuilder mktDepthOptionsStr = new StringBuilder();
                int mktDepthOptionsCount = mktDepthOptions == null ? 0 : mktDepthOptions.size();
                if( mktDepthOptionsCount > 0) {
                    for( int i = 0; i < mktDepthOptionsCount; ++i) {
                        TagValue tagValue = (TagValue)mktDepthOptions.get(i);
                        mktDepthOptionsStr.append( tagValue.m_tag);
                        mktDepthOptionsStr.append( "=");
                        mktDepthOptionsStr.append( tagValue.m_value);
                        mktDepthOptionsStr.append( ";");
                    }
                }
                b.append( mktDepthOptionsStr.toString());
            }
            closeAndSend(b);
        }
        catch( Exception e) {
            error( tickerId, EClientErrors.FAIL_SEND_REQMKTDEPTH, "" + e);
            close();
        }
    }

    public synchronized void cancelMktData( int tickerId) {
    	
    	Watchr.log(Level.INFO, "~ cancelMktData");

        // not connected?
        if( !m_connected) {
            notConnected();
            return;
        }

        final int VERSION = 1;

        // send cancel mkt data msg
        try {
            EWireBuilder b = prepareBuffer(); 

            b.append( CANCEL_MKT_DATA);
            b.append( VERSION);
            b.append( tickerId);

            closeAndSend(b);
        }
        catch( Exception e) {
            error( tickerId, EClientErrors.FAIL_SEND_CANMKT, "" + e);
            close();
        }
    }

    public synchronized void cancelMktDepth( int tickerId) {
    	
    	Watchr.log(Level.INFO, "~ cancelMktDepth");


        // not connected?
        if( !m_connected) {
            notConnected();
            return;
        }

        // This feature is only available for versions of TWS >=6
        if( m_serverVersion < 6) {
        	Watchr.log(Level.WARNING, "UNSUPPORTED: TWS >=6");

            message(EClientErrors.NO_VALID_ID, EClientErrors.UPDATE_TWS.code(),
                    EClientErrors.UPDATE_TWS.msg());
            return;
        }

        final int VERSION = 1;

        // send cancel mkt data msg
        try {
            EWireBuilder b = prepareBuffer(); 

            b.append( CANCEL_MKT_DEPTH);
            b.append( VERSION);
            b.append( tickerId);

            closeAndSend(b);
        }
        catch( Exception e) {
            error( tickerId, EClientErrors.FAIL_SEND_CANMKTDEPTH, "" + e);
            close();
        }
    }

    public synchronized void exerciseOptions( int tickerId, Contract contract,
                                              int exerciseAction, int exerciseQuantity,
                                              String account, int override) {
    	
    	Watchr.log(Level.INFO, "~ exerciseOptions");

        // not connected?
        if( !m_connected) {
            notConnected();
            return;
        }

        final int VERSION = 2;

        try {
          if (m_serverVersion < 21) {
        	  Watchr.log(Level.WARNING, "UNSUPPORTED: OPTIONS EXERCISE");
            	error(EClientErrors.NO_VALID_ID, EClientErrors.UPDATE_TWS,
            			"  It does not support options exercise from the API.");
            return;
          }

          if (m_serverVersion < MIN_SERVER_VER_TRADING_CLASS) {
              if (!IsEmpty(contract.tradingClass()) || (contract.conid() > 0)) {
                    error(tickerId, EClientErrors.UPDATE_TWS,
                        "  It does not support conId and tradingClass parameters in exerciseOptions.");
                    return;
              }
          }

          EWireBuilder b = prepareBuffer(); 

          b.append(EXERCISE_OPTIONS);
          b.append(VERSION);
          b.append(tickerId);

          // send contract fields
          if (m_serverVersion >= MIN_SERVER_VER_TRADING_CLASS) {
              b.append(contract.conid());
          }
          b.append(contract.symbol());
          b.append(contract.getSecType());
          b.append(contract.expiry());
          b.send(contract.strike());
          b.append(contract.getRight());
          b.append(contract.multiplier());
          b.append(contract.exchange());
          b.append(contract.currency());
          b.append(contract.localSymbol());
          if (m_serverVersion >= MIN_SERVER_VER_TRADING_CLASS) {
              b.append(contract.tradingClass());
          }
          b.append(exerciseAction);
          b.append(exerciseQuantity);
          b.append(account);
          b.append(override);

          closeAndSend(b);
      }
      catch (Exception e) {
        error(tickerId, EClientErrors.FAIL_SEND_REQMKT, "" + e);
        close();
      }
    }

    public synchronized void placeOrder( int id, Contract contract, Order order) {
    	
    	Watchr.log(Level.INFO, "~ placeOrder");

        // not connected?
        if( !m_connected) {
            notConnected();
            return;
        }

        if (m_serverVersion < MIN_SERVER_VER_SCALE_ORDERS) {
        	if (order.scaleInitLevelSize() != Integer.MAX_VALUE ||
        		order.scalePriceIncrement() != Double.MAX_VALUE) {
        		error(id, EClientErrors.UPDATE_TWS,
            		"  It does not support Scale orders.");
        		return;
        	}
        }

        if (m_serverVersion < MIN_SERVER_VER_SSHORT_COMBO_LEGS) {
        	if (!contract.comboLegs().isEmpty()) {
                ComboLeg comboLeg;
                for (int i = 0; i < contract.comboLegs().size(); ++i) {
                    comboLeg = contract.comboLegs().get(i);
                    if (comboLeg.shortSaleSlot() != 0 ||
                    	!IsEmpty(comboLeg.designatedLocation())) {
                		error(id, EClientErrors.UPDATE_TWS,
                			"  It does not support SSHORT flag for combo legs.");
                		return;
                    }
                }
        	}
        }

        if (m_serverVersion < MIN_SERVER_VER_WHAT_IF_ORDERS) {
        	if (order.whatIf()) {
        		error(id, EClientErrors.UPDATE_TWS,
        			"  It does not support what-if orders.");
        		return;
        	}
        }

        if (m_serverVersion < MIN_SERVER_VER_UNDER_COMP) {
        	if (contract.underComp() != null) {
        		error(id, EClientErrors.UPDATE_TWS,
        			"  It does not support delta-neutral orders.");
        		return;
        	}
        }

        if (m_serverVersion < MIN_SERVER_VER_SCALE_ORDERS2) {
        	if (order.scaleSubsLevelSize() != Integer.MAX_VALUE) {
        		error(id, EClientErrors.UPDATE_TWS,
            		"  It does not support Subsequent Level Size for Scale orders.");
        		return;
        	}
        }

        if (m_serverVersion < MIN_SERVER_VER_ALGO_ORDERS) {
        	if (!IsEmpty(order.getAlgoStrategy())) {
        		error(id, EClientErrors.UPDATE_TWS,
        			"  It does not support algo orders.");
        		return;
        	}
        }

        if (m_serverVersion < MIN_SERVER_VER_NOT_HELD) {
        	if (order.notHeld()) {
        		error(id, EClientErrors.UPDATE_TWS,
        			"  It does not support notHeld parameter.");
        		return;
        	}
        }

        if (m_serverVersion < MIN_SERVER_VER_SEC_ID_TYPE) {
        	if (!IsEmpty(contract.getSecIdType()) || !IsEmpty(contract.secId())) {
        		error(id, EClientErrors.UPDATE_TWS,
        			"  It does not support secIdType and secId parameters.");
        		return;
        	}
        }

        if (m_serverVersion < MIN_SERVER_VER_PLACE_ORDER_CONID) {
        	if (contract.conid() > 0) {
        		error(id, EClientErrors.UPDATE_TWS,
        			"  It does not support conId parameter.");
        		return;
        	}
        }

        if (m_serverVersion < MIN_SERVER_VER_SSHORTX) {
        	if (order.exemptCode() != -1) {
        		error(id, EClientErrors.UPDATE_TWS,
        			"  It does not support exemptCode parameter.");
        		return;
        	}
        }

        if (m_serverVersion < MIN_SERVER_VER_SSHORTX) {
        	if (!contract.comboLegs().isEmpty()) {
                ComboLeg comboLeg;
                for (int i = 0; i < contract.comboLegs().size(); ++i) {
                    comboLeg = contract.comboLegs().get(i);
                    if (comboLeg.exemptCode() != -1) {
                		error(id, EClientErrors.UPDATE_TWS,
                			"  It does not support exemptCode parameter.");
                		return;
                    }
                }
        	}
        }

        if (m_serverVersion < MIN_SERVER_VER_HEDGE_ORDERS) {
        	if (!IsEmpty(order.getHedgeType())) {
        		error(id, EClientErrors.UPDATE_TWS,
        			"  It does not support hedge orders.");
        		return;
        	}
        }

        if (m_serverVersion < MIN_SERVER_VER_OPT_OUT_SMART_ROUTING) {
        	if (order.optOutSmartRouting()) {
        		error(id, EClientErrors.UPDATE_TWS,
        			"  It does not support optOutSmartRouting parameter.");
        		return;
        	}
        }

        if (m_serverVersion < MIN_SERVER_VER_DELTA_NEUTRAL_CONID) {
        	if (order.deltaNeutralConId() > 0
        			|| !IsEmpty(order.deltaNeutralSettlingFirm())
        			|| !IsEmpty(order.deltaNeutralClearingAccount())
        			|| !IsEmpty(order.deltaNeutralClearingIntent())
        			) {
        		error(id, EClientErrors.UPDATE_TWS,
        			"  It does not support deltaNeutral parameters: ConId, SettlingFirm, ClearingAccount, ClearingIntent");
        		return;
        	}
        }

        if (m_serverVersion < MIN_SERVER_VER_DELTA_NEUTRAL_OPEN_CLOSE) {
        	if (!IsEmpty(order.deltaNeutralOpenClose())
        			|| order.deltaNeutralShortSale()
        			|| order.deltaNeutralShortSaleSlot() > 0
        			|| !IsEmpty(order.deltaNeutralDesignatedLocation())
        			) {
        		error(id, EClientErrors.UPDATE_TWS,
        			"  It does not support deltaNeutral parameters: OpenClose, ShortSale, ShortSaleSlot, DesignatedLocation");
        		return;
        	}
        }

        if (m_serverVersion < MIN_SERVER_VER_SCALE_ORDERS3) {
        	if (order.scalePriceIncrement() > 0 && order.scalePriceIncrement() != Double.MAX_VALUE) {
        		if (order.scalePriceAdjustValue() != Double.MAX_VALUE ||
        			order.scalePriceAdjustInterval() != Integer.MAX_VALUE ||
        			order.scaleProfitOffset() != Double.MAX_VALUE ||
        			order.scaleAutoReset() ||
        			order.scaleInitPosition() != Integer.MAX_VALUE ||
        			order.scaleInitFillQty() != Integer.MAX_VALUE ||
        			order.scaleRandomPercent()) {
        			error(id, EClientErrors.UPDATE_TWS,
        				"  It does not support Scale order parameters: PriceAdjustValue, PriceAdjustInterval, " +
        				"ProfitOffset, AutoReset, InitPosition, InitFillQty and RandomPercent");
        			return;
        		}
        	}
        }

        if (m_serverVersion < MIN_SERVER_VER_ORDER_COMBO_LEGS_PRICE && SecType.BAG.name().equalsIgnoreCase(contract.getSecType())) {
        	if (!order.orderComboLegs().isEmpty()) {
        		OrderComboLeg orderComboLeg;
        		for (int i = 0; i < order.orderComboLegs().size(); ++i) {
        			orderComboLeg = order.orderComboLegs().get(i);
        			if (orderComboLeg.price() != Double.MAX_VALUE) {
        			error(id, EClientErrors.UPDATE_TWS,
        				"  It does not support per-leg prices for order combo legs.");
        			return;
        			}
        		}
        	}
        }

        if (m_serverVersion < MIN_SERVER_VER_TRAILING_PERCENT) {
        	if (order.trailingPercent() != Double.MAX_VALUE) {
        		error(id, EClientErrors.UPDATE_TWS,
        			"  It does not support trailing percent parameter");
        		return;
        	}
        }

        if (m_serverVersion < MIN_SERVER_VER_TRADING_CLASS) {
            if (!IsEmpty(contract.tradingClass())) {
                  error(id, EClientErrors.UPDATE_TWS,
                      "  It does not support tradingClass parameters in placeOrder.");
                  return;
            }
        }
        
        if (m_serverVersion < MIN_SERVER_VER_ALGO_ID && !IsEmpty(order.algoId()) ) {
        		  error(id, EClientErrors.UPDATE_TWS, " It does not support algoId parameter");
        	}

        if (m_serverVersion < MIN_SERVER_VER_SCALE_TABLE) {
            if (!IsEmpty(order.scaleTable()) || !IsEmpty(order.activeStartTime()) || !IsEmpty(order.activeStopTime())) {
                  error(id, EClientErrors.UPDATE_TWS,
                      "  It does not support scaleTable, activeStartTime and activeStopTime parameters.");
                  return;
            }
        }
        
        if (m_serverVersion < MIN_SERVER_VER_ORDER_SOLICITED) {
        	if (order.solicited()) {
        		error(id, EClientErrors.UPDATE_TWS,
                        "  It does not support order solicited parameter.");
                return;
        	}
        }

        int VERSION = (m_serverVersion < MIN_SERVER_VER_NOT_HELD) ? 27 : 44;

        // send place order msg
        try {
            EWireBuilder b = prepareBuffer(); 

            b.append( PLACE_ORDER);
            b.append( VERSION);
            b.append( id);

            // send contract fields
            if( m_serverVersion >= MIN_SERVER_VER_PLACE_ORDER_CONID) {
                b.append(contract.conid());
            }
            b.append( contract.symbol());
            b.append( contract.getSecType());
            b.append( contract.expiry());
            b.send( contract.strike());
            b.append( contract.getRight());
            if (m_serverVersion >= 15) {
                b.append(contract.multiplier());
            }
            b.append( contract.exchange());
            if( m_serverVersion >= 14) {
              b.append(contract.primaryExch());
            }
            b.append( contract.currency());
            if( m_serverVersion >= 2) {
                b.append (contract.localSymbol());
            }
            if (m_serverVersion >= MIN_SERVER_VER_TRADING_CLASS) {
                b.append(contract.tradingClass());
            }
            if( m_serverVersion >= MIN_SERVER_VER_SEC_ID_TYPE){
            	b.append( contract.getSecIdType());
            	b.append( contract.secId());
            }

            // send main order fields
            b.append( order.getAction());
            b.append( order.totalQuantity());
            b.append( order.getOrderType());
            if (m_serverVersion < MIN_SERVER_VER_ORDER_COMBO_LEGS_PRICE) {
                b.send( order.lmtPrice() == Double.MAX_VALUE ? 0 : order.lmtPrice());
            }
            else {
                b.appendMax( order.lmtPrice());
            }
            if (m_serverVersion < MIN_SERVER_VER_TRAILING_PERCENT) {
                b.send( order.auxPrice() == Double.MAX_VALUE ? 0 : order.auxPrice());
            }
            else {
                b.appendMax( order.auxPrice());
            }

            // send extended order fields
            b.append( order.getTif());
            b.append( order.ocaGroup());
            b.append( order.account());
            b.append( order.openClose());
            b.append( order.origin());
            b.append( order.orderRef());
            b.send( order.transmit());
            if( m_serverVersion >= 4 ) {
                b.append (order.parentId());
            }

            if( m_serverVersion >= 5 ) {
                b.send (order.blockOrder());
                b.send (order.sweepToFill());
                b.append (order.displaySize());
                b.append (order.getTriggerMethod());
                if (m_serverVersion < 38) {
                	// will never happen
                	b.send(/* order.m_ignoreRth */ false);
                }
                else {
                	b.send (order.outsideRth());
                }
            }

            if(m_serverVersion >= 7 ) {
                b.send(order.hidden());
            }

            // Send combo legs for BAG requests
            if(m_serverVersion >= 8 && SecType.BAG.name().equalsIgnoreCase(contract.getSecType())) {
                if ( contract.comboLegs() == null ) {
                    b.append( 0);
                }
                else {
                    b.append( contract.comboLegs().size());

                    ComboLeg comboLeg;
                    for (int i=0; i < contract.comboLegs().size(); i ++) {
                        comboLeg = contract.comboLegs().get(i);
                        b.append( comboLeg.conid());
                        b.append( comboLeg.ratio());
                        b.append( comboLeg.getAction());
                        b.append( comboLeg.exchange());
                        b.append( comboLeg.getOpenClose());

                        if (m_serverVersion >= MIN_SERVER_VER_SSHORT_COMBO_LEGS) {
                        	b.append( comboLeg.shortSaleSlot());
                        	b.append( comboLeg.designatedLocation());
                        }
                        if (m_serverVersion >= MIN_SERVER_VER_SSHORTX_OLD) {
                            b.append( comboLeg.exemptCode());
                        }
                    }
                }
            }

            // Send order combo legs for BAG requests
            if(m_serverVersion >= MIN_SERVER_VER_ORDER_COMBO_LEGS_PRICE && SecType.BAG.name().equalsIgnoreCase(contract.getSecType())) {
                if ( order.orderComboLegs() == null ) {
                    b.append( 0);
                }
                else {
                    b.append( order.orderComboLegs().size());

                    for (int i = 0; i < order.orderComboLegs().size(); i++) {
                        OrderComboLeg orderComboLeg = order.orderComboLegs().get(i);
                        b.appendMax( orderComboLeg.price());
                    }
                }
            }

            if(m_serverVersion >= MIN_SERVER_VER_SMART_COMBO_ROUTING_PARAMS && SecType.BAG.name().equalsIgnoreCase(contract.getSecType())) {
                ArrayList smartComboRoutingParams = order.smartComboRoutingParams();
                int smartComboRoutingParamsCount = smartComboRoutingParams == null ? 0 : smartComboRoutingParams.size();
                b.append( smartComboRoutingParamsCount);
                if( smartComboRoutingParamsCount > 0) {
                    for( int i = 0; i < smartComboRoutingParamsCount; ++i) {
                        TagValue tagValue = (TagValue)smartComboRoutingParams.get(i);
                        b.append( tagValue.m_tag);
                        b.append( tagValue.m_value);
                    }
                }
            }

            if ( m_serverVersion >= 9 ) {
            	// send deprecated sharesAllocation field
                b.append( "");
            }

            if ( m_serverVersion >= 10 ) {
                b.send( order.discretionaryAmt());
            }

            if ( m_serverVersion >= 11 ) {
                b.append( order.goodAfterTime());
            }

            if ( m_serverVersion >= 12 ) {
                b.append( order.goodTillDate());
            }

            if ( m_serverVersion >= 13 ) {
               b.append( order.faGroup());
               b.append( order.getFaMethod());
               b.append( order.faPercentage());
               b.append( order.faProfile());
           }
           if (m_serverVersion >= 18) { // institutional short sale slot fields.
               b.append( order.shortSaleSlot());      // 0 only for retail, 1 or 2 only for institution.
               b.append( order.designatedLocation()); // only populate when order.m_shortSaleSlot = 2.
           }
           if (m_serverVersion >= MIN_SERVER_VER_SSHORTX_OLD) {
               b.append( order.exemptCode());
           }
           if (m_serverVersion >= 19) {
               b.append( order.getOcaType());
               if (m_serverVersion < 38) {
            	   // will never happen
            	   b.send( /* order.m_rthOnly */ false);
               }
               b.append( order.getRule80A());
               b.append( order.settlingFirm());
               b.send( order.allOrNone());
               b.appendMax( order.minQty());
               b.appendMax( order.percentOffset());
               b.send( order.eTradeOnly());
               b.send( order.firmQuoteOnly());
               b.appendMax( order.nbboPriceCap());
               b.appendMax( order.auctionStrategy());
               b.appendMax( order.startingPrice());
               b.appendMax( order.stockRefPrice());
               b.appendMax( order.delta());
        	   // Volatility orders had specific watermark price attribs in server version 26
        	   double lower = (m_serverVersion == 26 && order.getOrderType().equals("VOL"))
        	   		? Double.MAX_VALUE
        	   		: order.stockRangeLower();
        	   double upper = (m_serverVersion == 26 && order.getOrderType().equals("VOL"))
   	   				? Double.MAX_VALUE
   	   				: order.stockRangeUpper();
               b.appendMax( lower);
               b.appendMax( upper);
           }

           if (m_serverVersion >= 22) {
               b.send( order.overridePercentageConstraints());
           }

           if (m_serverVersion >= 26) { // Volatility orders
               b.appendMax( order.volatility());
               b.append(order.getVolatilityType());
               if (m_serverVersion < 28) {
            	   b.send( order.getDeltaNeutralOrderType().equalsIgnoreCase("MKT"));
               } else {
            	   b.append( order.getDeltaNeutralOrderType());
            	   b.appendMax( order.deltaNeutralAuxPrice());

                   if (m_serverVersion >= MIN_SERVER_VER_DELTA_NEUTRAL_CONID && !IsEmpty(order.getDeltaNeutralOrderType())){
                       b.append( order.deltaNeutralConId());
                       b.append( order.deltaNeutralSettlingFirm());
                       b.append( order.deltaNeutralClearingAccount());
                       b.append( order.deltaNeutralClearingIntent());
                   }

                   if (m_serverVersion >= MIN_SERVER_VER_DELTA_NEUTRAL_OPEN_CLOSE && !IsEmpty(order.getDeltaNeutralOrderType())){
                       b.append( order.deltaNeutralOpenClose());
                       b.send( order.deltaNeutralShortSale());
                       b.append( order.deltaNeutralShortSaleSlot());
                       b.append( order.deltaNeutralDesignatedLocation());
                   }
               }
               b.append( order.continuousUpdate());
               if (m_serverVersion == 26) {
            	   // Volatility orders had specific watermark price attribs in server version 26
            	   double lower = order.getOrderType().equals("VOL") ? order.stockRangeLower() : Double.MAX_VALUE;
            	   double upper = order.getOrderType().equals("VOL") ? order.stockRangeUpper() : Double.MAX_VALUE;
                   b.appendMax( lower);
                   b.appendMax( upper);
               }
               b.append(order.getReferencePriceType());
           }

           if (m_serverVersion >= 30) { // TRAIL_STOP_LIMIT stop price
               b.appendMax( order.trailStopPrice());
           }

           if( m_serverVersion >= MIN_SERVER_VER_TRAILING_PERCENT){
               b.appendMax( order.trailingPercent());
           }

           if (m_serverVersion >= MIN_SERVER_VER_SCALE_ORDERS) {
        	   if (m_serverVersion >= MIN_SERVER_VER_SCALE_ORDERS2) {
        		   b.appendMax (order.scaleInitLevelSize());
        		   b.appendMax (order.scaleSubsLevelSize());
        	   }
        	   else {
        		   b.append ("");
        		   b.appendMax (order.scaleInitLevelSize());

        	   }
        	   b.appendMax (order.scalePriceIncrement());
           }

           if (m_serverVersion >= MIN_SERVER_VER_SCALE_ORDERS3 && order.scalePriceIncrement() > 0.0 && order.scalePriceIncrement() != Double.MAX_VALUE) {
               b.appendMax (order.scalePriceAdjustValue());
               b.appendMax (order.scalePriceAdjustInterval());
               b.appendMax (order.scaleProfitOffset());
               b.send (order.scaleAutoReset());
               b.appendMax (order.scaleInitPosition());
               b.appendMax (order.scaleInitFillQty());
               b.send (order.scaleRandomPercent());
           }

           if (m_serverVersion >= MIN_SERVER_VER_SCALE_TABLE) {
               b.append (order.scaleTable());
               b.append (order.activeStartTime());
               b.append (order.activeStopTime());
           }

           if (m_serverVersion >= MIN_SERVER_VER_HEDGE_ORDERS) {
        	   b.append (order.getHedgeType());
               if (!IsEmpty(order.getHedgeType())) {
        		   b.append (order.hedgeParam());
        	   }
           }

           if (m_serverVersion >= MIN_SERVER_VER_OPT_OUT_SMART_ROUTING) {
               b.send (order.optOutSmartRouting());
           }

           if (m_serverVersion >= MIN_SERVER_VER_PTA_ORDERS) {
        	   b.append (order.clearingAccount());
        	   b.append (order.clearingIntent());
           }

           if (m_serverVersion >= MIN_SERVER_VER_NOT_HELD) {
        	   b.send (order.notHeld());
           }

           if (m_serverVersion >= MIN_SERVER_VER_UNDER_COMP) {
        	   if (contract.underComp() != null) {
        		   DeltaNeutralContract underComp = contract.underComp();
        		   b.send( true);
        		   b.append( underComp.conid());
        		   b.send( underComp.delta());
        		   b.send( underComp.price());
        	   }
        	   else {
        		   b.send( false);
        	   }
           }

           if (m_serverVersion >= MIN_SERVER_VER_ALGO_ORDERS) {
        	   b.append( order.getAlgoStrategy());
               if( !IsEmpty(order.getAlgoStrategy())) {
        		   ArrayList algoParams = order.algoParams();
        		   int algoParamsCount = algoParams == null ? 0 : algoParams.size();
        		   b.append( algoParamsCount);
        		   if( algoParamsCount > 0) {
        			   for( int i = 0; i < algoParamsCount; ++i) {
        				   TagValue tagValue = (TagValue)algoParams.get(i);
        				   b.append( tagValue.m_tag);
        				   b.append( tagValue.m_value);
        			   }
        		   }
        	   }
           }
           
           if (m_serverVersion >= MIN_SERVER_VER_ALGO_ID) {
        	   b.append(order.algoId());
           }

           if (m_serverVersion >= MIN_SERVER_VER_WHAT_IF_ORDERS) {
        	   b.send (order.whatIf());
           }
           
           // send orderMiscOptions parameter
           if(m_serverVersion >= MIN_SERVER_VER_LINKING) {
               StringBuilder orderMiscOptionsStr = new StringBuilder();
               ArrayList orderMiscOptions = order.orderMiscOptions();
               int orderMiscOptionsCount = orderMiscOptions == null ? 0 : orderMiscOptions.size();
               if( orderMiscOptionsCount > 0) {
                   for( int i = 0; i < orderMiscOptionsCount; ++i) {
                       TagValue tagValue = (TagValue)orderMiscOptions.get(i);
                       orderMiscOptionsStr.append( tagValue.m_tag);
                       orderMiscOptionsStr.append( "=");
                       orderMiscOptionsStr.append( tagValue.m_value);
                       orderMiscOptionsStr.append( ";");
                   }
               }
               b.append( orderMiscOptionsStr.toString());
           }
           
           if (m_serverVersion >= MIN_SERVER_VER_ORDER_SOLICITED) {
        	   b.send(order.solicited());
           }
           closeAndSend(b);
        }
        catch( Exception e) {
            error( id, EClientErrors.FAIL_SEND_ORDER, "" + e);
            close();
        }
    }

    public synchronized void reqAccountUpdates(boolean subscribe, String acctCode) {
    	
    	Watchr.log(Level.INFO, "~ reqAccountUpdates");

        // not connected?
        if( !m_connected) {
            notConnected();
            return;
        }

        final int VERSION = 2;

        // send account data msg
        try {
            EWireBuilder b = prepareBuffer(); 

            b.append( REQ_ACCOUNT_DATA );
            b.append( VERSION);
            b.send( subscribe);

            // Send the account code. This will only be used for FA clients
            if ( m_serverVersion >= 9 ) {
                b.append( acctCode);
            }
            closeAndSend(b);
       }
        catch( Exception e) {
        	Watchr.log(Level.SEVERE, "ERROR: REQUEST ACCOUNT UPDATES: " + e.getMessage());

            error( EClientErrors.NO_VALID_ID, EClientErrors.FAIL_SEND_ACCT, "" + e);
            close();
        }
    }

    public synchronized void reqExecutions(int reqId, ExecutionFilter filter) {
    	
    	Watchr.log(Level.INFO, "~ reqExecutions");

        // not connected?
        if( !m_connected) {
            notConnected();
            return;
        }

        final int VERSION = 3;

        // send executions msg
        try {
            EWireBuilder b = prepareBuffer(); 

            b.append( REQ_EXECUTIONS);
            b.append( VERSION);

            if (m_serverVersion >= MIN_SERVER_VER_EXECUTION_DATA_CHAIN) {
            	b.append( reqId);
            }

            // Send the execution rpt filter data
            if ( m_serverVersion >= 9 ) {
                b.append( filter.clientId());
                b.append( filter.acctCode());

                // Note that the valid format for m_time is "yyyymmdd-hh:mm:ss"
                b.append( filter.time());
                b.append( filter.symbol());
                b.append( filter.secType());
                b.append( filter.exchange());
                b.append( filter.side());
            }
            closeAndSend(b);
        }
        catch( Exception e) {
        	Watchr.log(Level.SEVERE, "ERROR: EXECUTIONS: " + e.getMessage());
            error( EClientErrors.NO_VALID_ID, EClientErrors.FAIL_SEND_EXEC, "" + e);
            close();
        }
    }

    public synchronized void cancelOrder( int id) {
    	
    	Watchr.log(Level.INFO, "~ cancelOrder");

        // not connected?
        if( !m_connected) {
            notConnected();
            return;
        }

        final int VERSION = 1;

        // send cancel order msg
        try {
            EWireBuilder b = prepareBuffer(); 

            b.append( CANCEL_ORDER);
            b.append( VERSION);
            b.append( id);

            closeAndSend(b);
        }
        catch( Exception e) {
            error( id, EClientErrors.FAIL_SEND_CORDER, "" + e);
            close();
        }
    }

    public synchronized void reqOpenOrders() {
    	
    	Watchr.log(Level.INFO, "~ reqOpenOrders");

        // not connected?
        if( !m_connected) {
            notConnected();
            return;
        }

        final int VERSION = 1;

        // send open orders msg
        try {
            EWireBuilder b = prepareBuffer(); 

            b.append( REQ_OPEN_ORDERS);
            b.append( VERSION);

            closeAndSend(b);
        }
        catch( Exception e) {
        	Watchr.log(Level.SEVERE, "ERROR: OPEN ORDER: " + e.getMessage());
            error(EClientErrors.NO_VALID_ID, EClientErrors.FAIL_SEND_OORDER, "" + e);
            close();
        }
    }

    public synchronized void reqIds( int numIds) {
    	
    	Watchr.log(Level.INFO, "~ reqIds");

        // not connected?
        if( !m_connected) {
            notConnected();
            return;
        }

        final int VERSION = 1;

        try {
            EWireBuilder b = prepareBuffer(); 

            b.append( REQ_IDS);
            b.append( VERSION);
            b.append( numIds);

            closeAndSend(b);
       }
        catch( Exception e) {
        	Watchr.log(Level.SEVERE, "ERROR: REQUEST IDS: " + e.getMessage());
            error( EClientErrors.NO_VALID_ID, EClientErrors.FAIL_SEND_CORDER, "" + e);
            close();
        }
    }

    public synchronized void reqNewsBulletins( boolean allMsgs) {
    	
    	Watchr.log(Level.INFO, "~ reqNewsBulletins");

        // not connected?
        if( !m_connected) {
            notConnected();
            return;
        }

        final int VERSION = 1;

        try {
            EWireBuilder b = prepareBuffer(); 

            b.append( REQ_NEWS_BULLETINS);
            b.append( VERSION);
            b.send( allMsgs);

            closeAndSend(b);
       }
        catch( Exception e) {
        	Watchr.log(Level.SEVERE, "ERROR: NEWS BULLETIN: " + e.getMessage());
            error( EClientErrors.NO_VALID_ID, EClientErrors.FAIL_SEND_CORDER, "" + e);
            close();
        }
    }

    public synchronized void cancelNewsBulletins() {
    	
    	Watchr.log(Level.INFO, "~ cancelNewsBulletins");

        // not connected?
        if( !m_connected) {
            notConnected();
            return;
        }

        final int VERSION = 1;

        // send cancel news bulletins msg
        try {
            EWireBuilder b = prepareBuffer(); 

            b.append( CANCEL_NEWS_BULLETINS);
            b.append( VERSION);

            closeAndSend(b);
        }
        catch( Exception e) {
        	Watchr.log(Level.SEVERE, "ERROR: CANCEL NEWS BULLETIN " + e.getMessage());
            error( EClientErrors.NO_VALID_ID, EClientErrors.FAIL_SEND_CORDER, "" + e);
            close();
        }
    }

    public synchronized void setServerLogLevel(int logLevel) {
    	
    	Watchr.log(Level.INFO, "~ setServerLogLevel");

        // not connected?
        if( !m_connected) {
            notConnected();
            return;
        }

        final int VERSION = 1;

                // send the set server logging level message
                try {
                    EWireBuilder b = prepareBuffer(); 

                    b.append( SET_SERVER_LOGLEVEL);
                    b.append( VERSION);
                    b.append( logLevel);

                    closeAndSend(b);
               }
        catch( Exception e) {
        	Watchr.log(Level.SEVERE, "ERROR: SET LOG LEVEL: " + e.getMessage());
            error( EClientErrors.NO_VALID_ID, EClientErrors.FAIL_SEND_SERVER_LOG_LEVEL, "" + e);
            close();
        }
    }

    public synchronized void reqAutoOpenOrders(boolean bAutoBind) {
    	
    	Watchr.log(Level.INFO, "~ reqAutoOpenOrders");

        // not connected?
        if( !m_connected) {
            notConnected();
            return;
        }

        final int VERSION = 1;

        // send req open orders msg
        try {
            EWireBuilder b = prepareBuffer(); 

            b.append( REQ_AUTO_OPEN_ORDERS);
            b.append( VERSION);
            b.send( bAutoBind);

            closeAndSend(b);
        }
        catch( Exception e) {
        	Watchr.log(Level.SEVERE, "ERROR: OPEN ORDERS: " + e.getMessage());
            error(EClientErrors.NO_VALID_ID, EClientErrors.FAIL_SEND_OORDER, "" + e);
            close();
        }
    }

    public synchronized void reqAllOpenOrders() {
    	
    	Watchr.log(Level.INFO, "~ reqAllOpenOrders");

        // not connected?
        if( !m_connected) {
            notConnected();
            return;
        }

        final int VERSION = 1;

        // send req all open orders msg
        try {
            EWireBuilder b = prepareBuffer(); 

            b.append( REQ_ALL_OPEN_ORDERS);
            b.append( VERSION);

            closeAndSend(b);
        }
        catch( Exception e) {
        	Watchr.log(Level.SEVERE, "ERROR: ALL OPEN ORDERS: " + e.getMessage());
            error(EClientErrors.NO_VALID_ID, EClientErrors.FAIL_SEND_OORDER, "" + e);
            close();
        }
    }

    public synchronized void reqManagedAccts() {
    	
    	Watchr.log(Level.INFO, "~ reqManagedAccts");

        // not connected?
        if( !m_connected) {
            notConnected();
            return;
        }

        final int VERSION = 1;

        // send req FA managed accounts msg
        try {
            EWireBuilder b = prepareBuffer(); 

            b.append( REQ_MANAGED_ACCTS);
            b.append( VERSION);

            closeAndSend(b);
        }
        catch( Exception e) {
        	Watchr.log(Level.SEVERE, "ERROR: MANAGED ACCOUNTS: " + e.getMessage());
            error(EClientErrors.NO_VALID_ID, EClientErrors.FAIL_SEND_OORDER, "" + e);
            close();
        }
    }

    public synchronized void requestFA( int faDataType ) {
    	
    	Watchr.log(Level.INFO, "~ requestFA");

        // not connected?
        if( !m_connected) {
            notConnected();
            return;
        }

        // This feature is only available for versions of TWS >= 13
        if( m_serverVersion < 13) {
        	Watchr.log(Level.WARNING, "ERROR: FAC");

            message(EClientErrors.NO_VALID_ID, EClientErrors.UPDATE_TWS.code(),
                    EClientErrors.UPDATE_TWS.msg());
            return;
        }

        final int VERSION = 1;

        try {
            EWireBuilder b = prepareBuffer(); 

            b.append( REQ_FA );
            b.append( VERSION);
            b.append( faDataType);

            closeAndSend(b);
        }
        catch( Exception e) {
            error( faDataType, EClientErrors.FAIL_SEND_FA_REQUEST, "" + e);
            close();
        }
    }

    public synchronized void replaceFA( int faDataType, String xml ) {
    	
    	Watchr.log(Level.INFO, "~ replaceFA");

        // not connected?
        if( !m_connected) {
            notConnected();
            return;
        }

        // This feature is only available for versions of TWS >= 13
        if( m_serverVersion < 13) {
        	Watchr.log(Level.WARNING, "ERROR: REPLACE FAC");
            message(EClientErrors.NO_VALID_ID, EClientErrors.UPDATE_TWS.code(),
                    EClientErrors.UPDATE_TWS.msg());
            return;
        }

        final int VERSION = 1;

        try {
            EWireBuilder b = prepareBuffer(); 

            b.append( REPLACE_FA );
            b.append( VERSION);
            b.append( faDataType);
            b.append( xml);

            closeAndSend(b);
        }
        catch( Exception e) {
            error( faDataType, EClientErrors.FAIL_SEND_FA_REPLACE, "" + e);
            close();
        }
    }

    public synchronized void reqCurrentTime() {
    	
    	Watchr.log(Level.INFO, "~ reqCurrentTime");

        // not connected?
        if( !m_connected) {
            notConnected();
            return;
        }

        // This feature is only available for versions of TWS >= 33
        if( m_serverVersion < 33) {
        	Watchr.log(Level.WARNING, "UNSUPPORTED: CURRENT TIME");
            error(EClientErrors.NO_VALID_ID, EClientErrors.UPDATE_TWS,
                  "  It does not support current time requests.");
            return;
        }

        final int VERSION = 1;

        try {
            EWireBuilder b = prepareBuffer(); 

            b.append( REQ_CURRENT_TIME );
            b.append( VERSION);

            closeAndSend(b);
        }
        catch( Exception e) {
        	Watchr.log(Level.SEVERE, "CLIENT ERROR: CURRENT TIME..." + e.getMessage());
            error( EClientErrors.NO_VALID_ID, EClientErrors.FAIL_SEND_REQCURRTIME, "" + e);
            close();
        }
    }

    public synchronized void reqFundamentalData(int reqId, Contract contract, String reportType) {
    	
    	Watchr.log(Level.INFO, "~ reqFundamentalData");


        // not connected?
        if( !m_connected) {
            notConnected();
            return;
        }

        if( m_serverVersion < MIN_SERVER_VER_FUNDAMENTAL_DATA) {
        	error( reqId, EClientErrors.UPDATE_TWS,
        			"  It does not support fundamental data requests.");
        	return;
        }

        if( m_serverVersion < MIN_SERVER_VER_TRADING_CLASS) {
//            if( contract.conid() > 0) {
//                  error(reqId, EClientErrors.UPDATE_TWS,
//                      "  It does not support conId parameter in reqFundamentalData.");
//                  return;
//            }
        }

        final int VERSION = 2;

        try {
            // send req fund data msg
            EWireBuilder b = prepareBuffer(); 

            b.append( REQ_FUNDAMENTAL_DATA);
            b.append( VERSION);
            b.append( reqId);

            // send contract fields
            if( m_serverVersion >= MIN_SERVER_VER_TRADING_CLASS) {
                b.append(contract.conid());
            }
            b.append( contract.symbol());
            b.append( contract.getSecType());
            b.append( contract.exchange());
            b.append( contract.primaryExch());
            b.append( contract.currency());
            b.append( contract.localSymbol());

            b.append( reportType);

            closeAndSend(b);
        }
        catch( Exception e) {
            error( reqId, EClientErrors.FAIL_SEND_REQFUNDDATA, "" + e);
            close();
        }
    }

    public synchronized void cancelFundamentalData(int reqId) {
    	
    	Watchr.log(Level.INFO, "~ cancelFundamentalData");

        // not connected?
        if( !m_connected) {
            notConnected();
            return;
        }

        if( m_serverVersion < MIN_SERVER_VER_FUNDAMENTAL_DATA) {
        	error( reqId, EClientErrors.UPDATE_TWS,
        			"  It does not support fundamental data requests.");
        	return;
        }

        final int VERSION = 1;

        try {
            // send cancel fundamental data msg
            EWireBuilder b = prepareBuffer(); 

            b.append( CANCEL_FUNDAMENTAL_DATA);
            b.append( VERSION);
            b.append( reqId);

            closeAndSend(b);
       }
        catch( Exception e) {
            error( reqId, EClientErrors.FAIL_SEND_CANFUNDDATA, "" + e);
            close();
        }
    }

    public synchronized void calculateImpliedVolatility(int reqId, Contract contract,
            double optionPrice, double underPrice) {
    	
    	Watchr.log(Level.INFO, "~ calculateImpliedVolatility");


        // not connected?
        if( !m_connected) {
            notConnected();
            return;
        }

        if (m_serverVersion < MIN_SERVER_VER_REQ_CALC_IMPLIED_VOLAT) {
            error(reqId, EClientErrors.UPDATE_TWS,
                    "  It does not support calculate implied volatility requests.");
            return;
        }

        if (m_serverVersion < MIN_SERVER_VER_TRADING_CLASS) {
            if (!IsEmpty(contract.tradingClass())) {
                  error(reqId, EClientErrors.UPDATE_TWS,
                      "  It does not support tradingClass parameter in calculateImpliedVolatility.");
                  return;
            }
        }

        final int VERSION = 2;

        try {
            // send calculate implied volatility msg
            EWireBuilder b = prepareBuffer(); 

            b.append( REQ_CALC_IMPLIED_VOLAT);
            b.append( VERSION);
            b.append( reqId);

            // send contract fields
            b.append( contract.conid());
            b.append( contract.symbol());
            b.append( contract.getSecType());
            b.append( contract.expiry());
            b.send( contract.strike());
            b.append( contract.getRight());
            b.append( contract.multiplier());
            b.append( contract.exchange());
            b.append( contract.primaryExch());
            b.append( contract.currency());
            b.append( contract.localSymbol());
            if( m_serverVersion >= MIN_SERVER_VER_TRADING_CLASS) {
                b.append(contract.tradingClass());
            }

            b.send( optionPrice);
            b.send( underPrice);

            closeAndSend(b);
        }
        catch( Exception e) {
            error( reqId, EClientErrors.FAIL_SEND_REQCALCIMPLIEDVOLAT, "" + e);
            close();
        }
    }

    public synchronized void cancelCalculateImpliedVolatility(int reqId) {
    	
    	Watchr.log(Level.INFO, "~ cancelCalculateImpliedVolatility");

        // not connected?
        if( !m_connected) {
            notConnected();
            return;
        }

        if (m_serverVersion < MIN_SERVER_VER_CANCEL_CALC_IMPLIED_VOLAT) {
            error(reqId, EClientErrors.UPDATE_TWS,
                    "  It does not support calculate implied volatility cancellation.");
            return;
        }

        final int VERSION = 1;

        try {
            // send cancel calculate implied volatility msg
            EWireBuilder b = prepareBuffer(); 

            b.append( CANCEL_CALC_IMPLIED_VOLAT);
            b.append( VERSION);
            b.append( reqId);

            closeAndSend(b);
        }
        catch( Exception e) {
            error( reqId, EClientErrors.FAIL_SEND_CANCALCIMPLIEDVOLAT, "" + e);
            close();
        }
    }

    public synchronized void calculateOptionPrice(int reqId, Contract contract,
            double volatility, double underPrice) {

    	Watchr.log(Level.INFO, "~ calculateOptionPrice");

        // not connected?
        if( !m_connected) {
            notConnected();
            return;
        }

        if (m_serverVersion < MIN_SERVER_VER_REQ_CALC_OPTION_PRICE) {
            error(reqId, EClientErrors.UPDATE_TWS,
                    "  It does not support calculate option price requests.");
            return;
        }

        if (m_serverVersion < MIN_SERVER_VER_TRADING_CLASS) {
            if (!IsEmpty(contract.tradingClass())) {
                  error(reqId, EClientErrors.UPDATE_TWS,
                      "  It does not support tradingClass parameter in calculateOptionPrice.");
                  return;
            }
        }

        final int VERSION = 2;

        try {
            // send calculate option price msg
            EWireBuilder b = prepareBuffer(); 

            b.append( REQ_CALC_OPTION_PRICE);
            b.append( VERSION);
            b.append( reqId);

            // send contract fields
            b.append( contract.conid());
            b.append( contract.symbol());
            b.append( contract.getSecType());
            b.append( contract.expiry());
            b.send( contract.strike());
            b.append( contract.getRight());
            b.append( contract.multiplier());
            b.append( contract.exchange());
            b.append( contract.primaryExch());
            b.append( contract.currency());
            b.append( contract.localSymbol());
            if( m_serverVersion >= MIN_SERVER_VER_TRADING_CLASS) {
                b.append(contract.tradingClass());
            }

            b.send( volatility);
            b.send( underPrice);

            closeAndSend(b);
        }
        catch( Exception e) {
            error( reqId, EClientErrors.FAIL_SEND_REQCALCOPTIONPRICE, "" + e);
            close();
        }
    }

    public synchronized void cancelCalculateOptionPrice(int reqId) {

    	Watchr.log(Level.INFO, "~ cancelCalculateOptionPrice");

        // not connected?
        if( !m_connected) {
            notConnected();
            return;
        }

        if (m_serverVersion < MIN_SERVER_VER_CANCEL_CALC_OPTION_PRICE) {
            error(reqId, EClientErrors.UPDATE_TWS,
                    "  It does not support calculate option price cancellation.");
            return;
        }

        final int VERSION = 1;

        try {
            // send cancel calculate option price msg
            EWireBuilder b = prepareBuffer(); 

            b.append( CANCEL_CALC_OPTION_PRICE);
            b.append( VERSION);
            b.append( reqId);

            closeAndSend(b);
        }
        catch( Exception e) {
            error( reqId, EClientErrors.FAIL_SEND_CANCALCOPTIONPRICE, "" + e);
            close();
        }
    }

    public synchronized void reqGlobalCancel() {
    	
    	Watchr.log(Level.INFO, "~ reqGlobalCancel");

        // not connected?
        if( !m_connected) {
            notConnected();
            return;
        }

        if (m_serverVersion < MIN_SERVER_VER_REQ_GLOBAL_CANCEL) {
        	Watchr.log(Level.WARNING, "ERROR: SERVER VERSION IN GLOBAL CANCEL");
            error(EClientErrors.NO_VALID_ID, EClientErrors.UPDATE_TWS,
                    "  It does not support globalCancel requests.");
            return;
        }

        final int VERSION = 1;

        // send request global cancel msg
        try {
            EWireBuilder b = prepareBuffer(); 

            b.append( REQ_GLOBAL_CANCEL);
            b.append( VERSION);

            closeAndSend(b);
        }
        catch( Exception e) {
        	Watchr.log(Level.SEVERE, "ERROR: SEND GLOBAL CANCEL..." + e.getMessage());
            error( EClientErrors.NO_VALID_ID, EClientErrors.FAIL_SEND_REQGLOBALCANCEL, "" + e);
            close();
        }
    }

    public synchronized void reqMarketDataType(int marketDataType) {
    	
    	Watchr.log(Level.INFO, "~ reqMarketDataType");

        // not connected?
        if( !m_connected) {
            notConnected();
            return;
        }

        if (m_serverVersion < MIN_SERVER_VER_REQ_MARKET_DATA_TYPE) {
        	Watchr.log(Level.WARNING, "ERROR: MarketData Type");
            error(EClientErrors.NO_VALID_ID, EClientErrors.UPDATE_TWS,
                    "  It does not support marketDataType requests.");
            return;
        }

        final int VERSION = 1;

        // send the reqMarketDataType message
        try {
            EWireBuilder b = prepareBuffer(); 

            b.append( REQ_MARKET_DATA_TYPE);
            b.append( VERSION);
            b.append( marketDataType);

            closeAndSend(b);
        }
        catch( Exception e) {
        	Watchr.log(Level.SEVERE, "ERROR: SEND MARKET DATA TYPE..." + e.getMessage());
            error( EClientErrors.NO_VALID_ID, EClientErrors.FAIL_SEND_REQMARKETDATATYPE, "" + e);
            close();
        }
    }

    public synchronized void reqPositions() {
    	
    	Watchr.log(Level.INFO, "~ reqPositions");

        // not connected?
        if( !m_connected) {
            notConnected();
            return;
        }

        if (m_serverVersion < MIN_SERVER_VER_ACCT_SUMMARY) {
        	Watchr.log(Level.WARNING, "ERROR: REQUEST POSITIONS SERVER VERSION");
            error(EClientErrors.NO_VALID_ID, EClientErrors.UPDATE_TWS,
            "  It does not support position requests.");
            return;
        }

        final int VERSION = 1;

        EWireBuilder b = prepareBuffer();

        b.append( REQ_POSITIONS);
        b.append( VERSION);

        try {
            closeAndSend(b);
        }
        catch (IOException e) {
        	Watchr.log(Level.SEVERE, "ERROR: REQUEST POSITIONS..." + e.getMessage());
            error( EClientErrors.NO_VALID_ID, EClientErrors.FAIL_SEND_REQPOSITIONS, "" + e);
        }
    }

    public synchronized void cancelPositions() {
    	
    	Watchr.log(Level.INFO, "~ cancelPositions");

        // not connected?
        if( !m_connected) {
            notConnected();
            return;
        }

        if (m_serverVersion < MIN_SERVER_VER_ACCT_SUMMARY) {
        	Watchr.log(Level.WARNING, "ERROR: SERVER VERSION IN ACCOUNT SUMMARY");
            error(EClientErrors.NO_VALID_ID, EClientErrors.UPDATE_TWS,
            "  It does not support position cancellation.");
            return;
        }

        final int VERSION = 1;

        EWireBuilder b = prepareBuffer();

        b.append( CANCEL_POSITIONS);
        b.append( VERSION);

        try {
            closeAndSend(b);
        }
        catch (IOException e) {
        	Watchr.log(Level.SEVERE, "ERROR: SEND ACCOUNT SUMMARY..." + e.getMessage());
            error( EClientErrors.NO_VALID_ID, EClientErrors.FAIL_SEND_CANPOSITIONS, "" + e);
        }
    }

    public synchronized void reqAccountSummary( int reqId, String group, String tags) {
    	
		Watchr.log(Level.INFO, "~ reqAccountSummary");

        // not connected?
        if( !m_connected) {
            notConnected();
            return;
        }

        if (m_serverVersion < MIN_SERVER_VER_ACCT_SUMMARY) {
    		Watchr.log(Level.WARNING, "ERROR: SERVER VERSION IN REQUEST ACCOUNT SUMMARY");
            error(EClientErrors.NO_VALID_ID, EClientErrors.UPDATE_TWS,
            "  It does not support account summary requests.");
            return;
        }

        final int VERSION = 1;

        EWireBuilder b = prepareBuffer();

        b.append( REQ_ACCOUNT_SUMMARY);
        b.append( VERSION);
        b.append( reqId);
        b.append( group);
        b.append( tags);

        try {
            closeAndSend(b);
        }
        catch (IOException e) {
        	Watchr.log(Level.SEVERE, "ERROR: SERVER VERSION IN SEND ACCOUNT SUMMARY" + e.getMessage());

            error( EClientErrors.NO_VALID_ID, EClientErrors.FAIL_SEND_REQACCOUNTDATA, "" + e);
        }
    }

	public synchronized void cancelAccountSummary( int reqId) {
		
		Watchr.log(Level.INFO, "~ cancelAccountSummary");

        // not connected?
        if( !m_connected) {
            notConnected();
            return;
        }

        if (m_serverVersion < MIN_SERVER_VER_ACCT_SUMMARY) {
    		Watchr.log(Level.WARNING, "ERROR: SERVER VERSION IN CANCEL ACCOUNT SUMMARY");
            error(EClientErrors.NO_VALID_ID, EClientErrors.UPDATE_TWS,
            "  It does not support account summary cancellation.");
            return;
        }

        final int VERSION = 1;

        EWireBuilder b = prepareBuffer();

        b.append( CANCEL_ACCOUNT_SUMMARY);
        b.append( VERSION);
        b.append( reqId);

        try {
            closeAndSend(b);
        }
        catch (IOException e) {
        	Watchr.log(Level.SEVERE, "ERROR: SERVER VERSION IN SEND CANCEL ACCOUNT SUMMARY" + e.getMessage());
            error( EClientErrors.NO_VALID_ID, EClientErrors.FAIL_SEND_CANACCOUNTDATA, "" + e);
        }
    }
    public synchronized void verifyRequest( String apiName, String apiVersion) {
    	
		Watchr.log(Level.INFO, "~ verifyRequest");

        // not connected?
        if( !m_connected) {
            notConnected();
            return;
        }

        if (m_serverVersion < MIN_SERVER_VER_LINKING) {
    		Watchr.log(Level.WARNING, "ERROR: SERVER VERSION IN VERIFY REQUEST");
            error(EClientErrors.NO_VALID_ID, EClientErrors.UPDATE_TWS,
            "  It does not support verification request.");
            return;
        }

        if (!m_extraAuth) {
    		Watchr.log(Level.WARNING, "ERROR: SERVER VERSION IN SEND VERIFY MESSAGE");
            error( EClientErrors.NO_VALID_ID, EClientErrors.FAIL_SEND_VERIFYMESSAGE,
            "  Intent to authenticate needs to be expressed during initial connect request.");
            return;
        }

        final int VERSION = 1;

        EWireBuilder b = prepareBuffer();
        b.append( VERIFY_REQUEST);
        b.append( VERSION);
        b.append( apiName);
        b.append( apiVersion);

        try {
            closeAndSend(b);
        }
        catch (IOException e) {
        	Watchr.log(Level.SEVERE, "ERROR: FAIL VERIFY REQUEST" + e.getMessage());
            error( EClientErrors.NO_VALID_ID, EClientErrors.FAIL_SEND_VERIFYREQUEST, "" + e);
        }
    }

    public synchronized void verifyMessage( String apiData) {
    	
		Watchr.log(Level.INFO, "~ verifyMessage");

        // not connected?
        if( !m_connected) {
            notConnected();
            return;
        }

        if (m_serverVersion < MIN_SERVER_VER_LINKING) {
    		Watchr.log(Level.WARNING, "ERROR: SERVER VERSION IN VERIFY MESSAGE");
            error(EClientErrors.NO_VALID_ID, EClientErrors.UPDATE_TWS,
            "  It does not support verification message sending.");
            return;
        }

        final int VERSION = 1;

        EWireBuilder b = prepareBuffer();
        b.append( VERIFY_MESSAGE);
        b.append( VERSION);
        b.append( apiData);

        try {
            closeAndSend(b);
        }
        catch (IOException e) {
    		Watchr.log(Level.SEVERE, "ERROR: SEND ERROR IN VERIFY MESSAGE" + e.getMessage());
            error( EClientErrors.NO_VALID_ID, EClientErrors.FAIL_SEND_VERIFYMESSAGE, "" + e);
        }
    }

    public synchronized void verifyAndAuthRequest( String apiName, String apiVersion, String opaqueIsvKey) {
    	
		Watchr.log(Level.INFO, "~ verifyAndAuthRequest");

        // not connected?
        if( !m_connected) {
            notConnected();
            return;
        }

        if( m_serverVersion < MIN_SERVER_VER_LINKING_AUTH) {
    		Watchr.log(Level.WARNING, "ERROR: SERVER VERSION IN AUTH REQUEST");
            error(EClientErrors.NO_VALID_ID, EClientErrors.UPDATE_TWS,
            "  It does not support verification request.");
            return;
        }

        if( !m_extraAuth) {
    		Watchr.log(Level.WARNING, "ERROR: INITIAL CONNECT AUTH REQUEST");
            error( EClientErrors.NO_VALID_ID, EClientErrors.FAIL_SEND_VERIFYANDAUTHREQUEST,
            "  Intent to authenticate needs to be expressed during initial connect request.");
            return;
        }

        final int VERSION = 1;

        EWireBuilder b = prepareBuffer();
        b.append( VERIFY_AND_AUTH_REQUEST);
        b.append( VERSION);
        b.append( apiName);
        b.append( apiVersion);
        b.append( opaqueIsvKey);

        try {
            closeAndSend(b);
        }
        catch (IOException e) {
    		Watchr.log(Level.SEVERE, "ERROR: VERIFY AUTH REQUEST..." + e.getMessage());
            error( EClientErrors.NO_VALID_ID, EClientErrors.FAIL_SEND_VERIFYANDAUTHREQUEST, "" + e);
        }
    }

    public synchronized void verifyAndAuthMessage( String apiData, String xyzResponse) {
    	
		Watchr.log(Level.INFO, "~ verifyAndAuthMessage");

        // not connected?
        if( !m_connected) {
            notConnected();
            return;
        }

        if( m_serverVersion < MIN_SERVER_VER_LINKING_AUTH) {
    		Watchr.log(Level.WARNING, "ERROR: SERVER VERSION FOR VERIFY AUTH");
            error( EClientErrors.NO_VALID_ID, EClientErrors.UPDATE_TWS,
            "  It does not support verification message sending.");
            return;
        }

        final int VERSION = 1;

        EWireBuilder b = prepareBuffer();
        b.append( VERIFY_AND_AUTH_MESSAGE);
        b.append( VERSION);
        b.append( apiData);
        b.append( xyzResponse);

        try {
            closeAndSend(b);
        }
        catch (IOException e) {
    		Watchr.log(Level.SEVERE, "ERROR: SEND SERVER VERSION FOR VERIFY AUTH..." + e.getMessage());
            error( EClientErrors.NO_VALID_ID, EClientErrors.FAIL_SEND_VERIFYANDAUTHMESSAGE, "" + e);
        }
    }

	public synchronized void queryDisplayGroups( int reqId) {
		
		Watchr.log(Level.INFO, "~ queryDisplayGroups");

        // not connected?
        if( !m_connected) {
            notConnected();
            return;
        }

        if (m_serverVersion < MIN_SERVER_VER_LINKING) {
    		Watchr.log(Level.WARNING, "ERROR: SERVER IN DISPLAY GROUPS");
            error(EClientErrors.NO_VALID_ID, EClientErrors.UPDATE_TWS,
            "  It does not support queryDisplayGroups request.");
            return;
        }

        final int VERSION = 1;

        EWireBuilder b = prepareBuffer();

        b.append( QUERY_DISPLAY_GROUPS);
        b.append( VERSION);
        b.append( reqId);

        try {
            closeAndSend(b);
        }
        catch (IOException e) {
    		Watchr.log(Level.SEVERE, "ERROR: SEND DISPLAY GROUPS..." + e.getMessage());
            error( EClientErrors.NO_VALID_ID, EClientErrors.FAIL_SEND_QUERYDISPLAYGROUPS, "" + e);
        }
    }
	
	public synchronized void subscribeToGroupEvents( int reqId, int groupId) {
		
		Watchr.log(Level.INFO, "~ subscribeToGroupEvents");

        // not connected?
        if( !m_connected) {
            notConnected();
            return;
        }

        if (m_serverVersion < MIN_SERVER_VER_LINKING) {
    		Watchr.log(Level.WARNING, "ERROR: SERVER IN GROUP EVENTS");
            error(EClientErrors.NO_VALID_ID, EClientErrors.UPDATE_TWS,
            "  It does not support subscribeToGroupEvents request.");
            return;
        }

        final int VERSION = 1;

        EWireBuilder b = prepareBuffer();

        b.append( SUBSCRIBE_TO_GROUP_EVENTS);
        b.append( VERSION);
        b.append( reqId);
        b.append( groupId);

        try {
            closeAndSend(b);
        }
        catch (IOException e) {
    		Watchr.log(Level.SEVERE, "ERROR: SERVER IN SEND GROUP EVENTS..." + e.getMessage());
            error( EClientErrors.NO_VALID_ID, EClientErrors.FAIL_SEND_SUBSCRIBETOGROUPEVENTS, "" + e);
        }
    }	

	public synchronized void updateDisplayGroup( int reqId, String contractInfo) {
		
		Watchr.log(Level.INFO, "~ updateDisplayGroup");

        // not connected?
        if( !m_connected) {
            notConnected();
            return;
        }

        if (m_serverVersion < MIN_SERVER_VER_LINKING) {
    		Watchr.log(Level.WARNING, "ERROR: SERVER IN UPDATE GROUP");
            error(EClientErrors.NO_VALID_ID, EClientErrors.UPDATE_TWS,
            "  It does not support updateDisplayGroup request.");
            return;
        }

        final int VERSION = 1;

        EWireBuilder b = prepareBuffer();

        b.append( UPDATE_DISPLAY_GROUP);
        b.append( VERSION);
        b.append( reqId);
        b.append( contractInfo);

        try {
            closeAndSend(b);
        }
        catch (IOException e) {
    		Watchr.log(Level.SEVERE, "ERROR: SEND UPDATE GROUP..." + e.getMessage());
            error( EClientErrors.NO_VALID_ID, EClientErrors.FAIL_SEND_UPDATEDISPLAYGROUP, "" + e);
        }
    }	

	public synchronized void unsubscribeFromGroupEvents( int reqId) {
		
		Watchr.log(Level.INFO, "~ unsubscribeFromGroupEvents");

        // not connected?
        if( !m_connected) {
            notConnected();
            return;
        }

        if (m_serverVersion < MIN_SERVER_VER_LINKING) {
    		Watchr.log(Level.WARNING, "ERROR: SERVER IN UNSUBSCRIBE GROUP");
            error(EClientErrors.NO_VALID_ID, EClientErrors.UPDATE_TWS,
            "  It does not support unsubscribeFromGroupEvents request.");
            return;
        }

        final int VERSION = 1;

        EWireBuilder b = prepareBuffer();

        b.append( UNSUBSCRIBE_FROM_GROUP_EVENTS);
        b.append( VERSION);
        b.append( reqId);

        try {
            closeAndSend(b);
        }
        catch (IOException e) {
    		Watchr.log(Level.SEVERE, "ERROR: SERVER IN SEND UNSUBSCRIBE GROUP..." + e.getMessage());
            error( EClientErrors.NO_VALID_ID, EClientErrors.FAIL_SEND_UNSUBSCRIBEFROMGROUPEVENTS, "" + e);
        }
    }	
	
    /** @deprecated, never called. */
    public synchronized void error( String err) {

		Watchr.log(Level.INFO, "~ IBerror: " + err);

        m_eWrapper.error( err);
    }

    public synchronized void message( int id, int code, String message) {
    	
		// Watchr.log(Level.WARNING, "~ IBmessage: " + "-ID " + id + " -CODE " + code + " -MESSAGE " +message);

        m_eWrapper.error( id, code, message);
    }

    protected void error(int id, EClientErrors.CodeMsgPair pair, String tail) {
    	
    	Watchr.log(Level.WARNING, "~ IBerror: " + "-ID " + id + " -PAIR " + pair.toString()  + " -TAIL " + tail);

        message(id, pair.code(), pair.msg() + tail);
    }

    public void close() {
    	
    	Watchr.log(Level.INFO, "~ close");

        eDisconnect();
        wrapper().connectionClosed();
    }
    
    protected EWireBuilder prepareBuffer() {
    	
    	Watchr.log(Level.INFO, "~ prepareBuffer");

        EWireBuilder buf = new EWireBuilder( 1024 );
        if( m_useV100Plus ) {
            buf.allocateLengthHeader();
        }
        return buf;
    }
    
    protected void closeAndSend(EWireBuilder buf) throws IOException {
    	
    	Watchr.log(Level.INFO, "~ closeAndSend");

    	Watchr.log(Level.INFO, "WIRED " + buf.toString());
    	
    	if( m_useV100Plus ) {
    		buf.updateLength( 0 ); // New buffer means length header position is always zero
    	}
    	buf.writeTo( m_dos );
    }
    
   // Sends String without length prefix (pre-V100 style)
   protected void send( String str) throws IOException {
	   
	   Watchr.log(Level.INFO, "~ send");

        // Write string to data buffer
    	EWireBuilder b = new EWireBuilder( 1024 );
    	
    	b.append(str);
    	b.writeTo( m_dos );
    }

    private void sendV100APIHeader() throws IOException {
    	
    	Watchr.log(Level.INFO, "~ sendV100APIHeader");

    	EWireBuilder bos = new EWireBuilder(1024);
    	bos.send("API\0".getBytes());
    
    	String out = "v" + (( MIN_VERSION < MAX_VERSION ) 
    			? MIN_VERSION + ".." + MAX_VERSION
				: MIN_VERSION);
    	
    	if ( !IsEmpty( m_connectOptions ) ) { 
    		out += " " + m_connectOptions;
    	}

    	int lengthPos = bos.allocateLengthHeader();
    	bos.send( out.getBytes() );
    	bos.updateLength( lengthPos );
    	bos.writeTo( m_dos );
    }

    protected void send( int val) throws IOException {
    	
    	Watchr.log(Level.INFO, "~ send");

        send( String.valueOf( val) );
    }

    private static boolean IsEmpty(String str) {
    	
    	Watchr.log(Level.INFO, "~ IsEmpty");

    	return Util.StringIsEmpty(str);
    }

    protected void notConnected() {
    	
    	Watchr.log(Level.INFO, "~ notConnected");
    	Watchr.log(Level.WARNING, "ERROR: NOT CONNECTED");
        error(EClientErrors.NO_VALID_ID, EClientErrors.NOT_CONNECTED, "");
        
        
    }
}
