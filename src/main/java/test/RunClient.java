package test;

import com.sjsu.cmpe202.fba.service.BookingService;

public class RunClient {
	public static void main(String[] args) throws Exception {
		(new BookingService(args[0], args[1], args[2], args[3])).bookFlight();
	}
}
