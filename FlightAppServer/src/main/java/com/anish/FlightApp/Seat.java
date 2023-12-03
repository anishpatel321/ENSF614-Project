package com.anish.FlightApp;
/**
 * 
 * Seat object stores the seat number and the price and has the ability to return both
 * 
 */


public class Seat {
    private String seatNumber;
    private double price;

    public Seat(String seatNumber, double price) {
        this.seatNumber = seatNumber;
        this.price = price;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public String toString() {
        return "Seat{" +"seatNumber='"+seatNumber + '\'' +", price=" + price +'}';
    }
}