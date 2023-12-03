import React, { useState } from 'react';

const StaffLoginPage = () => {
  const [credentials, setCredentials] = useState({
    username: '',
    password: '',
    flightNumber: '',
  });

  const handleInputChange = (e) => {
    setCredentials({ ...credentials, [e.target.name]: e.target.value });
  };

  const handleLogin = async () => {
    const { username, password, flightNumber } = credentials;

    // Check if the username and password match the expected values
    if (username === 'anish' && password === 'patel') {
      try {
        // Make a fetch request to your Java backend API with the flight number
        const response = await fetch('/api/StaffSearching', {
          method: 'POST',
          body: flightNumber,
        });

        if (response.ok) {
          //alert('Login successful!'); // You can replace this with any action you want
          window.location.href = '/viewpassengers'
        } else {
          alert('Error during login');
        }
      } catch (error) {
        console.error('Error during login:', error);
      }
    } else {
      alert('Invalid username or password');
    }
  };

  return (
    <div>
      <h2>Staff Login</h2>
      <form>
        <label>
          Username:
          <input
            type="text"
            name="username"
            value={credentials.username}
            onChange={handleInputChange}
          />
        </label>
        <br />
        <label>
          Password:
          <input
            type="password"
            name="password"
            value={credentials.password}
            onChange={handleInputChange}
          />
        </label>
        <br />
        <label>
          Flight Number:
          <input
            type="text"
            name="flightNumber"
            value={credentials.flightNumber}
            onChange={handleInputChange}
          />
        </label>
        <br />
        <button type="button" onClick={handleLogin}>
          Login
        </button>
      </form>
    </div>
  );
};

export default StaffLoginPage;