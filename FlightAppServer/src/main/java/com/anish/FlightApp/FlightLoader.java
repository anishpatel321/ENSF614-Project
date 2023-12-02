package com.anish.FlightApp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FlightLoader extends FlightDBUtil {
 
    private static final String SELECT_QUERY = "SELECT * FROM flights";

    public List<Flight> loadFlights() {
    	
    
        List<Flight> flights = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("flight_id");
                String airline = resultSet.getString("flight_number");
                String origin = resultSet.getString("departure_city");
                String destination = resultSet.getString("destination_city");
                String depdatetime = resultSet.getString("departure_datetime");
                String arrdatetime = resultSet.getString("arrival_datetime");
                double baseCost = resultSet.getDouble("base_seat_cost");
                

                // Create Flight object and add to the list
                Flight flight = new Flight(id, airline, origin, destination, depdatetime, arrdatetime, baseCost);
                flights.add(flight);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return flights;
    }
    }