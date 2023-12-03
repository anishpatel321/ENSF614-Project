package com.anish.FlightApp;

/**
 * 
 * This implementation of the promos interface
 * is for the gold membership promo. It returns the promo value for gold
 * members
 * 
 */

class GoldPromo implements Promos {
	
	
    public double getPromo(boolean condition) {
    	
    	if (condition) {
		return -99.99;
    	}
    	return 0;
        
    }

 
}