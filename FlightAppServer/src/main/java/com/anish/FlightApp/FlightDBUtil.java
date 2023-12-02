package com.anish.FlightApp;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

abstract class FlightDBUtil {

	    private static final String URL = "jdbc:mysql://localhost:3306/FlightAPPDB";
	    private static final String USER = "root";
	    private static final String PASSWORD = "password";

	    public static Connection getConnection() throws SQLException {
	        return DriverManager.getConnection(URL, USER, PASSWORD);
	    }

	    public static void closeConnection(Connection connection) {
	        try {
	            if (connection != null) {
	                connection.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    
	    protected static void closePreparedStatement(PreparedStatement preparedStatement) {
	        try {
	            if (preparedStatement != null) {
	                preparedStatement.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
