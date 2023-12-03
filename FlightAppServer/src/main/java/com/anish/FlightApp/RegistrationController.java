package com.anish.FlightApp;

import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.MediaType;

/**
 * 
 * This controller takes a registration call and calls a registration request to parse the input
 * The inputs are put into the UserRegisterer class to insert the values into the database
 * 
 */


@RestController
@RequestMapping("/api")
public class RegistrationController {

	@PostMapping(value = "/register",
			 consumes = MediaType.APPLICATION_JSON_VALUE)
    public String  registerUser(@RequestBody RegistrationRequest registrationRequest) {
		
        //System.out.println(registrationRequest.getEmail());
        //System.out.println(registrationRequest.getUsername());
        //System.out.println(registrationRequest.getPassword());
        UserRegisterer.insertUser(registrationRequest.getUsername(), registrationRequest.getEmail(),registrationRequest.getPassword(), registrationRequest.getfname(),registrationRequest.getlname(),registrationRequest.getemailsubstatus());
        
        
        return "Success";
    }
}