package com.sjsu.cmpe202.fba.errors;

public class InvalidCardException extends Exception {

	private static final long serialVersionUID = 1L;
	public InvalidCardException(String errorMessage) {
		super(errorMessage);
	}
}