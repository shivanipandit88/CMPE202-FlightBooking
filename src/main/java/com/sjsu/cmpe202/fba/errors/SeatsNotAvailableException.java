package com.sjsu.cmpe202.fba.errors;

public class SeatsNotAvailableException extends Exception {

	private static final long serialVersionUID = 1L;
	public SeatsNotAvailableException(String errorMessage) {
		super(errorMessage);
	}
}
