// SeatMap.js
import React, { useState, useEffect } from 'react';
import './SeatMap.css';
import seatMapImage from './SeatMap.JPG';  // Adjust the path as needed

const SeatMap = () => {
  const [seatData, setSeatData] = useState([]);

  useEffect(() => {
    // Fetch seat data from the Java backend
    fetch('/api/seat_data')
      .then(response => response.json())
      .then(data => setSeatData(data))
      .catch(error => console.error('Error fetching seat data:', error));
  }, []);

  const handleSeatClick = (seatNumber) => {
    // Handle seat click, e.g., navigate to a new page or perform an action
    console.log(`Seat ${seatNumber} clicked`);
  };

  return (
    <div className="seat-map-container">
      <div className="seat-map">
        {/* Display the seat map image */}
        <img src={seatMapImage} alt="Seat Map" />

        {/* Display clickable seat numbers */}
        {seatData.map(({ seatNumber, seatCost }) => (
          <div
            key={seatNumber}
            className="seat-number"
            style={{ left: `${seatNumber * 30}px` }}
            onClick={() => handleSeatClick(seatNumber)}
          >
            {seatNumber}
          </div>
        ))}
      </div>

      {/* Display seat numbers and costs on the right side */}
      <div className="seat-info">
        <h2>Seat Information</h2>
        <ul>
          {seatData.map(({ seatNumber, seatCost }) => (
            <li key={seatNumber}>
              Seat {seatNumber}: ${seatCost}
            </li>
          ))}
        </ul>
      </div>
    </div>
  );
};

export default SeatMap;