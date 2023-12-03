package com.anish.FlightApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * SeatUpdater extends the FlightDBUtil and can be used to change the value of seat to occupied or not occupied
 * 
 */

public class SeatUpdater extends FlightDBUtil {
	
	public static void occupySeat(String flightNumber, String seatnum) {
        

		 String[] c = seatnum.split("(?!^)");
         
         String row = c[0];
         String col = c[1];
		
	        // JDBC connection
	        try (Connection connection = getConnection()) {
	            // Query to update the occupied status
	        	
	        	        	
	        	String flightIdQuery = "SELECT flight_id FROM flights WHERE flight_number = ?";
	           String flightId;

	            try (PreparedStatement flightIdStatement = connection.prepareStatement(flightIdQuery)) {
	                flightIdStatement.setString(1, flightNumber);

	                try (ResultSet resultSet = flightIdStatement.executeQuery()) {
	                    
	                	if (resultSet.next()) {
	                		flightId = resultSet.getString("flight_id");
	                    } 
	                	else {
	                        System.out.println("Flight not found for the specified flight number.");
	                        return;
	                    }
	                }
	            }
	          
	            	            
	            String updateQuery = "UPDATE seats SET occupied = true WHERE flight_id = ? AND rownum = ? AND col = ?";

	            try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
	            	
	                preparedStatement.setString(1, flightId);
	              
	                preparedStatement.setString(2, row);
	               
	                preparedStatement.setString(3, col);

	                // Execute the update
	                int rowsAffected = preparedStatement.executeUpdate();

	                if (rowsAffected>0) {
	                    System.out.println("Seat updated successfully.");
	                } else {
	                    System.out.println("No seat found for the specified criteria.");
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	
	

}
