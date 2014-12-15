package com.sforce.soap.metadata;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated by SimpleTypeCodeGenerator.java. Please do not edit.
 */
public enum ReportBucketFieldType {


  
	/**
	 * Enumeration  : text
	 */
	text("text"),

  
	/**
	 * Enumeration  : number
	 */
	number("number"),

  
	/**
	 * Enumeration  : picklist
	 */
	picklist("picklist"),

;

	public static Map<String, String> valuesToEnums;

	static {
   		valuesToEnums = new HashMap<String, String>();
   		for (ReportBucketFieldType e : EnumSet.allOf(ReportBucketFieldType.class)) {
   			valuesToEnums.put(e.toString(), e.name());
   		}
   	}

   	private String value;

   	private ReportBucketFieldType(String value) {
   		this.value = value;
   	}

   	@Override
   	public String toString() {
   		return value;
   	}
}