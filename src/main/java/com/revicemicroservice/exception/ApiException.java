package com.revicemicroservice.exception;

import org.springframework.http.HttpStatus;

public class ApiException extends RuntimeException {

	private HttpStatus status;

	public ApiException() {

	}

	public ApiException(String message) {
		super(message);
	}

	public ApiException(String message, HttpStatus status) {
		super(message);
		this.status = status;
	}
}
