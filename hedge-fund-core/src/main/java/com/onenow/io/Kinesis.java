package com.onenow.io;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.logging.Level;

import kinesis.CountingRecordProcessorFactory;

import com.amazonaws.AmazonClientException;
import com.amazonaws.regions.Region;
import com.amazonaws.services.kinesis.AmazonKinesis;
import com.amazonaws.services.kinesis.clientlibrary.interfaces.IRecordProcessorFactory;
import com.amazonaws.services.kinesis.clientlibrary.lib.worker.InitialPositionInStream;
import com.amazonaws.services.kinesis.clientlibrary.lib.worker.KinesisClientLibConfiguration;
import com.amazonaws.services.kinesis.model.ProvisionedThroughputExceededException;
import com.amazonaws.services.kinesis.model.PutRecordRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.onenow.admin.InitAmazon;
import com.onenow.constant.StreamName;
import com.onenow.data.DynamoDBCountPersister;
import com.onenow.data.HttpReferrerPair;
import com.onenow.util.StreamUtils;
import com.onenow.util.Watchr;

public class Kinesis {

	private static AmazonKinesis kinesis;
	
	private final ObjectMapper jsonMapper = new ObjectMapper();
	
	public Kinesis() {
	}
	
	public Kinesis(Region region) {
		this.kinesis = InitAmazon.getKinesis(region);
	}
	
	public void createStreamIfNotExists(StreamName streamName, int numShards) {
		
        // Creates a stream to write to with N shards if it doesn't exist
        StreamUtils streamUtils = new StreamUtils(kinesis);
        
        streamUtils.createStreamIfNotExists(streamName.toString(), numShards);
        
        String log = streamName + " stream is ready for use";
    	Watchr.log(Level.FINE, log);

	}
	
    public void sendObject(Object objectToSend, StreamName streamName) {
		
		boolean success = true;
		
    	jsonMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    	
        byte[] bytes;
        try {
            bytes = jsonMapper.writeValueAsBytes(objectToSend);
        } catch (IOException e) {
        	Watchr.log(Level.SEVERE, "Skipping pair. Unable to serialize: " + e.getMessage());
            return;
        }

        PutRecordRequest putRecord = new PutRecordRequest();
        putRecord.setStreamName(streamName.toString());
        
        // We use the resource as the partition key so we can accurately calculate totals for a given resource
        putRecord.setPartitionKey(objectToSend.toString());
        putRecord.setData(ByteBuffer.wrap(bytes));
        
        // Order is not important for this application so we do not send a SequenceNumberForOrdering
        putRecord.setSequenceNumberForOrdering(null);

        try {
            kinesis.putRecord(putRecord);
        } catch (ProvisionedThroughputExceededException ex) {
        	success = false;
        	Watchr.log(Level.SEVERE, "Throughput exceeded" + ex.getMessage());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        } catch (AmazonClientException ex) {
        	Watchr.log(Level.SEVERE, "Error sending record to Amazon Kinesis: " + ex.getMessage());
        }
        
        if(success) {
        	Watchr.log(Level.INFO, "&&&&&&&&&&&&& WROTE: " + objectToSend.toString() + " INTO STREAM: " + streamName);
        }
    }
    
    public KinesisClientLibConfiguration configureClient(	String applicationName, String streamName, 
    														String workerId, Region region) {
    	
        KinesisClientLibConfiguration kclConfig =
                new KinesisClientLibConfiguration(applicationName, streamName, InitAmazon.getAWSCredentialProvider(), workerId);
        kclConfig.withCommonClientConfig(InitAmazon.getClientConfig());
        kclConfig.withRegionName(region.getName());
        kclConfig.withInitialPositionInStream(InitialPositionInStream.LATEST);

        return kclConfig;
    }

}
