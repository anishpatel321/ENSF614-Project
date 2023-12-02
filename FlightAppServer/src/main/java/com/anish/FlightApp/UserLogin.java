package com.anish.FlightApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserLogin extends FlightDBUtil {

	
    public static void loginUser(String username, String password) {
    	try (Connection connection = getConnection()) {
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        // User found, retrieve information
                        String userName = resultSet.getString("username");
                        String email = resultSet.getString("email");
                        String paymentMethod = resultSet.getString("payment_method");

                        System.out.println("User Information:");
                        System.out.println("Username: " + userName);
                        System.out.println("Email: " + email);
                        System.out.println("Payment Method: " + paymentMethod);
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
