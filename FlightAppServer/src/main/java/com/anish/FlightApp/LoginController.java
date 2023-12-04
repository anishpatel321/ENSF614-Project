package com.anish.FlightApp;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

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
    public ResponseEntity<Void> registerUser(@RequestBody LoginRequest loginRequest) {
		
        UserLogin e = new UserLogin();
        
        
        if (e.loginUser( loginRequest.getUsername(),loginRequest.getPassword())) {
        
        
        System.out.println(loginRequest.getUsername());
        System.out.println(loginRequest.getPassword());
        
        System.out.println("login success");
        return ResponseEntity.status(HttpStatus.OK).build();
        }
        
        else {
        	System.out.println("login error");
        	return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        
    }
	
	//resets the singleton
	@GetMapping("/resetSession")
    public void resetUserSession(){
    	
    	
    	UserSession u = UserSession.getInstance();
    	u.reset();
    	
    	System.out.println("user Session Reset");
    }
}