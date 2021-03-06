package com.onenow.bigdata;

import java.util.List;
import java.util.logging.Level;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;

import com.amazonaws.services.s3.model.Bucket;
import com.onenow.alpha.WordCount;
import com.onenow.io.S3;
import com.onenow.main.ReporterMain;
import com.onenow.util.InitLogger;
import com.onenow.util.TimeParser;
import com.onenow.util.Watchr;


public class WordCountMain {

	public static void main(String[] args) {

		InitLogger.run("");		
		
		countWordsInBucket();
		
		while(true) {
			TimeParser.sleep(1000);
		}
		
	}

	private static void countWordsInBucket() {
		Bucket bucket = S3.getBucket(ReporterMain.getReporterBucketName());
		List<String> files = S3.listObjects(bucket);
		String objectName = files.get(0);
		
		String folderName = "/tmp/";
		String downloadedFile = folderName+objectName;
		S3.object2File(bucket, objectName, downloadedFile+".txt");
		
		countWordsInFile(downloadedFile+".txt", downloadedFile+"-"+TimeParser.getTimeMilisecondsNow()+".out");
	}
	
	private static void countWordsInFile(String inputFile, String outputFolder) {
		String args[] = {inputFile, outputFolder};
		countWordsInFile(args);
	}

	// from the command line: countWordsInFile(args);
	private static void countWordsInFile(String[] args) {
				
		// load input data
		String inputFile = args[0];
		String outputFolder = args[1];

		Watchr.warning("Counting words from " + inputFile + " into " + outputFolder);

		WordCount counter = new WordCount();

		// String inputFile = "/users/Shared/HedgeFundLog.txt";
		JavaRDD<String> inputRDD = counter.loadInputData(inputFile);
		
		// split into words
		JavaRDD<String> wordsRDD = counter.splitIntoWords(inputRDD);
		
		// transform into pairs and count
		JavaPairRDD<String, Integer> countsRDD = counter.countWords(wordsRDD);
		
		// save the word count back out to a text file, causing evaluation
		countsRDD.saveAsTextFile(outputFolder);
		
//		counter.spark.sc.stop();
	}
}
