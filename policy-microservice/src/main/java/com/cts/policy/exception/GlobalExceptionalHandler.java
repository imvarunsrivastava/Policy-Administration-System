package com.cts.policy.exception;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GlobalExceptionalHandler {


	@ExceptionHandler(ConsumerNotFoundException.class)
	public ResponseEntity<Object> handleConsumerNotFoundException(ConsumerNotFoundException e){
		
		log.info("Start ConsumerNotFoundException");
		String errorMesssgeDescription=e.getLocalizedMessage();
		Map<String,Object> body=new LinkedHashMap<>();
		body.put("timestamp", new Date());
		body.put("error","Consumer not Found.");
		
		if(errorMesssgeDescription==null) {
			errorMesssgeDescription.toString();
		}
		body.put("error-message", errorMesssgeDescription);
		log.info("End ConsumerNotFoundException");
		return new ResponseEntity(body,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(PolicyNotFoundException.class)
	public ResponseEntity<Object> handlePolicyNotFoundException(PolicyNotFoundException e){
		
		log.info("Start PolicyNotFoundException");
		String errorMesssgeDescription=e.getLocalizedMessage();
		Map<String,Object> body=new LinkedHashMap<>();
		body.put("timestamp", new Date());
		body.put("error","Sorry! Policy not Found.");
		
		if(errorMesssgeDescription==null) {
			errorMesssgeDescription.toString();
		}
		body.put("error-message", errorMesssgeDescription);
		log.info("End PolicyNotFoundException");
		return new ResponseEntity(body,HttpStatus.NOT_FOUND);
	}

	
	
	@ExceptionHandler(FeignException.class)
	public ResponseEntity<Object> handleFeignException(FeignException e){
		
		log.info("Start FeignException");
		String errorMesssgeDescription=e.getLocalizedMessage();
		Map<String,Object> body=new LinkedHashMap<>();
		body.put("timestamp", new Date());
		body.put("error","ConsumerBusinessDetailsNotFoundException");
		body.put("error-message", "Sorry! Consumer Business details not created for this consumer.");
		
		
		log.info("End FeignException");
		return new ResponseEntity(body,HttpStatus.NOT_FOUND);
	}
	
	
}
