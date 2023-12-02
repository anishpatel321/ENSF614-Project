package com.anish.FlightApp;

public class Flight {

	private int id;
	private int planeid;
    private String flightNumber;
    private String origin;
    private String destination;
    private String departureDateTime;
    private String arrivalDateTime;
    private double baseCost;

    public Flight() {
    }

    public Flight(int id, String flightNumber, String origin, String destination, String depdatetime, String arrdatetime, double baseCost) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.departureDateTime = depdatetime;
        this.arrivalDateTime = arrdatetime;
        this.baseCost= baseCost;
    }

    public double getbaseCost() {
    	return baseCost;
    }
    
    public void setbaseCost(double baseCost) {
    	this.baseCost = baseCost;
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

    public String getDepartureDateTime() {
        return departureDateTime;
    }

    public void setDepartureDateTime(String departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    public String getArrivalDateTime() {
        return arrivalDateTime;
    }

    public void setArrivalDateTime(String arrivalDateTime) {
        this.arrivalDateTime =  arrivalDateTime;
    }

}
