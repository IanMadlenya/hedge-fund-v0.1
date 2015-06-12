package com.onenow.io;

import javax.sql.DataSource;

import com.amazonaws.regions.Region;
import com.onenow.constant.StreamName;
import com.onenow.constant.InvDataSource;
import com.onenow.constant.InvDataTiming;
import com.onenow.constant.SamplingRate;
import com.onenow.constant.TradeType;
import com.onenow.data.DataSampling;
import com.onenow.data.EventActivity;
import com.onenow.data.Event;
import com.onenow.data.EventRequest;
import com.onenow.instrument.Investment;
import com.onenow.instrument.InvestmentOption;
import com.onenow.instrument.Underlying;

/**
 * Generate the database key for individual time series and data points
 *
 */
public class Lookup {
	
	public Lookup() {
		
	}

	/**
	 * Key to find, for a specific point in time, the price/size for an investment
	 * @param time
	 * @param inv
	 * @param tradeType
	 * @return
	 */
	public static String getEventTimedKey(EventRequest event) {
		String s = "";
		s = s + event.toDashedDate.toString(); // time -> toDashedDate
		s = s + "-" + getEventKey(event);
		return s;
	}
	
	/**
	 * Key to find price/size values for specific investments
	 * @param inv
	 * @param tradeType
	 * @return
	 */
	public static String getEventKey(Event event) {
		String s = ""; 
	
		try {
			Underlying under = event.investment.getUnder();
			s = s + under.getTicker() + "-" + event.investment.getInvType();		
			if (event.investment instanceof InvestmentOption) {
				String exp = (String) ((InvestmentOption) event.investment).getExpirationDate();
				Double strike = ((InvestmentOption) event.investment).getStrikePrice();
				s = s + "-" + exp + "-" + strike; 
			}
			s = s + "-" + event.tradeType.toString();
			s = s + "-" + event.source.toString() + "-" + event.timing.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return (s);
	}
	
	/**
	 * Key to find the latest time stamp available for an investment
	 * @param inv
	 * @param tradeType
	 * @param timeStamp
	 * @return
	 */
	public static String getTimestampKey(Investment inv, TradeType tradeType, Long timeStamp) {
		String s = "";
		s = inv.toString();
		s = s + "-" + tradeType.toString();
		return s;
	}

	
	public static String getChartKey(EventRequest request) {
		String s = "";
		s = s + request.investment.toString();
		s = s + "-" + request.tradeType.toString();
		s = s + "-" + request.sampling.toString();
//		s = s + "-" + fromDate + "-" + toDate;
		s = s + "-" + request.toDashedDate;
		s = s + "-" + request.source.toString() + "-" + request.timing.toString();
//		System.out.println("key " + s);
		return s;
	}
	
	
	public static String getKinesisKey(Region region) {
		String s = "";
		s = s + region.toString();
		return s;
	}
}



