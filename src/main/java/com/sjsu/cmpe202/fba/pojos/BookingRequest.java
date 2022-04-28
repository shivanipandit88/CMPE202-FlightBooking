package com.sjsu.cmpe202.fba.pojos;

public class BookingRequest {

	private String bookingName;
	private String flightNum;
	private String seatCategory;
	private int seatsBooked;
	private long cardNumber;

	public BookingRequest(String bookingName, String flightNum, String seatCategory, int seatsBooked, long cardNumber) {
		super();
		this.bookingName = bookingName;
		this.flightNum = flightNum;
		this.seatCategory = seatCategory;
		this.seatsBooked = seatsBooked;
		this.cardNumber = cardNumber;
	}

	public String getBookingName() {
		return bookingName;
	}

	public void setBookingName(String bookingName) {
		this.bookingName = bookingName;
	}

	public String getFlightNum() {
		return flightNum;
	}

	public void setFlightNum(String flightNum) {
		this.flightNum = flightNum;
	}

	public String getSeatCategory() {
		return seatCategory;
	}

	public void setSeatCategory(String seatCategory) {
		this.seatCategory = seatCategory;
	}

	public int getSeatsBooked() {
		return seatsBooked;
	}

	public void setSeatsBooked(int seatsBooked) {
		this.seatsBooked = seatsBooked;
	}

	public long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}

	@Override
	public String toString() {
		return "BookingDetails [bookingName=" + bookingName + ", flightNum=" + flightNum + ", seatCategory="
				+ seatCategory + ", seatsBooked=" + seatsBooked + ", cardNumber=" + cardNumber + "]";
	}
}
