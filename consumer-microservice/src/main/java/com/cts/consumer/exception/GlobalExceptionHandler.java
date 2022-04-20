package com.cts.consumer.exception;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@SuppressWarnings("null")
	@ExceptionHandler(ConsumerException.class)
	protected ResponseEntity<Object> handleConsumerException(ConsumerException ex) {
		log.info("Start GlobalExceptionHandler");
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", new Date());
		body.put("error", "Bad Request");
		body.put("status", HttpStatus.NOT_FOUND);
		String errorMessageDescription = ex.getLocalizedMessage();
		if (errorMessageDescription == null)
			errorMessageDescription.toString();
		body.put("error-message", errorMessageDescription);

		log.info("End GlobalExceptionHandler");
		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}
	
	@SuppressWarnings("null")
	@ExceptionHandler(InvalidTokenException.class)
	protected ResponseEntity<Object> handleInvalidTokenException(InvalidTokenException ex) {
		log.info("Start handleInvalidTokenException");
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", new Date());
		body.put("error", "Bad Request");
		body.put("status", HttpStatus.NOT_FOUND);
		String errorMessageDescription = ex.getLocalizedMessage();
		if (errorMessageDescription == null)
			errorMessageDescription.toString();
		body.put("error-message", errorMessageDescription);

		log.info("End GlobalExceptionHandler");
		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}
	
	@SuppressWarnings("null")
	@ExceptionHandler(FeignException.class)
	protected ResponseEntity<Object> handleFeignException(FeignException ex) {
		log.info("Start GlobalExceptionHandler");
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", new Date());
		body.put("error", "Bad Request");
		body.put("status", HttpStatus.NOT_FOUND);
		String errorMessageDescription = ex.getMessage();
		if (errorMessageDescription == null)
			errorMessageDescription.toString();
		body.put("error-message", errorMessageDescription);
		log.info("End GlobalExceptionHandler");
		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}

}
