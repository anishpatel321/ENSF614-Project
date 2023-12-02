package com.anish.FlightApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SQLIO implements SQLController {

    private String SQLURL;
    private String username;
    private String password;

    public SQLIO(String SQLURL, String username, String password) {
        this.SQLURL = SQLURL;
        this.username = username;
        this.password = password;
    }

    @Override
    public <T> List<T> loadTable(String tableName, String colName) {
        List<T> schema = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(SQLURL, username, password);
             Statement statement = connection.createStatement()) {

            // Execute SQL query to retrieve schema information
            String query = "SELECT * FROM " + tableName;
            ResultSet resultSet = statement.executeQuery(query);

            // Process the ResultSet to extract schema details
            // (This is a basic example; you may need to adapt this based on your database structure)
            while (resultSet.next()) {
                // Retrieve schema details and add them to the list
                // For example, assuming your schema details are strings, replace String with the actual type
                String schemaDetail = resultSet.getString(colName);
                schema.add((T) schemaDetail);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions appropriately
        }

        return schema;
    }

	@Override
	public <T> void saveTable(String tableName, List<T> data) {
		try (Connection connection = DriverManager.getConnection(SQLURL, username, password);
	             Statement statement = connection.createStatement()) {

	            // Create the table if it doesn't exist
	            String createTableQuery = "CREATE TABLE IF NOT EXISTS " + tableName + " (column_name VARCHAR(255))";
	            statement.executeUpdate(createTableQuery);

	            // Insert data into the table
	            for (T schemaDetail : data) {
	                // Assuming your schema details are strings, replace String with the actual type
	                String insertQuery = "INSERT INTO " + tableName + " (column_name) VALUES ('" + schemaDetail + "')";
	                statement.executeUpdate(insertQuery);
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	            // Handle exceptions appropriately
	        }
		
	}
}