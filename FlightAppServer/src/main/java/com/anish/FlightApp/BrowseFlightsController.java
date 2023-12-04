package com.anish.FlightApp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 
 * This controller gets a call from the api and returns a list of flights to display on the screen
 * 
 */



@RestController
@RequestMapping("/api/browse_flights")
public class BrowseFlightsController {

    

    @GetMapping
    public List<Flight> getAllFlights() {
    	
    	//create a new instance of flightloader
    	FlightLoader flightLoader = new FlightLoader();
        List<Flight> flightList =flightLoader.loadFlights();
     

        // print all values for troubleshoot
        for (Flight flight : flightList) {
            System.out.println(flight);
        }
        
        
        /**
         * 
         * THIS MUST RUN ONCE TO POPULATE THE SEAT DATABASE
         * 
         */

//       PopulatorSeats a = new PopulatorSeats();
//       PopulatorSeats.fillSeats();
        
        
        return flightList;
        
    }
}