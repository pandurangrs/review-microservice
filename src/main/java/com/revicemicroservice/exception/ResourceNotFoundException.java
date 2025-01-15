package com.revicemicroservice.exception;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends RuntimeException {

	private HttpStatus status;

	public ResourceNotFoundException() {
		super("Resource Not Found.");
	}

	public ResourceNotFoundException(String message, HttpStatus status) {
		super(message);
		this.status = status;
	}

}
