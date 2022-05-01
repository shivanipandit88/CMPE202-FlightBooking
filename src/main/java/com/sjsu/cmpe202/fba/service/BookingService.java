package com.sjsu.cmpe202.fba.service;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import com.sjsu.cmpe202.fba.dao.StaticDatabase;
import com.sjsu.cmpe202.fba.errors.FlightDoesNotExistException;
import com.sjsu.cmpe202.fba.errors.InvalidCardException;
import com.sjsu.cmpe202.fba.errors.NoSuccessfulBookings;
import com.sjsu.cmpe202.fba.errors.SeatCategoryIncorrectException;
import com.sjsu.cmpe202.fba.errors.SeatsNotAvailableException;
import com.sjsu.cmpe202.fba.pojos.Booking;
import com.sjsu.cmpe202.fba.pojos.BookingRequest;
import com.sjsu.cmpe202.fba.pojos.FlightDetails;
import com.sjsu.cmpe202.fba.pojos.SuccessfulBooking;

public class BookingService {

	// iterate over booking requests database
	// for each row
		// pass all validation
		// if error, maintain a list of logs; output them at the end into a txt file
		// if success, calc total price, seat updation AND CSV file generation
			
	private List<Booking> successfulBookings = new ArrayList<Booking>();
	private List<String> errors = new ArrayList<String>();
	private Validator validator = new Validator();
	
	public boolean bookFlight() throws Exception {
		
		boolean isBookingSuccessful = false;
		FileWriter myWriter = new FileWriter("Output.txt");
		
		try {
			List<BookingRequest> bookingRequests = StaticDatabase.getBookingRequests();
			List<FlightDetails> flightData = StaticDatabase.getFlightData();
			List<SuccessfulBooking> sucessfulBookings = null;
			
			int i = 0;
			for (BookingRequest bookingRequest: bookingRequests) {
				
				try {
					
					FlightDetails validFlight = validator.validateFlightNo(bookingRequest.getFlightNum(), flightData);
					if (validFlight != null) {
						if (validator.validateCategory(bookingRequest.getSeatCategory(), validFlight)) {
							if (validator.validateSeatCount(bookingRequest.getSeatsBooked(), validFlight)) {
								
								int totalPrice = bookingRequest.getSeatsBooked() * validFlight.getSeatPrice();
								
								if (validator.validateCard(bookingRequest.getCardNumber())) {
									
									StaticDatabase.updateSeatsAvbl(validFlight.hashCode(), validFlight.getAvblSeats() - bookingRequest.getSeatsBooked());
									
									if (sucessfulBookings == null) {
										sucessfulBookings = new ArrayList<SuccessfulBooking>();
									}
									sucessfulBookings.add(new SuccessfulBooking(bookingRequest.getBookingName(), bookingRequest.getFlightNum(), bookingRequest.getSeatCategory(), bookingRequest.getSeatsBooked(), totalPrice));
									System.out.println("sucessfulBookings updated!");
									
									
								} else {
									myWriter.write("Please enter correct booking details for " + bookingRequest.getBookingName() + ": invalid card number \n");
								    System.out.println("Successfully wrote to the file. 1");
								      
									throw new InvalidCardException("Card number invalid");
							
								}
								
								
								
							} else {
								myWriter.write("Please enter correct booking details for " + bookingRequest.getBookingName() + ": invalid  seat count \n");
							    System.out.println("Successfully wrote to the file. 2");
							    
								throw new SeatsNotAvailableException("Flight " + bookingRequest.getFlightNum() + " does not contain required number of seats");
							}
						} else {
							myWriter.write("Please enter correct booking details for " + bookingRequest.getBookingName() + ": invalid category \n");
						    System.out.println("Successfully wrote to the file. 4");
						    
							throw new SeatCategoryIncorrectException("Flight " + bookingRequest.getFlightNum() + " does not have the requested seat category type");
						}
					} else {
						myWriter.write("Please enter correct booking details for " + bookingRequest.getBookingName() + ": invalid flight number \n");
					    System.out.println("Successfully wrote to the file. 3");
					    
						throw new FlightDoesNotExistException("Flight " + bookingRequest.getFlightNum() + " does not exist");
					}
					
				} catch (Exception e) {
					System.out.println("Exception for entry number: " + i);
				}
				
				i++;
			}
			System.out.println("FOR Done");
			myWriter.close();
			
			
			if (sucessfulBookings != null) {
				System.out.println("CSV Creating...");
				CSVGenerator.createCSV(sucessfulBookings);
				System.out.println("CSV Created!!!!!!");
			} else {
				// create output.txt of all error logs
				throw new NoSuccessfulBookings("No successful bookings in the session");
			}
			
			
			
			
			
			
		} catch (Exception e) {
			throw e;
		}
		
		
		return isBookingSuccessful;
	}
	
	
	
	
	
}
