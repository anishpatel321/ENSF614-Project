package com.anish.FlightApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserRegisterer extends FlightDBUtil {

	
    public static void insertUser(String username, String email, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            String sql = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);
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
