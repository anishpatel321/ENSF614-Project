package com.anish.FlightApp;

import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.MediaType;




@RestController
@RequestMapping("/api")
public class LoginController {

	@PostMapping(value = "/login",
			 consumes = MediaType.APPLICATION_JSON_VALUE)
    public String  registerUser(@RequestBody LoginRequest loginRequest) {
		
        //System.out.println(registrationRequest.getEmail());
        //System.out.println(registrationRequest.getUsername());
        //System.out.println(registrationRequest.getPassword());
        UserLogin.loginUser(loginRequest.getUsername(),loginRequest.getPassword());
        System.out.println(loginRequest.getUsername());
        System.out.println(loginRequest.getPassword());
        
        
        return "Success";
    }
}