package com.anish.FlightApp;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 
 * This gets the seatNumber from the API and then saves it to the userSession and calls on the SeatMultiplierReciever
 * to obtain the seat cost
 * 
 */


@RestController
@RequestMapping("/api")
public class SeatNumberController {

	@PostMapping("/send_seat_number/{seatNumber}")
	public String sendSeatNumber(@PathVariable String seatNumber, @RequestBody String additionalData) {
		
		System.out.println(seatNumber);

        UserSession userSession = UserSession.getInstance();

        // Set the selectedseat value to the instance
        userSession.setSelectedSeat(seatNumber);
        
        
        new SeatMultiplierReciever(seatNumber);
        
        
        return "Success";
    }
}