package com.cts.authorization.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@RestControllerAdvice
public class GlobalHandlerException extends ResponseEntityExceptionHandler{

	@Override
	public ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ExceptionDetails exceptionDetails = new ExceptionDetails(LocalDateTime.now(), ex.getMessage());
	return new ResponseEntity<>(exceptionDetails, status);
	}
	@ExceptionHandler(AuthorizeException.class)
	public ResponseEntity<Object> handleGlobalException(AuthorizeException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
			ExceptionDetails exceptionDetails = new ExceptionDetails(LocalDateTime.now(), ex.getMessage());
	return new ResponseEntity<>(exceptionDetails, HttpStatus.UNAUTHORIZED);
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleGlobalException(Exception ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
			ExceptionDetails exceptionDetails = new ExceptionDetails(LocalDateTime.now(), ex.getMessage());
	return new ResponseEntity<>(exceptionDetails, HttpStatus.UNAUTHORIZED);
	}
}
