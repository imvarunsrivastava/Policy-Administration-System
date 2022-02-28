package com.cts.consumer.exception;

@SuppressWarnings("serial")
public class ConsumerBusinessNotFoundException extends RuntimeException{

	public ConsumerBusinessNotFoundException(String message) {
		super(message);
	}

}
