package com.sjsu.cmpe202.fba.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.sjsu.cmpe202.fba.pojos.BookingRequest;
import com.sjsu.cmpe202.fba.pojos.FlightDetails;

public class StaticDatabase {

	private static List<FlightDetails> flightData;
	private static List<BookingRequest> bookingRequests;

	private StaticDatabase() {
	}

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

		System.out.println("IN CREATE DATA");
		List<FlightDetails> fd = null;
		String line = "";
		try {
			fd = new ArrayList<FlightDetails>();
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
					fd.add(flightDetail);

					System.out.println(flightDetail.hashCode());

				}
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		flightData = fd;
		return fd;
	}

	public static List<BookingRequest> createBookingData() {

		List<BookingRequest> bR = null;
		String line = "";
		try {
			bR = new ArrayList<BookingRequest>();
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
					bR.add(bookingDetail);
				}
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		bookingRequests = bR;
		return bR;
	}

	public static boolean updateSeatsAvbl(int objHash, int newSeatCount) {
		// objHash is the hashcode of the FlightDetails in the FlightData database
		// (List<FlightDetails>); and will act as the unique identifier
		boolean isUpdateSucessful = false;

		for (FlightDetails flightDetail : flightData) {
			if (flightDetail.hashCode() == objHash) {
				flightDetail.setAvblSeats(newSeatCount);
				System.out.println("Flight seatcount for flight" + flightDetail.getFlightNum() + " updated");
			}
		}

		return isUpdateSucessful;
	}

}
