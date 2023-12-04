// BrowseFlightsPage.js
import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';

const FlightsPage = () => {
    const [flights, setFlights] = useState([]);

    useEffect(() => {
        // Fetch flights from the backend
        fetch('/api/browse_flights')
            .then(response => response.json())
            .then(data => setFlights(data))
            .catch(error => console.error('Error fetching flights:', error));
    }, []);

    const handleFlightClick = async (flightNumber) => {
        try {
            // Make an API call to send the flight number back to Java

            const response = await fetch(`/api/send_flight_number/${flightNumber}`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(flightNumber),
                
            });

            // Handle the response
            if (response.ok) {
                console.log('Flight number sent successfully');
                // Additional handling 
            } else {
                console.error('Error sending flight number:', response.statusText);
                // Additional error handling
            }
        } catch (error) {
            console.error('Error sending flight number:', error);
            // Additional error handling
        }
    };

    return (
        <div>
            <h1>Browse Flights</h1>
            <table>
                <thead>
                    <tr>
                        <th>Flight Number</th>
                        <th>Origin</th>
                        <th>Destination</th>
                        <th>Departure</th>
                        <th>Arrival</th>
                        <th>Starting Price</th>
                    </tr>
                </thead>
                <tbody>
                    {flights.map(flight => (
                        <tr key={flight.flightNumber}>
                            <td>
                                {/* Make the flight number clickable and link to another page */}
                                <Link
                                    to={`/map`}
                                    onClick={() => handleFlightClick(flight.flightNumber)}
                                >
                                    {flight.flightNumber}
                                </Link>
                            </td>
                            <td>{flight.origin}</td>
                            <td>{flight.destination}</td>
                            <td>{flight.departureDateTime}</td>
                            <td>{flight.arrivalDateTime}</td>
                            <td>${(flight.baseCost).toFixed(2)}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
};

export default FlightsPage;