import React, { useState, useEffect } from 'react';

const CheckoutPage = () => {
  const [orderItems, setOrderItems] = useState([]);
  const [passengerInfo, setPassengerInfo] = useState({
    firstName: '',
    lastName: '',
    email: '',
    creditCardNumber: '',
  });

  useEffect(() => {
    // Fetch order line items from the Java backend API
    fetch('/api/checkout_items') // Replace with the actual API endpoint
      .then(response => response.json())
      .then(data => setOrderItems(data))
      .catch(error => console.error('Error fetching order items:', error));
  }, []);

  // Function to calculate total cost
  const calculateTotal = () => {
    return orderItems.reduce((total, item) => total + item.cost, 0).toFixed(2);
  };

  const handleInputChange = (e) => {
    setPassengerInfo({
      ...passengerInfo,
      [e.target.name]: e.target.value,
    });
  };

  const handleSubmit = async () => {
    try {
      // Make an API call to send passenger information and complete the order
      const response = await fetch('/api/goldOrder', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(passengerInfo),
      });

      if (response.ok) {
        alert('Order placed successfully!');
        window.location.href = '/confirmation';
        // Additional actions after successful order placement
      } else {
        console.error('Order placement failed.');
      }
    } catch (error) {
      console.error('Error during order placement:', error);
    }
  };

  return (
    <div>
      <h2>Checkout</h2>
      <form>
        <label>
          Passenger First Name:
          <input
            type="text"
            name="firstName"
            value={passengerInfo.firstName}
            onChange={handleInputChange}
          />
        </label>
        <br />
        <label>
          Passenger Last Name:
          <input
            type="text"
            name="lastName"
            value={passengerInfo.lastName}
            onChange={handleInputChange}
          />
        </label>
        <br />
        <label>
          Passenger Email:
          <input
            type="email"
            name="email"
            value={passengerInfo.email}
            onChange={handleInputChange}
          />
        </label>
        <br />
        <label>
          Credit Card Number:
          <input
            type="text"
            name="creditCardNumber"
            value={passengerInfo.creditCardNumber}
            onChange={handleInputChange}
          />
        </label>
      </form>
      <table>
        <thead>
          <tr>
            <th>Item</th>
            <th>Cost</th>
          </tr>
        </thead>
        <tbody>
          {orderItems.map((orderItem, index) => (
            <tr key={index}>
              <td>{orderItem.item}</td>
              <td>${orderItem.cost.toFixed(2)}</td>
            </tr>
          ))}
        </tbody>
      </table>
      <div>
        <strong>Total:</strong> ${calculateTotal()}
      </div>
      <button onClick={handleSubmit}>Place Order</button>
    </div>
  );
};

export default CheckoutPage;