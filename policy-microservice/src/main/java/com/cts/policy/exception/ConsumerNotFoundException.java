package com.cts.policy.exception;

@SuppressWarnings("serial")
public class ConsumerNotFoundException extends RuntimeException {
	
	public ConsumerNotFoundException(String message) {
		super(message);
	}

}
