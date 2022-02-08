package com.example.demo.exceptions;

public class LoginExceptions extends RuntimeException {
	String exceptionMessage;

	public enum ExceptionTypes {
		NO_RECORD_FOUND
	}

	public ExceptionTypes exceptionTypes;

	public LoginExceptions(String exceptionMessage, ExceptionTypes exceptionTypes) {
		super();
		this.exceptionMessage = exceptionMessage;
		this.exceptionTypes = exceptionTypes;
	}
}
