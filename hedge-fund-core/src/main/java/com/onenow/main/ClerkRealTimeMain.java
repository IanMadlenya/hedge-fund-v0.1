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
import com.onenow.util.SysProperties;
import com.onenow.util.Watchr;

public class ClerkRealTimeMain {

	/**
	 * Processes real-time data
	 * Data is generated by InvestorMain itself, and also by requests to it from HistorianRTMain
	 * @param args
	 */
	public static void main(String[] args) {

		SysProperties.setLogProperties();
		FlexibleLogger.setup();

		IRecordProcessorFactory rtProcessorFactory = BusProcessingFactory.createProcessorFactoryEventRealTime(StreamName.REALTIME);
		BusSystem.read(StreamName.REALTIME, rtProcessorFactory);
		
	}
	
	public static void writeRealtimeRTtoL2(EventRealTime event) {
	
		boolean success = false;
		boolean retry = false;
		
		int tries = 0;
		int maxTries = 3;
		
		while(!success) {
			// handle as a transaction, both price+size write or nothing
			try {
				tries++;
				success = true;
				databaseTimeSeries.writePrice(event);				
				databaseTimeSeries.writeSize(event);
			} catch (Exception e) {
				success = false;
				retry = true;
				Watchr.log(Level.SEVERE, "TSDB RT TRANSACTION WRITE FAILED: " + event.id + " " + event.investment.toString() + " " + e.toString());	
				e.printStackTrace();
				if(tries>maxTries) {
					return;
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {}
			}
		}
		if(retry) {
			Watchr.log(Level.WARNING, "> TSDB RT TRANSACTION WRITE *RE-TRY* SUCCEEDED: " + event.time + " " + event.investment.toString());
		}
	}

}
