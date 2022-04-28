package com.sjsu.cmpe202.fba.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.sjsu.cmpe202.fba.pojos.BookingRequest;
import com.sjsu.cmpe202.fba.pojos.FlightDetails;

public class StaticDatabase {

	private static List<FlightDetails> flightData;
	private static List<BookingRequest> bookingRequests;

	private StaticDatabase() {}
	
	public static List<FlightDetails> getFlightData() {
		if (flightData == null) {
			flightData = createFlightData();
		}
		return flightData;
	}
	
	public static List<BookingRequest> getBookingRequests() {
		if (bookingRequests == null) {
			bookingRequests = createBookingData();
		}
		return bookingRequests;
	}

	public static List<FlightDetails> createFlightData() {

		String line = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader("flights.csv"));
			int i = 0;
			while ((line = br.readLine()) != null) {
				i++;
				if (i == 1) {
					continue;
				} else {
					String[] rowValues = line.split(",");
					FlightDetails flightDetail = new FlightDetails(rowValues[0], rowValues[1],
							Integer.parseInt(rowValues[2]), Integer.parseInt(rowValues[3]), rowValues[4], rowValues[5]);
					flightData.add(flightDetail);
				}
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return flightData;
	}

	public static List<BookingRequest> createBookingData() {

		String line = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader("Sample.csv"));
			int i = 0;
			while ((line = br.readLine()) != null) {
				i++;
				if (i == 1) {
					continue;
				} else {
					String[] rowValues = line.split(",");
					BookingRequest bookingDetail = new BookingRequest(rowValues[0], rowValues[1], rowValues[2],
							Integer.parseInt(rowValues[3]), Long.parseLong(rowValues[4]));
					bookingRequests.add(bookingDetail);
				}
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return bookingRequests;
	}
	
	
	public boolean updateSeatsAvbl() {
		
		boolean isUpdateSuceesful = false;
		
		
		return isUpdateSuceesful;
	}

}
