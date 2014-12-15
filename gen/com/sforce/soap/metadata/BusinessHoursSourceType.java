package com.sforce.soap.metadata;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated by SimpleTypeCodeGenerator.java. Please do not edit.
 */
public enum BusinessHoursSourceType {


  
	/**
	 * Enumeration  : None
	 */
	None("None"),

  
	/**
	 * Enumeration  : Case
	 */
	Case("Case"),

  
	/**
	 * Enumeration  : Static
	 */
	Static("Static"),

;

	public static Map<String, String> valuesToEnums;

	static {
   		valuesToEnums = new HashMap<String, String>();
   		for (BusinessHoursSourceType e : EnumSet.allOf(BusinessHoursSourceType.class)) {
   			valuesToEnums.put(e.toString(), e.name());
   		}
   	}

   	private String value;

   	private BusinessHoursSourceType(String value) {
   		this.value = value;
   	}

   	@Override
   	public String toString() {
   		return value;
   	}
}