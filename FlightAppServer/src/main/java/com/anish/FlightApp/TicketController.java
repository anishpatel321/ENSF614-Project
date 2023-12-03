package com.anish.FlightApp;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * TickerController takes the calls from the API to view all the ticket
 * Takes the call to pass the ticket object to the API
 * 
 * INCOMPLETE CLASS!!
 */


@RestController
@RequestMapping("/api")
public class TicketController {

    @GetMapping("/viewtickets")
    public List<LineItem> getLineItems() {
    	    
        List<LineItem> checkout = new ArrayList<>();
        
        UserSession userSession = UserSession.getInstance();

        EmailPromo e = new EmailPromo();
        GoldPromo g = new GoldPromo();
        
        
        
        double goldpromo = g.getPromo( userSession.getGoldStatus());
        double emailpromo = e.getPromo( userSession.getEmailStatus());
        String Seat = userSession.getSelectedSeat();
        String flight = userSession.getSelectedFlight();
        double seatcost = userSession.getBaseCost() * userSession.getMultiplier() ;      

        LineItem lineitem = new LineItem(flight+" Seat:"+Seat, seatcost);
               
        checkout.add(lineitem);
        
        LineItem lineitem2 = new LineItem("Gold User Promo", goldpromo);
        
        checkout.add(lineitem2);
        
        LineItem lineitem3 = new LineItem("Email List Promo", emailpromo);
        
        checkout.add(lineitem3);
        
        userSession.setTotalprice(seatcost+goldpromo+emailpromo);
        
       // LineItem lineitem4 = new LineItem("TOTAL", seatcost+goldpromo+emailpromo);
        
       // checkout.add(lineitem4);
        
        
        
               
        return checkout;
        
    }
    
    @GetMapping("/TicketConfirm")
    public Ticket getTicket() {
    	    
    	Ticket t = new Ticket();  
    	
    	UserSession u = UserSession.getInstance();
               
    	t.setCardNumber(u.getCardnum());
    	t.setEmail(u.getTikemail());
    	t.setFirstName(u.getTikFName());
    	t.setLastName(u.getTikLName());
    	t.setSeatNumber(u.getSelectedSeat());
    	t.setFlightNumber(u.getSelectedFlight()); 	
    	
        return t;
        
    }
    
    
	@PostMapping(value = "/goldOrder",
			 consumes = MediaType.APPLICATION_JSON_VALUE)
   public String  createTicket(@RequestBody TicketGoldRequest Ticketrequest) {
		
       //System.out.println(registrationRequest.getEmail());
       //System.out.println(registrationRequest.getUsername());
       //System.out.println(registrationRequest.getPassword());
      
       
       UserSession s = UserSession.getInstance();
       
       s.setTikFName(Ticketrequest.getFname());
       s.setTikLName(Ticketrequest.getLname());
       s.setCardnum(Ticketrequest.getNumber());
       s.setTikemail(Ticketrequest.getEmail());
       
       System.out.println(Ticketrequest.getFname());
       System.out.println(Ticketrequest.getLname());
       System.out.println(Ticketrequest.getNumber());
       System.out.println(Ticketrequest.getEmail());
       
       
     
       TicketAdder.addTicket();
       
       
       
       
       return "Success";
   }
	
	
	
	@PostMapping("/StaffSearching")
	public String staffFlight(@RequestBody String flightNumber) {
		
		 UserSession s = UserSession.getInstance();
		 
		 s.setSelectedFlight(flightNumber);

        return "Success";
    } 
	

	
	
	
	    @GetMapping("/viewpassengers")
	    
	    public List<Passenger> getPassengers() {
	    	    
	        List<Passenger> passengers = new ArrayList<>();
	        
	        UserSession s = UserSession.getInstance();
			
	        PassengerRetriever p = new PassengerRetriever(s.getSelectedFlight());
	        
	        passengers = p.getPassengerList();       	        
	               
	        return passengers;
	        
	    }
	
}