package com.HMS.exception;

//Creating the user define exception 

@SuppressWarnings("serial")
public class GlobalException extends Exception {

	public GlobalException(String msg) {
		
		super(msg);
	}
}
