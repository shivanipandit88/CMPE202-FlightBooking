package com.sjsu.cmpe202.fba.service;

import java.io.PrintWriter;
import java.util.List;

import com.sjsu.cmpe202.fba.pojos.SuccessfulBooking;

public class CSVGenerator {

	// generate csv of successful bookings
	// list of Booking objects as input
	public static boolean createCSV(List<SuccessfulBooking> successfullBookings) {
		boolean isCsvCreated = false;
		try {
			
			
			PrintWriter writer = new PrintWriter("Output.csv");
	        writer.println("BookingName,flight number,Category,number of seats booked,total price");

	        for (SuccessfulBooking sb : successfullBookings) {
	            writer.println(sb.toString());
	        }
	        writer.close();
			
			isCsvCreated = true;
		} catch(Exception e) {
			
		}
		
		return isCsvCreated;
	}
}
