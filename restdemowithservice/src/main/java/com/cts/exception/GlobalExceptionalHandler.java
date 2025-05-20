package com.cts.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionalHandler {

	@ExceptionHandler(InValidAgeException.class)
	public ResponseEntity<ErrorResponse> myExceptionResponse(InValidAgeException exception) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorMessage(exception.getMessage());
		errorResponse.setHttpStatus(HttpStatus.BAD_REQUEST);
		errorResponse.setLocalDateTime(LocalDateTime.now());

		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ErrorResponse> myExceptionResponse(IdNotFoundException exception) {
//		return idNotFoundException.getMessage();
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorMessage(exception.getMessage());
		errorResponse.setHttpStatus(HttpStatus.BAD_REQUEST);
		errorResponse.setLocalDateTime(LocalDateTime.now());
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
	}
}
