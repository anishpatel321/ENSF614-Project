package com.anish.FlightApp.Database;

import java.util.List;

public interface SQLController {


    // Save data to the database table
    <T> void saveTable(String tableName, List<T> data);

	<T> List<T> loadTable(String tableName, String colName);
}
