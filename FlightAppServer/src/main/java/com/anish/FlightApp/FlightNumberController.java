package com.anish.FlightApp;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;




@RestController
@RequestMapping("/api")
public class FlightNumberController {

	@PostMapping("/send_flight_number/{flightNumber}")
	public String sendFlightNumber(@PathVariable String flightNumber, @RequestBody String additionalData) {
		
      

        System.out.println(flightNumber);

        //THIS recieves the flight number that is clicked on the site
        //add code to make this flight number the session's flight
        
        return "Success";
    }
}