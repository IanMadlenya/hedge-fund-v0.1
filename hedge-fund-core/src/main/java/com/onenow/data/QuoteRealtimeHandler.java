package com.onenow.data;

import java.util.logging.Level;

import javax.swing.table.AbstractTableModel;

import com.ib.client.TickType;
import com.ib.client.Types.MktDataType;
import com.onenow.constant.InvType;
import com.onenow.execution.Contract;
import com.onenow.execution.ContractFactory;
import com.onenow.instrument.Investment;
import com.onenow.portfolio.BusController.ITopMktDataHandler;
import com.onenow.util.Watchr;

public class QuoteRealtimeHandler implements ITopMktDataHandler {
	
	// time
	long m_lastTime;

	// price
	double m_bid;
	double m_ask;
	double m_last;
	double m_close;
	
	// size
	int m_askSize;
	int m_bidSize;
	int m_volume;

	// added:
	public Investment investment;
	
	// other
	boolean m_frozen;

	// table
	protected AbstractTableModel chainTable;

	
	public QuoteRealtimeHandler() {
		
	}
	
	public QuoteRealtimeHandler(Investment inv, AbstractTableModel chainTable) {
		this.investment = inv;
		this.chainTable = chainTable;
	}
	
	public Contract getContract() {
		return ContractFactory.getContract(investment);
	}
	

	@Override
	public void tickPrice(TickType tickType, double price, int canAutoExecute) {
				
		switch( tickType) {
		case BID:
			m_bid = price;
//			Watchr.log(Level.INFO, ">Bid " + m_bid + " for " + investment.toString());
			// marketPrice.writePriceNotRealTime(investment, m_bid, TradeType.SELL.toString());
			break;
		case ASK:
			m_ask = price;
//			Watchr.log(Level.INFO, ">Ask " + m_ask + " for " + investment.toString());
			// marketPrice.writePriceNotRealTime(investment, m_ask, TradeType.BUY.toString());
			break;
		case LAST:
			m_last = price;
//			Watchr.log(Level.INFO, ">Last " + m_last + " for " + investment.toString());
			// marketPrice.writePriceNotRealTime(investment, m_last, TradeType.TRADED.toString());
			break;
		case CLOSE:
			m_close = price;
//			Watchr.log(Level.INFO, ">Close " + m_close + " for " + investment.toString());
			// marketPrice.writePriceNotRealTime(investment, m_close, TradeType.CLOSE.toString());
			break;
		case HIGH:
			// TODO
			break;
		case LOW:
			// TODO
			break;
		case OPTION_HISTORICAL_VOL:
			// TODO
//			Watchr.log(Level.INFO, ">HistoricalVolatility " + m_close + " for " + investment.toString());
			break;
		case OPTION_IMPLIED_VOL:
			// TODO
			break;
		case RT_HISTORICAL_VOL:
			// TODO!!!!!
			break;
		default:
			Watchr.log(Level.WARNING, 	"$$$$$ tickPrice: " + " -tickType " + tickType +
					" -for " + investment.toString());
			break;	
		}
		
		chainTable.fireTableDataChanged();
	}

