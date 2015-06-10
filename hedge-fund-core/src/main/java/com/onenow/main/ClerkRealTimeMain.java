package com.onenow.main;

import java.util.logging.Level;

import com.amazonaws.services.kinesis.clientlibrary.interfaces.IRecordProcessorFactory;
import com.onenow.constant.StreamName;
import com.onenow.data.EventRealTime;
import com.onenow.io.BusProcessingFactory;
import com.onenow.io.BusSystem;
import com.onenow.io.Kinesis;
import com.onenow.io.databaseTimeSeries;
import com.onenow.util.FlexibleLogger;
import com.onenow.util.Watchr;

public class ClerkRealTimeMain {

	/**
	 * Processes real-time data
	 * Data is generated by InvestorMain itself, and also by requests to it from HistorianRTMain
	 * @param args
	 */
	public static void main(String[] args) {

		FlexibleLogger.setup();

		IRecordProcessorFactory rtProcessorFactory = BusProcessingFactory.createProcessorFactoryEventRealTime();
		BusSystem.read(StreamName.REALTIME, rtProcessorFactory);
		
	}
	
	public static void writeHistoryRTtoL2(EventRealTime event) {
	
		boolean success = false;
		boolean retry = false;
		
		while(!success) {
			// handle as a transaction, both price+size write or nothing
			try {
				success = true;
				databaseTimeSeries.writePrice(event.time, event.inv, event.tradeType, event.price,
								event.source, event.timing);				
				databaseTimeSeries.writeSize(	event.time, event.inv, event.tradeType, event.size,			
								event.source, event.timing);
			} catch (Exception e) {
				success = false;
				retry = true;
				Watchr.log(Level.SEVERE, "TSDB RT TRANSACTION WRITE FAILED: " + event.time + " " + event.inv.toString());	
				e.printStackTrace();
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {}
			}
		}
		if(retry) {
			Watchr.log(Level.INFO, "> TSDB RT TRANSACTION WRITE *RE-TRY* SUCCEEDED: " + event.time + " " + event.inv.toString());
		}
	}

}
