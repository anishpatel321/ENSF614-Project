// ViewPassengersPage.js
import React, { useState, useEffect } from 'react';
import './ViewPassengersPage.css';

const ViewPassengersPage = () => {
  const [passengerData, setPassengerData] = useState([{}]);

  useEffect(() => {
    // Fetch passenger data from the Java backend
    fetch('/api/viewpassengers')
      .then(response => response.json())
      .then(data => setPassengerData(data))
      .catch(error => console.error('Error fetching passenger data:', error));
  }, []);

  return (
    <div className="passenger-info">
        <h2>Passengers on Selected Flight</h2>
        <div className='passenger-table'>
        <table>
            <thead>
                <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Seat Number</th>
                </tr>
            </thead>
            <tbody>
                {passengerData.map(({ firstName, lastName, seatNumber }) => (
                <tr key={seatNumber}>
                    <td>{firstName}</td>
                    <td>{lastName}</td>
                    <td>{seatNumber}</td>
                </tr>
                ))}
            </tbody>
        </table>
        </div>
      </div>
  );
};

export default ViewPassengersPage;