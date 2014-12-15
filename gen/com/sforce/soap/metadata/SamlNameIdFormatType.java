package com.sforce.soap.metadata;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated by SimpleTypeCodeGenerator.java. Please do not edit.
 */
public enum SamlNameIdFormatType {


  
	/**
	 * Enumeration  : Unspecified
	 */
	Unspecified("Unspecified"),

  
	/**
	 * Enumeration  : EmailAddress
	 */
	EmailAddress("EmailAddress"),

  
	/**
	 * Enumeration  : Persistent
	 */
	Persistent("Persistent"),

  
	/**
	 * Enumeration  : Transient
	 */
	Transient("Transient"),

;

	public static Map<String, String> valuesToEnums;

	static {
   		valuesToEnums = new HashMap<String, String>();
   		for (SamlNameIdFormatType e : EnumSet.allOf(SamlNameIdFormatType.class)) {
   			valuesToEnums.put(e.toString(), e.name());
   		}
   	}

   	private String value;

   	private SamlNameIdFormatType(String value) {
   		this.value = value;
   	}

   	@Override
   	public String toString() {
   		return value;
   	}
}