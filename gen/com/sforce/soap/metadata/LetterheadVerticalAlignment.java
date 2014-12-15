package com.sforce.soap.metadata;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated by SimpleTypeCodeGenerator.java. Please do not edit.
 */
public enum LetterheadVerticalAlignment {


  
	/**
	 * Enumeration  : None
	 */
	None("None"),

  
	/**
	 * Enumeration  : Top
	 */
	Top("Top"),

  
	/**
	 * Enumeration  : Middle
	 */
	Middle("Middle"),

  
	/**
	 * Enumeration  : Bottom
	 */
	Bottom("Bottom"),

;

	public static Map<String, String> valuesToEnums;

	static {
   		valuesToEnums = new HashMap<String, String>();
   		for (LetterheadVerticalAlignment e : EnumSet.allOf(LetterheadVerticalAlignment.class)) {
   			valuesToEnums.put(e.toString(), e.name());
   		}
   	}

   	private String value;

   	private LetterheadVerticalAlignment(String value) {
   		this.value = value;
   	}

   	@Override
   	public String toString() {
   		return value;
   	}
}