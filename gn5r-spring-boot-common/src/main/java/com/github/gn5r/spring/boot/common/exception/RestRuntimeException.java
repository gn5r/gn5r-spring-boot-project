package com.github.gn5r.spring.boot.common.exception;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

/**
 * 独自例外
 *
 * @author gn5r
 */
public class RestRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private HttpStatus status;
	private String message;
	private List<FieldError> fieldErrors;

	public RestRuntimeException(HttpStatus status, String message) {
		this.status = status;
		this.message = message;
	}

	public RestRuntimeException(HttpStatus status, String message, List<FieldError> fieldErrors) {
		this.status = status;
		this.message = message;
		this.fieldErrors = fieldErrors;
	}

	public HttpStatus getStatus() {
		return this.status;
	}

	public String getMessage() {
		return this.message;
	}

	public List<FieldError> getFieldErrors() {
		return this.fieldErrors;
	}
}
