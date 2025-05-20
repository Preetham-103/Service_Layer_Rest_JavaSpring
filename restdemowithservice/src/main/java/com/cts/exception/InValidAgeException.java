package com.cts.exception;

public class InValidAgeException extends RuntimeException {

	String msg;

	public InValidAgeException(String msg) {
		super(msg);  // It will store in super class message variable
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}
	
	
	
}
