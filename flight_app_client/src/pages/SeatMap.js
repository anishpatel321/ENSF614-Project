// SeatMap.js
import React, { useState, useEffect } from 'react';
import './SeatMap.css';
import seatMapImage from './SeatMapLegendary.JPG';  // Adjust the path as needed
import Button from '../components/Button';


const SeatMap = () => {
  const [seatData, setSeatData] = useState([]);

  useEffect(() => {
    // Fetch seat data from the Java backend
    fetch('/api/seat_data')
      .then(response => response.json())
      .then(data => setSeatData(data))
      .catch(error => console.error('Error fetching seat data:', error));
  }, []);

  const handleSeatClick = async (seatNumber) => {
    try {
        // Make an API call to send the seat number back to Java backend

        const response = await fetch(`/api/send_seat_number/${seatNumber}`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(seatNumber),
            
        });

        // Handle the response as needed
        if (response.ok) {
            console.log('seat number sent successfully');
            window.location.href = '/checkout'
            // Additional handling if necessary
        } else {
            console.error('Error sending seat number:', response.statusText);
            // Additional error handling if necessary
        }
    } catch (error) {
        console.error('Error sending seat number:', error);
        // Additional error handling if necessary
    }
    console.log(`Seat ${seatNumber} clicked`);
  };

  return (
    <div className="seat-map-container">
      <div className="seat-map">
        {/* Display the seat map image */}
        <img src={seatMapImage} alt="Seat Map" />
      </div>

      {/* Display seat numbers and costs on the right side */}
      <div className="seat-info">
        <h2>Available Seats</h2>
        <div className='seat-table'>
        <table>
            <thead>
                <tr>
                <th>Seat Number</th>
                <th>Cost</th>
                </tr>
            </thead>
            <tbody>
                {seatData.map(({ seatNumber, price }) => (
                <tr key={seatNumber}>
                    <td>
                        <Button 
                            label={seatNumber} 
                            onClick ={() => handleSeatClick(seatNumber)}
                        />
                    </td>
                    <td>${price}</td>
                </tr>
                ))}
            </tbody>
        </table>
        </div>
      </div>
    </div>
  );
};

export default SeatMap;