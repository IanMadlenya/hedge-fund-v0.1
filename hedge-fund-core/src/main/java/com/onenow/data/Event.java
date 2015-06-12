package com.onenow.data;

import com.onenow.constant.InvDataSource;
import com.onenow.constant.InvDataTiming;
import com.onenow.constant.SamplingRate;
import com.onenow.constant.TradeType;
import com.onenow.instrument.Investment;

public class Event {
	
	public Investment investment;

	public InvDataSource source;
	public InvDataTiming timing;
	public SamplingRate sampling;
	public TradeType tradeType; 

	public ObjectOrigination origin = new ObjectOrigination();

	public Event() {
		
	}	

}
