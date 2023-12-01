package com.anish.FlightApp;

public class Flight {

	private int id;
	private int planeid;
    private String flightNumber;
    private String origin;
    private String destination;
    private String departureTime;
    private String departureDate;
    private String arrivalTime;

    public Flight() {
    }

    public Flight(int id, String flightNumber, String origin, String destination, String depdate, String deptime, String arrtime, int planeid) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.departureDate = depdate;
        this.departureTime = deptime;
        this.arrivalTime = arrtime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPlaneid() {
        return planeid;
    }

    public void setPlaneid(int planeid) {
        this.planeid = planeid;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
    
}
