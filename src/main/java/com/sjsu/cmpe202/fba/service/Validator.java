package com.sjsu.cmpe202.fba.service;

import java.util.ArrayList;
import java.util.List;

import com.sjsu.cmpe202.fba.pojos.FlightDetails;

public class Validator {

	public List<FlightDetails> validateFlightNo(String flightNum, List<FlightDetails> flightData) {
		List<FlightDetails> matchingFlights = null;

		for (FlightDetails fd : flightData) {
			if (fd.getFlightNum().equals(flightNum)) {
				if (matchingFlights == null) {
					matchingFlights = new ArrayList<FlightDetails>();
				} 
				matchingFlights.add(fd);
			}
		}
		return matchingFlights;
	}

	public FlightDetails validateCategory(String categoryToBook, List<FlightDetails> flightData) {
		FlightDetails matchingFlight = null;
		
		for (FlightDetails fd : flightData) {
			if (fd.getCategory().equals(categoryToBook)) {
				matchingFlight = fd;
			}
		}
		
		return matchingFlight;
	}

	public boolean validateSeatCount(int seatCount, FlightDetails flightData) {
		boolean areSeatsAvbl = false;

		if (seatCount <= flightData.getAvblSeats()) {
			areSeatsAvbl = true;
		}

		return areSeatsAvbl;
	}

	public boolean validateCard(long cardNumber) {
		boolean isValid = false;

		String cardNum = String.valueOf(cardNumber);
		
		if (cardNum.length() > 19) {
			return isValid;
		}

		// visa
		if ((cardNum.length() == 13 || cardNum.length() == 16) && (cardNum.charAt(0) == '4')) {
			isValid = true;
		} // mastercard
		else if (cardNum.length() == 16 && (cardNum.charAt(0) == '5')
				&& (Character.getNumericValue(cardNum.charAt(1)) >= 1
						&& Character.getNumericValue(cardNum.charAt(1)) <= 5)) {
			isValid = true;
		} // discover
		else if (cardNum.length() == 16 && (cardNum.substring(0, 4).equals("6011"))) {
			isValid = true;
		} // amex
		else if (cardNum.length() == 15 && (cardNum.charAt(0) == '3')
				&& ((cardNum.charAt(1) == '4' || (cardNum.charAt(1) == '7')))) {
			isValid = true;
		}

		return isValid;
	}
}