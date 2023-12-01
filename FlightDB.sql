Create schema FlightDB;

USE FlightDB;
-- Create a table for user profiles
CREATE TABLE users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
    -- Add other user-related fields as needed
);

-- Create a table for plane information
CREATE TABLE planes (
    plane_id INT PRIMARY KEY AUTO_INCREMENT,
    plane_name VARCHAR(255) NOT NULL,
    capacity INT NOT NULL
    -- Add other plane-related fields as needed
);

-- Create a table for flight information
CREATE TABLE flights (
    flight_id INT PRIMARY KEY AUTO_INCREMENT,
    flight_number VARCHAR(10) NOT NULL,
    departure_city VARCHAR(255) NOT NULL,
    destination_city VARCHAR(255) NOT NULL,
    departure_date DATE NOT NULL,
    departure_time TIME NOT NULL,
    arrival_time TIME NOT NULL,
    plane_id INT,
    FOREIGN KEY (plane_id) REFERENCES planes(plane_id)
    -- Add other flight-related fields as needed
);

-- Create a table for passenger lists
CREATE TABLE passengers (
    passenger_id INT PRIMARY KEY AUTO_INCREMENT,
    flight_id INT,
    user_id INT,
    seat_number VARCHAR(10) NOT NULL,
    FOREIGN KEY (flight_id) REFERENCES flights(flight_id),
    FOREIGN KEY (user_id) REFERENCES users(user_id)
    -- Add other passenger-related fields as needed
);

-- Insert data into the planes table
INSERT INTO planes (plane_name, capacity)
VALUES
    ('Boeing 737', 150),
    ('Airbus A320', 180),
    ('Boeing 777', 300);

-- Insert data into the flights table
INSERT INTO flights (flight_number, departure_city, destination_city, departure_date, departure_time, arrival_time, plane_id)
VALUES
    ('FL001', 'New York', 'Los Angeles', '2023-12-01', '08:00:00', '11:00:00', 1),
    ('FL002', 'Los Angeles', 'Chicago', '2023-12-01', '12:00:00', '15:00:00', 2),
    ('FL003', 'Chicago', 'Houston', '2023-12-01', '16:00:00', '19:00:00', 3);
