package com.sforce.soap.metadata;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated by SimpleTypeCodeGenerator.java. Please do not edit.
 */
public enum StepRejectBehaviorType {


  
	/**
	 * Enumeration  : RejectRequest
	 */
	RejectRequest("RejectRequest"),

  
	/**
	 * Enumeration  : BackToPrevious
	 */
	BackToPrevious("BackToPrevious"),

;

	public static Map<String, String> valuesToEnums;

	static {
   		valuesToEnums = new HashMap<String, String>();
   		for (StepRejectBehaviorType e : EnumSet.allOf(StepRejectBehaviorType.class)) {
   			valuesToEnums.put(e.toString(), e.name());
   		}
   	}

   	private String value;

   	private StepRejectBehaviorType(String value) {
   		this.value = value;
   	}

   	@Override
   	public String toString() {
   		return value;
   	}
}