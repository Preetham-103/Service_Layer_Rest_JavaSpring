package com.cts.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ErrorResponse {

	private String errorMessage;
	private HttpStatus httpStatus;
	private LocalDateTime localDateTime;
}
