package com.anish.FlightApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 
 * UserRegisterer extends FlightDBUtil and takes the user's information and inserts it into the db for storage
 * 
 * 
 */


public class UserRegisterer extends FlightDBUtil {

	//store user 
    public static void insertUser(String username, String email, String password, String fname, String lname, boolean emailsub) {
        
    	//connect
    	Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
        	//insert values
            connection = getConnection();
            String sql = "INSERT INTO users (username, password, email, FName, LName, monthly_email, gold) VALUES (?, ?, ?, ?, ?, ?, ?)";
            preparedStatement =connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(3,email);
            preparedStatement.setString(2,password);
            preparedStatement.setString(4,fname);
            preparedStatement.setString(5,lname);
            
            //check emailsub boolean that was given to the function
            if (emailsub) {
            	preparedStatement.setString(6,"1");
            }
            else {
            	preparedStatement.setString(6,"0");
            }
            preparedStatement.setString(7,"1");
            preparedStatement.executeUpdate();
            System.out.println("User added to the database.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to add user to the database.");
        } finally {
            closeConnection(connection);
            closePreparedStatement(preparedStatement);
        }
    }

	
}
