package com.anish.FlightApp.Database;

import java.sql.Connection;
import java.time.LocalDate;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class FlightGenerator {

	
	public static void main(String[] args) {
        // Define the database connection parameters
        String jdbcUrl = "jdbc:mysql://localhost:3306/AirplaneDatabase";
        String username = "root";
        String password = "password";

        int numFlights = 10;
        int numSeats = 48;
		int numSeatRows = 4;
        int numBookings = numFlights * numSeats;
        int numStaff = 3;
        int numAircraft = 4;
        double numSeatPrice = 200.0;
        List<String> flightIDs = generateFlightIDs(numFlights);
		List<String> seatNames = Arrays.asList(
            "1A", "1B", "1C", "1D",
            "2A", "2B", "2C", "2D",
            "3A", "3B", "3C", "3D",
            "4A", "4B", "4C", "4D",
            "5A", "5B", "5C", "5D",
            "6A", "6B", "6C", "6D",
            "7A", "7B", "7C", "7D",
            "8A", "8B", "8C", "8D",
            "9A", "9B", "9C", "9D",
            "10A", "10B", "10C", "10D",
            "11A", "11B", "11C", "11D",
            "12A", "12B", "12C", "12D"
        );
        
        // Initialize a MySQL database connection
        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {

                       generateFlights(connection, numFlights, flightIDs, numAircraft); // Specify the number of flights to generate
                       generateSeats(connection, numSeats, numFlights, numSeatPrice, flightIDs, seatNames); 
                       generateBookings(connection, numBookings, numSeats, flightIDs); // Specify the number of bookings to generate
                       generateAirlineStaff(connection, numStaff, flightIDs); // Generate airline staff
                       generateAircraft(connection, numAircraft);
                       generateAdmin(connection);
                       
                       System.out.println("Data generation completed successfully.");
                   } catch (SQLException e) {
                       e.printStackTrace();
                   }
               }

               private static void generateFlights(Connection connection, int numFlights, List<String> flightIDs, int numAircraft) throws SQLException {
                   for (int i = 0; i < numFlights; i++) {
                       // Time window for flights
                	   // Set the startDate as the current date
                       LocalDate currentDate = LocalDate.now();
                       Date startDate = java.sql.Date.valueOf(currentDate);
                       List<String> destinations = generateDestinations();
                       List<String> origins = generateOrigins();                
                       
                       int AircraftID = ThreadLocalRandom.current().nextInt(1, numAircraft+1);
                       
                       // Set the endDate as 1 year from the start date
                       LocalDate endDate = currentDate.plusYears(1);
                       Date EndDate2 = java.sql.Date.valueOf(endDate);
                	   Date departureDate = generateRandomDate(startDate, EndDate2);
                       String destination = destinations.get(i);
                       String origin = origins.get(i);
                       String seatMap = "SeatMap" + i;

                       String insertQuery = "INSERT INTO Flights (FlightID, Origin, Destination, DepartureDate, SeatMap, AircraftID) VALUES (?, ?, ?, ?, ?, ?)";
                       try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                    	   preparedStatement.setString(1, flightIDs.get(i));
                    	   preparedStatement.setString(2, origin);
                    	   preparedStatement.setString(3, destination);
                           preparedStatement.setDate(4, new java.sql.Date(departureDate.getTime()));
                           preparedStatement.setString(5, seatMap);
                           preparedStatement.setInt(6, AircraftID);
                           preparedStatement.executeUpdate();
                       }
                   }
               }

               private static void generateSeats(Connection connection, int s, int n, double p, List<String> flightIDs, List<String> seatNames) throws SQLException {
            	    for (int i = 0; i < n; i++) {
            	        for (int seatNumber = 0; seatNumber < s; seatNumber++) {
            	            String seatType = getSeatType(seatNumber);
            	            double price = generateSeatPrice(seatType, p);

            	            String insertQuery = "INSERT INTO Seats (SeatName, FlightID, SeatType, Price) VALUES (?, ?, ?, ?)";
            	            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            	                preparedStatement.setString(1, seatNames.get(seatNumber));
								preparedStatement.setString(2, flightIDs.get(i));
            	                preparedStatement.setString(3, seatType);
            	                preparedStatement.setDouble(4, price);
            	                preparedStatement.executeUpdate();
            	            }
            	        }
            	    }
            	}
				
            	private static String getSeatType(int seatNumber) {
            	    if (seatNumber >=0 && seatNumber <17) {
            	        return "Business-Class";
            	    } else if (seatNumber >=17 && seatNumber<29) {
            	        return "Comfort";
            	    } else {
            	        return "Ordinary";
            	    }
            	}

            	private static double generateSeatPrice(String seatType, double price) {
            	    double basePrice = price;
            	    switch (seatType) {
            	        case "Business-Class":
            	            return basePrice * 2; // Business class is more than double
            	        case "Comfort":
            	            return basePrice * 1.4; // Comfort is almost 40% more
            	        case "Ordinary":
            	        default:
            	            return basePrice; // Ordinary seats have the base price
            	    }
            	}

               private static void generateUsers(Connection connection, int numUsers) throws SQLException {
                   /* for (int i = 0; i < numUsers; i++) {
                       String username = "User" + i;
                       String password = "Password" + i;
                       String email = "user" + i + "@example.com";
                       boolean membershipStatus = generateRandomMembershipStatus();

                       String insertQuery = "INSERT INTO Users (Username, Password, Email, MembershipStatus) VALUES (?, ?, ?, ?)";
                       try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {
                           preparedStatement.setString(1, username);
                           preparedStatement.setString(2, password);
                           preparedStatement.setString(3, email);
                           preparedStatement.setBoolean(4, membershipStatus);
                           preparedStatement.executeUpdate();

                           ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                           if (generatedKeys.next() && membershipStatus) {
                               int userID = generatedKeys.getInt(1);
                               String name = "test";
                               String address = "test";
                               addRegisteredUser(connection, userID, name, address);
                           }
                       }
                   } */
               }
               
               private static void addRegisteredUser(Connection connection, int userID, String name, String address) throws SQLException {
            	    String insertRegisteredUserQuery = "INSERT INTO RegisteredUsers (UserID, Name, Address) VALUES (?, ?, ?)";
            	    try (PreparedStatement preparedStatement = connection.prepareStatement(insertRegisteredUserQuery)) {
            	        preparedStatement.setInt(1, userID);
            	        preparedStatement.setString(2, name);
            	        preparedStatement.setString(3, address);
            	        preparedStatement.executeUpdate();
            	    }
            	}

               private static void generateBookings(Connection connection, int numBookings, int s, List<String> flightIDs) throws SQLException {
            	    for (int i = 0; i < numBookings; i++) {
            	        int seatID = i + 1; //One unique booking for one unique seat ID
            	        boolean insurance = generateRandomInsurance();
            	        boolean paymentStatus = generateRandomPaymentStatus();
            	        String flightID = flightIDs.get(i / s); // Use integer division to assign flightID sequentially
            	        
            	        String bookingID = generateBookingID(i);
            	        String insertQuery = "INSERT INTO Bookings (BookingID, FlightID, SeatID, Insurance, PaymentStatus) VALUES (?, ?, ?, ?, ?)";
            	        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            	            preparedStatement.setString(1, bookingID);
            	            preparedStatement.setString(2, flightID);
            	            preparedStatement.setInt(3, seatID);
            	            preparedStatement.setBoolean(4, insurance);
            	            preparedStatement.setBoolean(5, paymentStatus);
            	            preparedStatement.executeUpdate();
            	        }
            	    }
            	}
               
               private static String generateBookingID(int index) {
            	    String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            	    String numbers = "0123456789";

            	    // Use StringBuilder for efficient string concatenation
            	    StringBuilder bookingIDBuilder = new StringBuilder();

            	    // Add 2 random letters in BLOCK LETTERS
            	    for (int i = 0; i < 2; i++) {
            	        int randomIndex = new Random().nextInt(letters.length());
            	        bookingIDBuilder.append(letters.charAt(randomIndex));
            	    }

            	    // Add 4 random numbers
            	    for (int i = 0; i < 4; i++) {
            	        int randomIndex = new Random().nextInt(numbers.length());
            	        bookingIDBuilder.append(numbers.charAt(randomIndex));
            	    }

            	    return bookingIDBuilder.toString();
            	}
               
               private static String generateFlightID() {
           	    String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
           	    String numbers = "0123456789";

           	    // Use StringBuilder for efficient string concatenation
           	    StringBuilder flightIDBuilder = new StringBuilder();

           	    // Add 2 random letters in BLOCK LETTERS
           	    for (int i = 0; i < 2; i++) {
           	        int randomIndex = new Random().nextInt(letters.length());
           	        flightIDBuilder.append(letters.charAt(randomIndex));
           	    }

           	    // Add 4 random numbers
           	    for (int i = 0; i < 3; i++) {
           	        int randomIndex = new Random().nextInt(numbers.length());
           	        flightIDBuilder.append(numbers.charAt(randomIndex));
           	    }

           	    return flightIDBuilder.toString();
           	}
               
               private static List<String> generateFlightIDs(int numFlightIDs) {
                   List<String> flightIDs = new ArrayList<>();

                   for (int i = 0; i < numFlightIDs; i++) {
                       flightIDs.add(generateFlightID());
                   }

                   return flightIDs;
               }

            	    public static List<String> generateDestinations() {
            	        List<String> destinations = new ArrayList<>();
            	        destinations.add("Paris, France");
            	        destinations.add("New York City, USA");
            	        destinations.add("Tokyo, Japan");
            	        destinations.add("London, UK");
            	        destinations.add("Rome, Italy");
            	        destinations.add("Sydney, Australia");
            	        destinations.add("Barcelona, Spain");
            	        destinations.add("Las Vegas, USA");
            	        destinations.add("Cape Town, South Africa");
            	        destinations.add("Rio de Janeiro, Brazil");
            	        return destinations;
            	    }
            
              
           	    public static List<String> generateOrigins() {
           	        List<String> Origins = new ArrayList<>();
           	        Origins.add("Vancouver, BC");
           	        Origins.add("Vancouver, BC");
           	        Origins.add("Vancouver, BC");
           	        Origins.add("Calgary, AB");
           	        Origins.add("Calgary, AB");
           	        Origins.add("Calgary, AB");
           	        Origins.add("Calgary, AB");
           	        Origins.add("Calgary, AB");
           	        Origins.add("Toronto, ON");
           	        Origins.add("Toronto, ON");
           	        return Origins;
           	    }
               
           	 private static List<String> generateNames() {
                 List<String> firstNames = Arrays.asList(
                     "Alice", "Bob", "Charlie", "David", "Eva",
                     "Frank", "Grace", "Henry", "Ivy", "Jack",
                     "Katherine", "Leo", "Mia", "Nathan", "Olivia",
                     "Peter", "Quinn", "Rachel", "Sam", "Taylor"
                 );

                 List<String> lastNames = Arrays.asList(
                     "Smith", "Johnson", "Williams", "Jones", "Brown",
                     "Davis", "Miller", "Wilson", "Moore", "Taylor",
                     "Anderson", "Thomas", "Jackson", "White", "Harris",
                     "Martin", "Thompson", "Garcia", "Martinez", "Robinson"
                 );

                 List<String> fullNames = new ArrayList<>();

                 // Combine the first and last names
                 for (int i = 0; i < firstNames.size(); i++) {
                     String fullName = firstNames.get(i) + " " + lastNames.get(i);
                     fullNames.add(fullName);
                 }

                 return fullNames;
             }
           	 
               private static void generateAirlineStaff(Connection connection, int numStaff, List<String> flightIDs) throws SQLException {
            	    for (int i = 0; i < numStaff; i++) {
            	        List <String> name = generateNames();
            	        String username = "aircanadastaff";
            	        String password = "aircanadarocks123";
            	        String flightID = flightIDs.get(i % flightIDs.size()); // Use modulus to cycle through flightIDs

            	        String insertQuery = "INSERT INTO AirlineStaff (Name, Username, Password, FlightID) VALUES (?, ?, ?, ?)";
            	        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            	            preparedStatement.setString(1, name.get(i));
            	            preparedStatement.setString(2, username);
            	            preparedStatement.setString(3, password);
            	            preparedStatement.setString(4, flightID);
            	            preparedStatement.executeUpdate();
            	        }
            	    }
            	}
               
               private static void generateAircraft(Connection connection, int numAircraft) throws SQLException {
            	    for (int i = 1; i <= numAircraft; i++) {
            	        String aircraftName;
            	        switch (i) {
            	            case 1:
            	                aircraftName = "Boeing 727";
            	                break;
            	            case 2:
            	                aircraftName = "Airbus A380";
            	                break;
            	            case 3:
            	                aircraftName = "Airbus A330";
            	                break;
            	            case 4:
            	                aircraftName = "Airbus A340";
            	                break;
            	            default:
            	                throw new IllegalArgumentException("Invalid aircraft number: " + i);
            	        }

            	        Date manufacturingDate = generateRandomManufacturingDate();

            	        String insertQuery = "INSERT INTO Aircraft (AircraftID, AircraftName, ManufacturingDate) VALUES (?, ?, ?)";
            	        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            	            preparedStatement.setInt(1, i);
            	            preparedStatement.setString(2, aircraftName);
            	            preparedStatement.setDate(3, new java.sql.Date(manufacturingDate.getTime()));
            	            preparedStatement.executeUpdate();
            	        }
            	    }
            	}
               
               private static Date generateRandomManufacturingDate() {
            	    LocalDate startDate = LocalDate.of(1986, 1, 1);
            	    LocalDate endDate = LocalDate.of(2010, 12, 31);

            	    long randomTime = ThreadLocalRandom.current().nextLong(startDate.toEpochDay(), endDate.toEpochDay());
            	    return java.sql.Date.valueOf(LocalDate.ofEpochDay(randomTime));
            	}
               
               private static java.sql.Date generateRandomDate(Date startDate, Date endDate) {
            	    long randomTime = ThreadLocalRandom.current().nextLong(startDate.getTime(), endDate.getTime());
            	    return new java.sql.Date(randomTime);
            	}
               
               private static void generateAdmin(Connection connection) throws SQLException {
            	    String adminUsername = "Admin";
            	    String adminPassword = "password";

            	    String insertQuery = "INSERT INTO Admins (Username, Password) VALUES (?, ?)";
            	    try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            	        preparedStatement.setString(1, adminUsername);
            	        preparedStatement.setString(2, adminPassword);
            	        preparedStatement.executeUpdate();
            	    }
            	}
               
               private static boolean generateRandomMembershipStatus() {
                   return new Random().nextBoolean();
               }

               private static boolean generateRandomInsurance() {
                   return new Random().nextBoolean();
               }

               private static boolean generateRandomPaymentStatus() {
                   return new Random().nextBoolean();
               }
           }