	@Override
	public void tickSize(TickType tickType, int size) {
						
		// TODO
		// TICKSIZE: -TICKTYPE OPTION_CALL_OPEN_INTEREST -SIZE 0 FOR -UNDER SPX -TYPE PUT -EXPIRES 20150626 -STRIKE 2100.0  
		
		switch( tickType) {
		case BID_SIZE:
			m_bidSize = size;
//			marketPrice.writeSizeNotRealTime(investment, m_bidSize, InvDataType.BIDSIZE.toString());
			// Watchr.log(Level.INFO, ">Bid size " + m_bidSize + " for " + investment.toString());
			break;
		case ASK_SIZE:
			m_askSize = size;
//			marketPrice.writeSizeNotRealTime(investment, m_askSize, InvDataType.ASKSIZE.toString());
			// Watchr.log(Level.INFO, ">Ask size " + m_askSize + " for " + investment.toString());
			break;
		case VOLUME:
			m_volume = size;
//			marketPrice.writeSizeNotRealTime(investment, m_volume, InvDataType.VOLUME.toString());
			// Watchr.log(Level.INFO, ">Volume size " + m_volume + " for " + investment.toString());
			break;
		case OPTION_CALL_VOLUME:
			// TODO
			break;
		case OPTION_PUT_VOLUME:
			// TODO
			break;
		case OPTION_CALL_OPEN_INTEREST:
			// TODO
			break;
		case OPTION_PUT_OPEN_INTEREST:
			// TODO
			break;
		case LAST_SIZE:
			// TODO
			break;
		case AUCTION_VOLUME:
			// TODO
			break;
		case AUCTION_IMBALANCE:
			// TODO
			break;
		case REGULATORY_IMBALANCE:
			// TODO
			break;
		case AUCTION_PRICE:
			// TODO
			break;
		case OPEN:
			// TODO
			break;
		case HIGH_13_WEEK:
			// TODO
			break;
		case HIGH_26_WEEK:
			// TODO
			break;
		case HIGH_52_WEEK:
			// TODO
			break;
		case LOW_13_WEEK:
			// TODO
			break;
		case LOW_26_WEEK:
			// TODO
			break;
		case LOW_52_WEEK:
			// TODO
			break;
        default:
    		Watchr.log(Level.WARNING, 	"$$$$$ tickSize:" + " -tickType: " + tickType +
					" -for " + investment.toString());
        	break; 
		}
		
		chainTable.fireTableDataChanged();
	}

	@Override
	public void tickString(TickType tickType, String value) {
					
		switch( tickType) {
		case LAST_TIMESTAMP:
			m_lastTime = Long.parseLong(value);
			// Watchr.log(Level.INFO, ">LAST_TIMESTAMP " + m_lastTime + " for " + investment.toString());
			break;
		case AVG_VOLUME:
			// Watchr.log(Level.INFO, ">AVG_VOLUME " + value + " for " + investment.toString()); // not for indices
			break;
		case OPTION_CALL_VOLUME:
			// Watchr.log(Level.INFO, ">OPTION_CALL_VOLUME " + value + " for " + investment.toString()); // stocks 
			break;
		case OPTION_PUT_VOLUME:
			// Watchr.log(Level.INFO, ">OPTION_PUT_VOLUME " + value + " for " + investment.toString()); // stocks
			break;
		case AUCTION_VOLUME:
			// Watchr.log(Level.INFO, ">AUCTION_VOLUME " + value + " for " + investment.toString()); // subscribe to
			break;
		case RT_VOLUME:
			Watchr.log(Level.INFO, ">>>>> RT_VOLUME " + value + " for " + investment.toString()); 
			MarketPrice.parseAndWriteRealTime(investment, value);
			// Example: RT_VOLUME 0.60;1;1424288913903;551;0.78662433;true
			break;
		case VOLUME_RATE:
			// Watchr.log(Level.INFO, ">VOLUME_RATE " + value + " for " + investment.toString()); // not for indices
			break;
		case BID_EXCH:
			// TODO
			break;
		case ASK_EXCH:
			// TODO
			break;
        default:
    		Watchr.log(Level.WARNING, 	"$$$$$ tickString: " + " -tickType " + tickType +
					" -for " + investment.toString());
        	break; 
		}
		
		chainTable.fireTableDataChanged();
	}

	@Override
	public void tickSnapshotEnd() {
		Watchr.log(Level.SEVERE, "call to empty: tickSnapshotEnd" + " for " + investment.toString());		
	}

	@Override
	public void marketDataType(MktDataType marketDataType) {
				
		m_frozen = marketDataType == MktDataType.Frozen;
		
		chainTable.fireTableDataChanged();

	}


	public String toString() {
		String s = "";

		s = s + "*** QUOTE HANDLER " + " ";
		s = s + "-lastTime " + m_lastTime + " ";
		s = s + "-investment " + investment + " ";
		s = s + "-bid " + m_bid + " ";
		s = s + "-ask " + m_ask + " ";
		s = s + "-last " + m_last + " ";
		s = s + "-close " + m_close + " ";
		s = s + "-askSize " + m_askSize + " ";
		s = s + "-bidSize " + m_bidSize + " ";
		s = s + "-volume " + m_volume + " ";
		s = s + "-frozen " + m_frozen;

		return s;
	}
}
