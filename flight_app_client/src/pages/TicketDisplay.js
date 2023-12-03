import React, { useEffect, useState } from 'react';

const TicketDisplay = () => {
  const [ticket, setTicket] = useState(null);

  useEffect(() => {
    const fetchTicketData = async () => {
      try {
        // Fetch ticket data from the Java backend API
        const response = await fetch('/api/TicketConfirm'); // Replace with the actual API endpoint
        const ticketData = await response.json();

        // Assuming the API response is a JSON object representing the ticket
        setTicket(ticketData);
      } catch (error) {
        console.error('Error fetching ticket data:', error);
      }
    };

    fetchTicketData();
  }, []);

  return (
    <div>
      <h2>Ticket Information</h2>
      {ticket && (
        <table>
          <thead>
            <tr>
              <th>First Name</th>
              <th>Last Name</th>
              <th>Seat Number</th>
              <th>Email</th>
              <th>Card Number</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>{ticket.firstName}</td>
              <td>{ticket.lastName}</td>
              <td>{ticket.seatNumber}</td>
              <td>{ticket.email}</td>
              <td>{ticket.cardNumber}</td>
            </tr>
          </tbody>
        </table>
      )}
    </div>
  );
};

export default TicketDisplay;
