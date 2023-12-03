package com.anish.FlightApp;


/**
 * This class extends the flightdbutil and provides a function that takes the flightnumber and returns the base cost for the flight
 * with the corresponding flight number in the database
 */


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BaseCostGetter extends FlightDBUtil {

	public static double getBaseCost(String flightNumber) {
        double baseCost =0.0;

        try {
        	//test connection
            Connection connection = getConnection();

           //set query
            String selectQuery = "SELECT base_seat_cost FROM flights WHERE flight_number = ?";

            
            try (PreparedStatement preparedStatement =connection.prepareStatement(selectQuery)) {
                preparedStatement.setString(1,flightNumber);

                ResultSet resultSet =preparedStatement.executeQuery();

                //get the value if there is a value that was pulled
                if (resultSet.next()) {
                    baseCost = resultSet.getDouble("base_seat_cost");
                }
            }

            // Close the connection
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return baseCost;
    }
	
}
