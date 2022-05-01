package com.sjsu.cmpe202.fba.dao;

import java.util.List;

import com.sjsu.cmpe202.fba.adapter.csvToPojoList.CSVFileType;
import com.sjsu.cmpe202.fba.adapter.csvToPojoList.CSVReader;
import com.sjsu.cmpe202.fba.adapter.csvToPojoList.CSVToPojoListAdapter;
import com.sjsu.cmpe202.fba.adapter.csvToPojoList.CSVToPojoListAdapterImpl;
import com.sjsu.cmpe202.fba.errors.UnknownInputFileException;
import com.sjsu.cmpe202.fba.pojos.BookingRequest;
import com.sjsu.cmpe202.fba.pojos.FlightDetails;

public class StaticDatabase {

	private static List<FlightDetails> flightData;
	private static List<BookingRequest> bookingRequests;
	private static CSVToPojoListAdapter adapter;
	
	private static String flightDataFilePath;
	private static String inputDataFilePath;

	private StaticDatabase() {
	}
	
	public static void setInputFilePaths(String inputFile, String flightFile) {
		inputDataFilePath = inputFile;
		flightDataFilePath = flightFile;
		adapter = new CSVToPojoListAdapterImpl();
	}

	public static List<FlightDetails> getFlightData() throws UnknownInputFileException {
		if (flightData == null) {
			initializeFlightData();
		}
		return flightData;
	}

	public static List<BookingRequest> getBookingRequests() throws UnknownInputFileException {
		if (bookingRequests == null) {
			initializeBookingData();
		}
		return bookingRequests;
	}

	@SuppressWarnings("unchecked")
	private static void initializeFlightData() throws UnknownInputFileException {
		flightData = (List<FlightDetails>) adapter.getPojoList(CSVReader.readCSV(flightDataFilePath), CSVFileType.FLIGHT_DETAILS_CSV);
	}

	@SuppressWarnings("unchecked")
	public static void initializeBookingData() throws UnknownInputFileException {
		bookingRequests = (List<BookingRequest>) adapter.getPojoList(CSVReader.readCSV(inputDataFilePath), CSVFileType.BOOKING_REQUESTS_CSV);
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
