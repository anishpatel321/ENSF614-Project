package com.anish.FlightApp;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

/**
 * 
 * This controller takes the flight number from the api and stores it into the user's session
 * It also calls on the basecost getter to get the base cost and store it into the user's session
 * 
 */


@RestController
@RequestMapping("/api")
public class FlightNumberController {

	@PostMapping("/send_flight_number/{flightNumber}")
	public String sendFlightNumber(@PathVariable String flightNumber, @RequestBody String additionalData) {
		
		System.out.println(flightNumber);

        UserSession userSession = UserSession.getInstance();

        // Set the selectedFlight value to the instance
        userSession.setSelectedFlight(flightNumber);
        
        BaseCostGetter b = new BaseCostGetter();
        userSession.setBaseCost(b.getBaseCost(flightNumber));
        
        
        
        return "Success";
    }
}