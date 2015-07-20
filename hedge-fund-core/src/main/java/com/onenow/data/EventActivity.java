package com.onenow.data;

import com.onenow.constant.ColumnName;


public class EventActivity extends Event {
	
	public Double price;
	public Long size; 
		
	
	public EventActivity() {
		super();
	}
		
	public Object getValue(ColumnName columnName) {
		// default
		Object value = null;
		try {
			value = (Object) price;
		} catch (Exception e) {
		}
		
		try {
			if(columnName.equals(ColumnName.SIZE)) {
				value = (Object) size;
			}
		} catch (Exception e) {
		}
		return value;
	}

	public String toString() {
		String s = "";
		
		s = super.toString() + " ";
		
		try {
			if(price!=null) {
				s = s + "-price " + price + " ";
			}
		} catch (Exception e) {
		}

		try {
			if(size!=null) {
				s = s + "-size " + size;
			}
		} catch (Exception e) {
		}
		
		return s;
	}

}
