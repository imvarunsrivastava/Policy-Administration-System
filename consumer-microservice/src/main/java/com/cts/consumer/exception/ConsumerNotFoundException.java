package com.cts.consumer.exception;

@SuppressWarnings("serial")
public class ConsumerNotFoundException extends RuntimeException {

	public ConsumerNotFoundException(String message) {
		super(message);
	}
	

}
