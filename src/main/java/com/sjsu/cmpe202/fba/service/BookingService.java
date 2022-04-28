package com.sjsu.cmpe202.fba.service;

import java.util.ArrayList;
import java.util.List;

import com.sjsu.cmpe202.fba.dao.StaticDatabase;
import com.sjsu.cmpe202.fba.pojos.Booking;
import com.sjsu.cmpe202.fba.pojos.BookingRequest;
import com.sjsu.cmpe202.fba.pojos.FlightDetails;

public class BookingService {

	// iterate over booking requests database
	// for each row
		// pass all validation
		// if error, maintain a list of logs; output them at the end into a txt file
		// if success, calc total price, seat updation AND CSV file generation
			
	private List<Booking> successfulBookings = new ArrayList<Booking>();
	private List<String> errors = new ArrayList<String>();
	private Validator validator = new Validator();
	
	public boolean bookFlight() {
		
		boolean isBookingSuccessful = false;
		
		try {
			List<BookingRequest> bookingRequests = StaticDatabase.getBookingRequests();
			List<FlightDetails> flightData = StaticDatabase.getFlightData();
			
			for (BookingRequest bookingRequest: bookingRequests) {
//				validator.validateFlightNo();
			}
			
			
			
			
			
			
			
		} catch (Exception e) {
			
		}
		
		
		return isBookingSuccessful;
	}
	
	
	
	
	
}
