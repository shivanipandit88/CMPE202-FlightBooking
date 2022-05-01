package test;

import com.sjsu.cmpe202.fba.service.BookingService;

public class RunClient {
	public static void main(String[] args) throws Exception {
<<<<<<< HEAD
		(new BookingService(args[0], args[1], args[2], args[3])).bookFlight();
	}
=======
		
		System.out.println(args[0]);
		System.out.println(args[1]);
		System.out.println(args[2]);
		System.out.println(args[3]);
		BookingService bookingService = new BookingService(args[0], args[1], args[2], args[3]);
		bookingService.bookFlight();
	} //Sample.csv flights.csv Output.csv Output.txt
>>>>>>> 7c6fad25dbd192a6594cb312bbd99457b58029c8
}
