package test;

import java.util.List;

import com.sjsu.cmpe202.fba.dao.StaticDatabase;
import com.sjsu.cmpe202.fba.pojos.FlightDetails;
import com.sjsu.cmpe202.fba.service.BookingService;
import com.sjsu.cmpe202.fba.service.Validator;

public class RunClient {

	// remove throws
	public static void main(String[] args) throws Exception {
		
		System.out.println(args[0]);
		System.out.println(args[1]);
		System.out.println(args[2]);
		System.out.println(args[3]);
		BookingService bookingService = new BookingService(args[0], args[1], args[2], args[3]);
		bookingService.bookFlight();
	} //Sample.csv flights.csv Output.csv Output.txt
}
