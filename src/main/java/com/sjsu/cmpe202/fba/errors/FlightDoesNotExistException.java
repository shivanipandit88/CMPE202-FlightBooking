package com.sjsu.cmpe202.fba.errors;

public class FlightDoesNotExistException extends Exception {

	private static final long serialVersionUID = 1L;
	public FlightDoesNotExistException(String errorMessage) {
		super(errorMessage);
	}
}
