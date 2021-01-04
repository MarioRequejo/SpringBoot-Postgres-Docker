package com.example.postgres.springpostgresdocker.Controller;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResouceNotFoundException extends RuntimeException {

	public ResouceNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
}
