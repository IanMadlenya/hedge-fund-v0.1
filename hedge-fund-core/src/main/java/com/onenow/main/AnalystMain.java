package com.onenow.main;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;

import com.onenow.alpha.WordCount;
import com.onenow.storage.S3;
import com.onenow.storage.SQS;

public class AnalystMain {
	
	public static void main(String[] args) throws Exception {
		
		// S3 storage = new S3();
		
		SQS q = new SQS();
		
		// countWordsInFile(args);
		
	}

	private static void countWordsInFile(String[] args) {
		
		WordCount counter = new WordCount();
		
		// load input data
		String inputFile = args[0];
		// String inputFile = "/users/Shared/HedgeFundLog.txt";
		JavaRDD<String> inputRDD = counter.loadInputData(inputFile);
		
		// split into words
		JavaRDD<String> wordsRDD = counter.splitIntoWords(inputRDD);
		
		// transform into pairs and count
		JavaPairRDD<String, Integer> countsRDD = counter.countWords(wordsRDD);
		
		// save the word count back out to a text file, causing evaluation
		String outputFile = args[1];
		// String outputFile = "";
		countsRDD.saveAsTextFile(outputFile);
	}
}
