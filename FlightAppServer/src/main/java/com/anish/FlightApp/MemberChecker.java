package com.anish.FlightApp;

/**
 * 
 * this class checks if the user is a member and returns a boolean for whether or not they are gold
 * 
 */

public class MemberChecker {
	UserSession userSession;
	
	MemberChecker(){
		
		userSession = UserSession.getInstance();
		
		
	}
	
	public boolean loggedin() {
		
		if (userSession.getGoldStatus()) {
			return true;
		}
		return false;
		
	}
	
	

}
