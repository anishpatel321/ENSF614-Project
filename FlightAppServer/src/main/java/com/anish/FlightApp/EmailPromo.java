package com.anish.FlightApp;

class EmailPromo implements Promos {
	

    public double getPromo(boolean condition) {
    	
    	if (condition) {
		return -15.99;
    	}
    	return 0;
        
    }

 
}