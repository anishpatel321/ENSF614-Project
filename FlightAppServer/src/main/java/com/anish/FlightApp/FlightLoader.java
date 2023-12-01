package com.anish.FlightApp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FlightLoader {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/FlightDB";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";
    private static final String SELECT_QUERY = "SELECT * FROM flights";

    public List<Flight> loadFlights() {
    	
    
        List<Flight> flights = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("flight_id");
                String airline = resultSet.getString("flight_number");
                String origin = resultSet.getString("departure_city");
                String destination = resultSet.getString("destination_city");
                String depdate = resultSet.getString("departure_date");
                String deptime = resultSet.getString("departure_time");
                String arrtime = resultSet.getString("arrival_time");
                int planeid = resultSet.getInt("plane_id");

                // Create Flight object and add to the list
                Flight flight = new Flight(id, airline, origin, destination, depdate, deptime, arrtime, planeid);
                flights.add(flight);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return flights;
    }
    }