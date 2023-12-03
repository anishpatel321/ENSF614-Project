package com.anish.FlightApp;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * This takes the JSON object from the LoginController (given from front end) to parse it into values to be used
 * by logincontroller.
 * 
 */

public class LoginRequest  {

	private String username;
	private String password;
	
	@JsonCreator
	public LoginRequest (@JsonProperty("username") String username,
			@JsonProperty("password") String password) {
		this.username = username;
		this.password = password;
	}
	public String getUsername(){
		return username;
	};
	public String getPassword(){
		return password;
	};
}