package com.onenow.data;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.ib.controller.Formats;

public class EventActivityHistory extends EventActivity {
	
	// meta
	private int reqId = 0;

	// candle
	public final double high;
	public final double low;
	public final double open;
	public final double close;
	
	// weight
	public final Long volume; 

	// other
	public final double wap;
	public final int count;
	
	
//	public EventHistory() {
//	
//	}

	// TODO: what time zone is this time?
	public EventActivityHistory( 	int reqId, 
							long time, double high, double low, double open, double close, double wap, long volume, int count) {
		
		this.reqId = reqId;
		this.high = high;
		this.low = low;
		this.open = open;
		this.close = close;
		this.wap = wap;
		this.volume = volume;
		this.count = count;
		
		// for general use (EventActivity)
		this.time = time*1000;
		this.price = open;
		this.size = volume;
		
	}
	
	@Override public String toString() {
		String s = "";
		
		s = String.format(	super.toString() + " " +
							"-reqID " + reqId + " " + 
							"-open " + open + " " +
							"-high " +  high + " " +
							"-low " + low + " " +
							"-close " + close );

		return s;
	}
		
}
