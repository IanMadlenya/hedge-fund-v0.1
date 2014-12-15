package com.sforce.soap.metadata;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated by SimpleTypeCodeGenerator.java. Please do not edit.
 */
public enum EscalationStartTimeType {


  
	/**
	 * Enumeration  : CaseCreation
	 */
	CaseCreation("CaseCreation"),

  
	/**
	 * Enumeration  : CaseLastModified
	 */
	CaseLastModified("CaseLastModified"),

;

	public static Map<String, String> valuesToEnums;

	static {
   		valuesToEnums = new HashMap<String, String>();
   		for (EscalationStartTimeType e : EnumSet.allOf(EscalationStartTimeType.class)) {
   			valuesToEnums.put(e.toString(), e.name());
   		}
   	}

   	private String value;

   	private EscalationStartTimeType(String value) {
   		this.value = value;
   	}

   	@Override
   	public String toString() {
   		return value;
   	}
}