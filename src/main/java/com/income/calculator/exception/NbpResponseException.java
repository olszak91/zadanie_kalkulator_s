package com.income.calculator.exception;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE) 
public class NbpResponseException extends RuntimeException{
	public NbpResponseException(String message) {
		super(message);
	}

	public NbpResponseException(String message, IOException exception) {
		super(message, exception);
	}
	
}
