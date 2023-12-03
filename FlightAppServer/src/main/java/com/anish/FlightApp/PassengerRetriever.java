package com.anish.FlightApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PassengerRetriever extends FlightDBUtil{
	
	static List<Passenger> passengers;

    PassengerRetriever(String flight) {
     
        // JDBC connection
        try (Connection connection = getConnection()) {
            // Query to retrieve FirstName, LastName, and SeatNumber from the tickets table
            String query = "SELECT FName, LName, seat_num FROM tickets WHERE flight_number = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                preparedStatement.setString(1, flight);
                
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    passengers = new ArrayList<>();
                    
                    while (resultSet.next()) {
                        String firstName = resultSet.getString("FName");
                        String lastName = resultSet.getString("LName");
                        String seatNumber = resultSet.getString("seat_num");

                        // Create Passenger object and add to the list
                        Passenger passenger = new Passenger(firstName, lastName, seatNumber);
                        passengers.add(passenger);
                    }

                    // Print or use the list of Passenger objects as needed
                    for (Passenger passenger : passengers) {
                        System.out.println(passenger);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    List<Passenger> getPassengerList(){
    	
    	return passengers;
    }
    	
    	
  }
