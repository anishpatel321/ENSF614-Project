package com.anish.FlightApp;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * This object parses the JSON values given to the registrationcontroller and makes
 * the values available to call.
 * 
 */

public class RegistrationRequest  {

	private String username;
	private String email;
	private String password;
	private String fname;
	private String lname;
	private boolean emailsub;
	
	@JsonCreator
	
	//parse the values
	public RegistrationRequest (@JsonProperty("email") String email,
			@JsonProperty("username") String username,
			@JsonProperty("password") String password,@JsonProperty("firstName") String fname,@JsonProperty("lastName") String lname,@JsonProperty("subscribe") boolean sub) {
		this.email = email;
		this.username = username;
		this.password = password;
		this.fname= fname;
		this.lname=lname;
		this.emailsub=sub;
	}
	
	//call getters
	public String getEmail() {
		return email;
	};
	public String getUsername(){
		return username;
	};
	public String getPassword(){
		return password;
	};
	public String getfname(){
		return fname;
	};
	public String getlname(){
		return lname;
	};
	public boolean getemailsubstatus(){
		return emailsub;
	};
}