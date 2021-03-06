package com.onenow.admin;

import java.util.List;

import com.sforce.soap.enterprise.sobject.Account;
import com.sforce.soap.enterprise.sobject.Cloud__c;
import com.sforce.soap.enterprise.sobject.Day__c;
import com.sforce.soap.enterprise.sobject.Log__c;
import com.sforce.soap.enterprise.sobject.Market__c;
import com.sforce.soap.enterprise.sobject.Reduction__c;
import com.sforce.soap.enterprise.sobject.System__c;
import com.sforce.ws.ConnectionException;

public abstract interface DatabaseSystem {
	public abstract List<Reduction__c> getReductions() throws ConnectionException;
	public abstract Reduction__c newRedution(String name, String mode, Double target)  throws ConnectionException;
	public List<Day__c> getDays() throws ConnectionException;
	public List<Market__c> getMarkets() throws ConnectionException;
	public abstract List<Cloud__c> getClouds() throws ConnectionException;
	public abstract List<System__c> getSystem() throws ConnectionException;
	public List<Log__c> getLogs() throws ConnectionException;	
	public Log__c[] newLog(String source, String desc)  throws ConnectionException;
	public abstract List<Account> getAccounts() throws ConnectionException;

}
