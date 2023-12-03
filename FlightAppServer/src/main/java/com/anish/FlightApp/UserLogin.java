package com.anish.FlightApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * 
 * UserLogin extends the FlightDBUtil and checks the user's information is in the user's table
 * and then changes the usersession to reflect their information
 * 
 */


public class UserLogin extends FlightDBUtil {

	//logs in user
    public static void loginUser(String username, String password) {
    	
    	//get the connection
    	try (Connection connection=getConnection()) {
    		//set up query
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        //create usersession instance

                    	UserSession userSession = UserSession.getInstance();

                        // set the user's information from DB into userSession singleton
                       
                    	userSession.setid(resultSet.getInt("user_id"));
                        userSession.setUsername( resultSet.getString("username"));
                        userSession.setEmail( resultSet.getString("email"));
                        userSession.setFName(resultSet.getString("FName"));
                        userSession.setLName(resultSet.getString("LName"));
                        userSession.setGoldStatus(true);
                        
                        
                        //set the values for the promos in the singleton
                        
                        if(resultSet.getString("monthly_email")=="1") {
                        userSession.setEmailStatus(true);
                        }
                        else {
                        userSession.setEmailStatus(false);
                        }
                         
                        
                    } else {
                        System.out.println("User not found or invalid credentials.");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
