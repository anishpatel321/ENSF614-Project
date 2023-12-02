package com.anish.FlightApp;

public class UserSession {

    private static UserSession instance;

    private String selectedFlight;
    private String selectedSeat;
    private String username;
    private String email;
    private String paymentMethod;
    private double promo;
    private double ticketprice;

    private UserSession() {
        // Private constructor to prevent instantiation from outside the class
    }

    public static UserSession getInstance() {
        if (instance == null) {
            synchronized (UserSession.class) {
                if (instance == null) {
                    instance = new UserSession();
                }
            }
        }
        return instance;
    }

    public String getSelectedFlight() {
        return selectedFlight;
    }

    public void setSelectedFlight(String selectedFlight) {
        this.selectedFlight = selectedFlight;
    }

    public String getSelectedSeat() {
        return selectedSeat;
    }

    public void setSelectedSeat(String selectedSeat) {
        this.selectedSeat = selectedSeat;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getPromo() {
        return promo;
    }

    public void setPromo(double promo) {
        this.promo = promo;
    }

    public double getTicketprice() {
        return ticketprice;
    }

    public void setTicketprice(double ticketprice) {
        this.ticketprice = ticketprice;
    }
}