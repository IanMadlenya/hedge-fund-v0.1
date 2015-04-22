package com.onenow.database;

import java.util.ArrayList;
import java.util.List;

import com.onenow.instrument.Investment;
import com.onenow.research.Candle;

public class Ring {
	
	TSDB TSDB;	
	Orchestrator 							orchestrator; 	

	public Ring() {
		
	}

	public Ring(Orchestrator orch) {
		setTSDB(new TSDB());
		setOrchestrator(orch);
	}
	
	
	// WRITE
	public void writeEventRT(EventRT event) {

		Long time = event.getTime(); 
		Investment inv = event.getInv(); 
		String dataType = event.getDataType(); 

		Double price = event.getPrice();
		int size = event.getSize();

		// TODO: INSERT RING AND EVENTS HERE.  Write to different rings instead (orchestrator, investor...)
		getOrchestrator().writePrice(time, inv, dataType, price);	
		getOrchestrator().writeSize(time, inv, dataType, size);		
	}
	



	
//	// PRICE
//	public void writePrice(EventPriceWrite event) {		
//		Long time = event.getTime(); 
//		Investment inv = event.getInv(); 
//		String dataType = event.getDataType(); 
//		Double price = event.getPrice();
//
//		// TODO: INSERT RING AND EVENTS HERE.  Write to different rings instead (orchestrator, investor...)
//		getOrchestrator().writePrice(time, inv, dataType, price);	// write
//	}
//
//	public List<Candle> readPrice(	Investment inv, String dataType, 
//			String fromDate, String toDate, String sampling) {
//		return getDB().readPriceFromDB(inv, dataType, fromDate, toDate, sampling);
//	}
	
//	// SIZE
//	public void writeSize(EventSizeWrite event) {
//		Long time = event.getTime();
//		Investment inv = event.getInv();
//		String dataType = event.getDataType();
//		Integer size = event.getSize();
//		
//		// TODO: INSERT RING AND EVENTS HERE.  Write to different rings instead (orchestrator, investor...)
//		getOrchestrator().writeSize(time, inv, dataType, size);		// write
//	}
//	
//	public List<Integer> readSize(	Investment inv, String dataType, 
//			String fromDate, String toDate, String sampling) {
//		
//		// convert to callback from event
//		return getDB().readSizeFromDB(inv, dataType, fromDate, toDate, sampling);
//	}


	// SET GET
	public TSDB getTSDB() {
		return TSDB;
	}

	public void setTSDB(TSDB dB) {
		TSDB = dB;
	}

	public Orchestrator getOrchestrator() {
		return orchestrator;
	}

	public void setOrchestrator(Orchestrator orchestrator) {
		this.orchestrator = orchestrator;
	}

	
}
