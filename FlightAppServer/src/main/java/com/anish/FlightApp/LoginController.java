package com.anish.FlightApp;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.MediaType;

/**
 * 
 * This controller gets multiple calls from the api
 * 
 * the registerUser class is called to register the user with the data that was submitted 
 * to the class
 * 
 * The resetusersession takes the singleton  UserSession and resets it to the base case for
 * a new session.
 * 
 */


@RestController
@RequestMapping("/api")
public class LoginController {

	@PostMapping(value = "/login",
			 consumes =MediaType.APPLICATION_JSON_VALUE)
    public String  registerUser(@RequestBody LoginRequest loginRequest) {
		
        //System.out.println(registrationRequest.getEmail());
        //System.out.println(registrationRequest.getUsername());
        //System.out.println(registrationRequest.getPassword());
		
        UserLogin.loginUser( loginRequest.getUsername(),loginRequest.getPassword());
        System.out.println(loginRequest.getUsername());
        System.out.println(loginRequest.getPassword());
        
        
        return "Success";
    }
	
	//resets the singleton
	@GetMapping("/resetSession")
    public void resetUserSession(){
    	
    	
    	UserSession u = UserSession.getInstance();
    	u.reset();
    	
    	System.out.println("user Session Reset");
    }
}