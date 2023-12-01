import React from 'react';
import './WelcomePage.css';
import Button from '../components/Button';

function WelcomePage() {
 
  const viewTickets = () => {
    // Redirect to the view tickets page or perform any other action
    // For now, simply log a message to the console
    console.log('View Tickets clicked');
  };

  return (
    <div className="welcome-container">
      <h1>Welcome to Flight App</h1>
      <div className="button-container">
      <Button 
        label = {"Browse Flights"} 
        onClick={() => window.location.href = '/browse'}
      />
        <button onClick={viewTickets}>View Tickets</button>
      </div>
    </div>
  );
}

export default WelcomePage;