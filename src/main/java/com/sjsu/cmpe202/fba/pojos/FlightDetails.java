package com.sjsu.cmpe202.fba.pojos;

public class FlightDetails {

	private String seatCategory;
	private String flightNum;
	private int avblSeats;
	private int seatPrice;
	private String arrivalCity;
	private String departureCity;

	public FlightDetails(String seatCategory, String flightNum, int avblSeats, int seatPrice, String arrivalCity,
			String departureCity) {
		super();
		this.seatCategory = seatCategory;
		this.flightNum = flightNum;
		this.avblSeats = avblSeats;
		this.seatPrice = seatPrice;
		this.arrivalCity = arrivalCity;
		this.departureCity = departureCity;
	}

	public String getCategory() {
		return seatCategory;
	}

	public void setCategory(String category) {
		this.seatCategory = category;
	}

	public String getFlightNum() {
		return flightNum;
	}

	public void setFlightNum(String flightNum) {
		this.flightNum = flightNum;
	}

	public int getAvblSeats() {
		return avblSeats;
	}

	public void setAvblSeats(int avblSeats) {
		this.avblSeats = avblSeats;
	}

	public int getSeatPrice() {
		return seatPrice;
	}

	public void setSeatPrice(int seatPrice) {
		this.seatPrice = seatPrice;
	}

	public String getArrivalCity() {
		return arrivalCity;
	}

	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

	public String getDepartureCity() {
		return departureCity;
	}

	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}

	@Override
	public String toString() {
		return "FlightDetails [seatCategory=" + seatCategory + ", flightNum=" + flightNum + ", avblSeats=" + avblSeats
				+ ", seatPrice=" + seatPrice + ", arrivalCity=" + arrivalCity + ", departureCity=" + departureCity
				+ "]";
	}
}
