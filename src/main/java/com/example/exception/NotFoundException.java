package com.example.exception;

public class NotFoundException extends Exception {
	
	private static final long serialVersionUID = 7437089906374699564L;

	public NotFoundException(){
		super();
	}
	
	public NotFoundException(String message) {
		super(message);
	}
	
	public NotFoundException(String message, Exception e) {
		super(message, e);
	}
}
