package com.anish.FlightApp;

public class Passenger {
    private String firstName;
    private String lastName;
    private String seatNumber;

    Passenger(String firstName, String lastName, String seatNumber) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setSeatNumber(seatNumber);
    }

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}
}