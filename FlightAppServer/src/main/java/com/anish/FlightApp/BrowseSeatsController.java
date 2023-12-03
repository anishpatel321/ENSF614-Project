package com.anish.FlightApp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * 
 * This controller gets a call from the api with the user's selected flight number
 * it then returns all of the seats that are not occupied on the plane for the user to select from
 * 
 * 
 */

@RestController
@RequestMapping("/api/seat_data")
public class BrowseSeatsController {

    

    @GetMapping
    public List<Seat> getAllSeats() {
    	
    	//create new seatLoader instance
    	SeatLoader seatLoader= new SeatLoader();
    	//create new list for the seats to get stored
        List<Seat> seatList= seatLoader.getSeatsForFlight();
     

        // print for troubleshooting
        for (Seat seat :seatList) {
            System.out.println(seat);
        }
        
        
        return seatList;
        
    }
}