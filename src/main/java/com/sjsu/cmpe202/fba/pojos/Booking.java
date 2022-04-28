package com.sjsu.cmpe202.fba.pojos;

public class Booking {

	private String bookingName;
	private String flightNum;
	private String category;
	private int seatsBooked;
	private int totalPrice;

	public Booking(String bookingName, String flightNum, String category, int seatsBooked, int totalPrice) {
		super();
		this.bookingName = bookingName;
		this.flightNum = flightNum;
		this.category = category;
		this.seatsBooked = seatsBooked;
		this.totalPrice = totalPrice;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getSeatsBooked() {
		return seatsBooked;
	}

	public void setSeatsBooked(int seatsBooked) {
		this.seatsBooked = seatsBooked;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "Booking [bookingName=" + bookingName + ", flightNum=" + flightNum + ", category=" + category
				+ ", seatsBooked=" + seatsBooked + ", totalPrice=" + totalPrice + "]";
	}
}
