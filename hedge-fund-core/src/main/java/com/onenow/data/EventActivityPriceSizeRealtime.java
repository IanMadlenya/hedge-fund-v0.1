package com.onenow.data;

import com.onenow.constant.InvDataSource;
import com.onenow.constant.InvDataTiming;
import com.onenow.constant.PriceType;
import com.onenow.constant.SizeType;
import com.onenow.constant.DataType;
import com.onenow.instrument.Investment;

public class EventActivityPriceSizeRealtime extends EventActivity {
	
	public EventActivityPriceSizeRealtime() {
		super();
	}
	
	/** Set real-time price/size/etc 
	 * 
	 * @param timeInMilisec
	 * @param inv
	 * @param dataType
	 * @param price
	 * @param size
	 */
	public EventActivityPriceSizeRealtime(	Long timeInMilisec, Investment inv,  Double price, long size,
											InvDataSource source) {

		super();
		super.streamingData = DataType.PRICESIZE_RT;

		setInvestment(inv);
		super.priceType = PriceType.TRADED; 		// by definition of RTVolume the priceType is TRADED
		super.sizeType = SizeType.TRADED_SIZE; 		// by definition of RTVolume the priceType is TRADED
		super.source = source;
		super.timing = InvDataTiming.REALTIME;

		super.timeInMilisec = timeInMilisec;
		super.price = price;
		super.size = size;

	}
	
	public String toString() {
		String s = "";
		
		s = s + super.toString();
		
		return s;
	}
}
