package com.anish.FlightApp;

/**
 * 
 * Object to store the line items for the checkout
 * Stores the item name and the cost for each object
 * 
 */

public class LineItem {

    private String item;
    private double cost;

    public LineItem() {
    }

    public LineItem(String item, double cost) {
       this.item = item;
       this.cost = cost;
    }

    public double getCost() {
    	return cost;
    }
    
    public void setCost(double cost) {
    	this.cost = cost;
    }
    
    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item =  item;
    }

}
