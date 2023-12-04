package com.anish.FlightApp;

/**
 * 
 * SINGLETON CLASS:
 * 
 * stores data for the user's session
 * all necessary data gets stored and can be used and updated during the session
 * there is a reset method to clear the values for a new user.
 * 
 */


public class UserSession {

    private static UserSession instance;

    private String selectedFlight;
    private String FName;
    private String LName;
    private String TikFName;
    private String TikLName;
    private int cardnum;
    private int id;
    private String selectedSeat;
    private String username;
    private String email;
    private String paymentMethod;
    private double promo;
    private double ticketprice;
    private double baseCost;
    private double multiplier;
    private boolean gold;
    private boolean monthlyemail;
    private double totalprice;
    private String Tikemail;
    
    

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

    
    public String getFName() {
        return FName;
    }

    public void setFName(String FName) {
        this.FName = FName;
    }
    
    public String getLName() {
        return LName;
    }

    public void setLName(String LName) {
        this.LName = LName;
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
    
    public double getBaseCost() {
        return baseCost;
    }

    public void setBaseCost(double baseCost) {
        this.baseCost = baseCost;
    }
    
    public double getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(double multiplier) {
        this.multiplier = multiplier;
    }
    
    public boolean getGoldStatus() {
        return gold;
    }

    public void setGoldStatus(boolean gold) {
        this.gold = gold;
    }
    public boolean getEmailStatus() {
        return monthlyemail;
    }

    public void setEmailStatus(boolean monthlyemail) {
        this.monthlyemail = monthlyemail;
    }
    
    public double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(double totalprice) {
        this.totalprice = totalprice;
    }
    
    public String getTikFName() {
        return TikFName;
    }

    public void setTikFName(String TikFName) {
        this.TikFName = TikFName;
    }
    
    public String getTikLName() {
        return TikLName;
    }

    public void setTikLName(String TikLName) {
        this.TikLName = TikLName;
    }
    
    public String getTikemail() {
        return Tikemail;
    }

    public void setTikemail(String Tikemail) {
        this.Tikemail = Tikemail;
    }
    
    public int getCardnum() {
    	return cardnum;
    }
    
    public void setCardnum(int cardnum) {
    	this.cardnum= cardnum;
    }
    
    public int getid() {
    	return id;
    }
    
    public void setid(int id) {
    	this.id= id;
    }
    
    public void reset() {
        selectedFlight = null;
        FName = null;
        LName = null;
        selectedSeat = null;
        username = null;
        email = null;
        paymentMethod = null;
        promo = 0.0;
        ticketprice = 0.0;
        baseCost = 0.0;
        multiplier = 0.0;
        gold = false;
        monthlyemail = false;
        totalprice = 0.0;
        TikFName=null;
        TikLName =null;
        cardnum =0;
        id=0;
        Tikemail=null;
        System.out.println("reset");
        //new SendEmail(); //change receiver email
    }
}