package com.healthHMS.HealthPy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceAlreadyExistException.class)
	public ResponseEntity<String> resourceAlreadyExists(ResourceAlreadyExistException ex) {

		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.OK);
	}
	
	@ExceptionHandler(ResourseNotFoundException.class)
	public ResponseEntity<String> resourceNotFoundException(ResourseNotFoundException ex) {

		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.OK);
	}

}
