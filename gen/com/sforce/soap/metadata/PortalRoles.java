package com.sforce.soap.metadata;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated by SimpleTypeCodeGenerator.java. Please do not edit.
 */
public enum PortalRoles {


  
	/**
	 * Enumeration  : Executive
	 */
	Executive("Executive"),

  
	/**
	 * Enumeration  : Manager
	 */
	Manager("Manager"),

  
	/**
	 * Enumeration  : Worker
	 */
	Worker("Worker"),

  
	/**
	 * Enumeration  : PersonAccount
	 */
	PersonAccount("PersonAccount"),

;

	public static Map<String, String> valuesToEnums;

	static {
   		valuesToEnums = new HashMap<String, String>();
   		for (PortalRoles e : EnumSet.allOf(PortalRoles.class)) {
   			valuesToEnums.put(e.toString(), e.name());
   		}
   	}

   	private String value;

   	private PortalRoles(String value) {
   		this.value = value;
   	}

   	@Override
   	public String toString() {
   		return value;
   	}
}