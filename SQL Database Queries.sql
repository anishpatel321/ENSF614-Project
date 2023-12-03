Create schema FlightAPPDB;

Use FlightAPPDB;

CREATE TABLE users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    FName VARCHAR(255) NOT NULL,
    Lname VARCHAR(255) NOT NULL,
    monthly_email BOOLEAN NOT NULL,
    gold BOOLEAN NOT NULL

);
INSERT INTO users (user_id, username, password, email, FName, Lname, monthly_email, gold)
VALUES (999, 'generaluser', 'password', 'dummy@example.com', 'Dummy', 'User', false, false);

CREATE TABLE seats (
    seat_id INT PRIMARY KEY AUTO_INCREMENT,
    flight_id INT NOT NULL,
    rownum INT DEFAULT NULL,
    col CHAR(1) DEFAULT NULL,
    occupied BOOLEAN DEFAULT false,
    user_id INT DEFAULT NULL,
    cost_multiplier DECIMAL(10, 2) DEFAULT NULL,
    FOREIGN KEY (flight_id) REFERENCES flights(flight_id),
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE flights (
    flight_id INT PRIMARY KEY AUTO_INCREMENT,
    flight_number VARCHAR(255) NOT NULL,
    departure_city VARCHAR(255) NOT NULL,
    destination_city VARCHAR(255) NOT NULL,
    departure_datetime DATETIME NOT NULL,
    arrival_datetime DATETIME NOT NULL,
    base_seat_cost DECIMAL(10, 2) NOT NULL
);

INSERT INTO flights (flight_number, departure_city, destination_city, departure_datetime, arrival_datetime, base_seat_cost)
VALUES
('CA101', 'Calgary', 'Vancouver', '2023-01-01 08:00:00', '2023-01-01 10:00:00', ROUND((RAND() * 1300) + 100, 2)),
('CA102', 'Vancouver', 'Calgary', '2023-01-01 12:00:00', '2023-01-01 14:00:00', ROUND((RAND() * 1300) + 100, 2)),
('CA103', 'Calgary', 'Edmonton', '2023-01-02 09:30:00', '2023-01-02 10:30:00', ROUND((RAND() * 1300) + 100, 2)),
('CA104', 'Edmonton', 'Calgary', '2023-01-02 12:00:00', '2023-01-02 13:00:00', ROUND((RAND() * 1300) + 100, 2)),
('CA105', 'Vancouver', 'Edmonton', '2023-01-03 11:00:00', '2023-01-03 12:30:00', ROUND((RAND() * 1300) + 100, 2)),
('CA106', 'Edmonton', 'Vancouver', '2023-01-03 14:00:00', '2023-01-03 16:00:00', ROUND((RAND() * 1300) + 100, 2)),
('CA107', 'Calgary', 'Vancouver', '2023-01-04 08:30:00', '2023-01-04 10:30:00', ROUND((RAND() * 1300) + 100, 2)),
('CA108', 'Vancouver', 'Calgary', '2023-01-04 12:30:00', '2023-01-04 14:30:00', ROUND((RAND() * 1300) + 100, 2)),
('CA109', 'Calgary', 'Edmonton', '2023-01-05 10:00:00', '2023-01-05 11:00:00', ROUND((RAND() * 1300) + 100, 2)),
('CA110', 'Edmonton', 'Calgary', '2023-01-05 13:00:00', '2023-01-05 14:00:00', ROUND((RAND() * 1300) + 100, 2));



CREATE TABLE tickets (
    ticket_id INT PRIMARY KEY AUTO_INCREMENT,
    FName VARCHAR(255),
    seat_num VARCHAR(255),
    LName VARCHAR(255),
    flight_number VARCHAR(255),
    email VARCHAR(255),
    user_id int DEFAULT NULL,
    cardnumber int,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);


