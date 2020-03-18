package com.example.exception;

public class InvalidRequest extends Exception {

	private static final long serialVersionUID = 7797442642183535074L;

	public InvalidRequest(){
		super();
	}
	
	public InvalidRequest(String message) {
		super(message);
	}
	
	public InvalidRequest(String message, Exception e) {
		super(message, e);
	}
}
