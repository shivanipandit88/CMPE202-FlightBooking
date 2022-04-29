package test;

import java.util.List;

import com.sjsu.cmpe202.fba.dao.StaticDatabase;
import com.sjsu.cmpe202.fba.pojos.FlightDetails;
import com.sjsu.cmpe202.fba.service.BookingService;
import com.sjsu.cmpe202.fba.service.Validator;

public class RunClient {

	// remove throws
	public static void main(String[] args) throws Exception {
		BookingService bookingService = new BookingService();
		bookingService.bookFlight();
	}
}
