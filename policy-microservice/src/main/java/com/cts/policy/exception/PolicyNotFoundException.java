package com.cts.policy.exception;

@SuppressWarnings("serial")
public class PolicyNotFoundException extends RuntimeException{
	
	public PolicyNotFoundException(String message) {
		super(message);
	}

}
