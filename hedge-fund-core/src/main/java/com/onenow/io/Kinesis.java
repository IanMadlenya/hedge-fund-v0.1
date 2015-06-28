package com.onenow.io;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.logging.Level;

import com.amazonaws.AmazonClientException;
import com.amazonaws.regions.Region;
import com.amazonaws.services.kinesis.AmazonKinesis;
import com.amazonaws.services.kinesis.clientlibrary.interfaces.IRecordProcessorFactory;
import com.amazonaws.services.kinesis.clientlibrary.lib.worker.InitialPositionInStream;
import com.amazonaws.services.kinesis.model.ProvisionedThroughputExceededException;
import com.amazonaws.services.kinesis.model.PutRecordRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.onenow.admin.InitAmazon;
import com.onenow.constant.StreamName;
import com.onenow.constant.TestValues;
import com.onenow.data.EventActivity;
import com.onenow.util.Piping;
import com.onenow.util.StreamUtils;
import com.onenow.util.TimeParser;
import com.onenow.util.Watchr;

public class Kinesis {

	public static AmazonKinesis kinesis;
	private static Region region;
	
	public Kinesis() {
		this.region = InitAmazon.defaultRegion;		
		this.kinesis = InitAmazon.createKinesis(this.region);
	}
	
	public Kinesis(Region region) {
		this.kinesis = InitAmazon.createKinesis(region);
	}
	
	public void createStreamIfNotExists(StreamName streamName, int numShards) {
		
        // Creates a stream to write to with N shards if it doesn't exist
        StreamUtils streamUtils = new StreamUtils(kinesis);
        
        streamUtils.createStreamIfNotExists(streamName.toString(), numShards);
        
        String log = streamName + " stream is ready for use";
    	Watchr.log(Level.FINE, log);

	}

    public void sendObject(EventActivity activityToSend, StreamName streamName) {
    	
    	String log = "&&&&&&&&&& INTO STREAM <" + streamName + "> WRITING: " + activityToSend.toString();
    	Watchr.log(Level.INFO, log);
    	
    	sendObject((Object) activityToSend, streamName) ;
    	
    }

    public static void sendObject(Object objectToSend, StreamName streamName) {
    	
		boolean success = true;
		
        byte[] bytes = Piping.serialize(objectToSend).getBytes();

        PutRecordRequest putRecord = new PutRecordRequest();
        putRecord.setStreamName(streamName.toString());
        
        // We use the resource as the partition key so we can accurately calculate totals for a given resource
        putRecord.setPartitionKey(objectToSend.toString());
        putRecord.setData(ByteBuffer.wrap(bytes));
        
        // Order is not important for this application so we do not send a SequenceNumberForOrdering
        putRecord.setSequenceNumberForOrdering(null);

        // TODO: re-try here or in bus.write?
        try {
        	kinesis.putRecord(putRecord);
        } catch (Exception e){
        	success = false;
        	Watchr.log(Level.SEVERE, "Kinesis Exception. Throughput exceeded?");
        	e.printStackTrace();
        }
                
        if(!success) {
        	String log = "xxxxxxxxx FAILED INTO STREAM <" + streamName + "> WROTE: " + objectToSend.toString();
        	Watchr.log(Level.SEVERE, log, "\n", "");
        }
    }
    
    
    
    // TESTING
	private static IRecordProcessorFactory testingProcessorFactory = 
			BusProcessingFactory.createProcessorFactoryString(StreamName.TESTING);

	/**
	 * Write repeatedly to a data stream.  Have record processor write to cache.  Then read and validate it write the right amount.
	 */
	public static void selfTest() {	
		
		// initialize to an incorrect value
		sendObject((Object) TestValues.BOGUS.toString(), StreamName.TESTING);
		
		new Thread () {
			@Override public void run () {
				writeRepeatedly();
			}
		}.start();
		new Thread () {
			@Override public void run () {
				readRepeatedly();
			}
		}.start();
	}
	
	  private static void writeRepeatedly() {
		  	int count = 0;
		  	int maxTries=3;
		  	while(true) {	
		  		Watchr.log(Level.WARNING, "KINESIS SELF TEST: ");
		  		sendObject((Object) TestValues.VALUE.toString(), StreamName.TESTING);
				TimeParser.wait(15);
				count ++;
				if(count>maxTries) {
					return;
				}
		  	}
	  }
	  
	  /**
	   * Reading processor will look for write-read matches in the cache
	   */
	  private static void readRepeatedly() {
			BusSystem.read(StreamName.TESTING, testingProcessorFactory, InitialPositionInStream.LATEST);
	  }

}
