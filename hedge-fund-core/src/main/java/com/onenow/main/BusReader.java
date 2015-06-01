package com.onenow.main;

import com.onenow.constant.StreamName;
import com.onenow.io.BusSystem;
import com.onenow.io.Kinesis;

public class BusReader {

	public static void main(String[] args) {
		
		Kinesis kinesis = BusSystem.getKinesis();
				
		BusSystem.readFromAnalystBus(kinesis);

	}


}