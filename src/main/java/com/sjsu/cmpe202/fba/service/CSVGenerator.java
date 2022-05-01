package com.sjsu.cmpe202.fba.service;

import java.io.PrintWriter;
import java.util.List;

import com.sjsu.cmpe202.fba.iterator.IteratorFba;
import com.sjsu.cmpe202.fba.iterator.IteratorFbaImpl;
import com.sjsu.cmpe202.fba.pojos.SuccessfulBooking;

public class CSVGenerator {

	// generate csv of successful bookings
	// list of Booking objects as input
	public static boolean createCSV(List<SuccessfulBooking> successfullBookings, String outputCsvFilePath) {
		boolean isCsvCreated = false;
		try {
			
			PrintWriter writer = new PrintWriter(outputCsvFilePath);
	        writer.println("BookingName,flight number,Category,number of seats booked,total price");
	        
	        System.out.println("------------ OUTPUT WITH FOR LOOP ------------");
	        for (SuccessfulBooking sb : successfullBookings) {
	            System.out.println(sb.toString());
	        }
	        
	        
	        System.out.println("------------ OUTPUT WITH MY CUSTOM ITERATOR ----------");
	        IteratorFba<SuccessfulBooking> myCustomIterator1 = new IteratorFbaImpl<SuccessfulBooking>(successfullBookings);
	        while (myCustomIterator1.hasNext()) {
	        	System.out.println(myCustomIterator1.getNext());
	        }
	        
	        
	        System.out.println("Creating the output file....");
	        IteratorFba<SuccessfulBooking> myCustomIterator = new IteratorFbaImpl<SuccessfulBooking>(successfullBookings);
	        while (myCustomIterator.hasNext()) {
	        	writer.println(myCustomIterator.getNext().toString());
	        }
	        
	        writer.close();
			
			isCsvCreated = true;
		} catch(Exception e) {
			System.out.println("Error occurred while CSV generation for successful bookings");
		}
		
		return isCsvCreated;
	}
}
