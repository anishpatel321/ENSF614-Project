package com.anish.FlightApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 
 * This class gets the cost multiplier for the seat that is selected
 * This is to be used during checkout
 * 
 */

public class SeatMultiplierReciever extends FlightDBUtil {
	
	public SeatMultiplierReciever(String seatNumber) {
		
		try {
             //connect
            Connection connection = getConnection();

            String[] c = seatNumber.split("(?!^)");
            
            UserSession userSession = UserSession.getInstance();

            
            
            String flightNumber = userSession.getSelectedFlight();
            String row = c[0];
            String col = c[1];
            System.out.println(c[1] + c[0]+flightNumber);

            // get the multiplier value based on the seat and the flightid
            String query = "SELECT cost_multiplier FROM seats " +
                           "WHERE flight_id = (SELECT flight_id FROM flights WHERE flight_number = ?) " +
                           "AND rownum = ? AND col = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            	
                preparedStatement.setString(1, flightNumber);
                preparedStatement.setString(2, row);
                preparedStatement.setString(3, col);

                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                	
                	//store the cost multiplier
                    double costMultiplier = resultSet.getDouble("cost_multiplier");
                    
                    System.out.println("Cost Multiplier: " + costMultiplier);
                    
                    //save the multiplier to the usersession
                    userSession.setMultiplier(costMultiplier);
                    
                } else {
                    System.out.println("Seat not found or cost_multiplier not available.");
                }
            }

         //end connection
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
		
			
	}

}
