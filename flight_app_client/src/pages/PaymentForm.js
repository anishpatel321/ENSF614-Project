import React, { useState } from 'react';


const PaymentForm = () => {
  const [formData, setFormData] = useState({
    firstName: '',
    lastName: '',
    cardNumber: '',
  });

  const handleChange = (e) => {
    setFormData({
      ...formData,
      [e.target.name]: e.target.value,
    });
  };

  const handleSubmit = async () => {
    try {
      // Make an API call to send the payment information to Java backend
      const response = await fetch('/api/submit_payment', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(formData),
      });

      if (response.ok) {
        console.log('Payment successful!');
        // Redirect or perform other actions after successful payment
      } else {
        console.error('Payment failed.');
      }
    } catch (error) {
      console.error('Error during payment:', error);
    }
  };

  return (
    <div>
      <h2>Payment Form</h2>
      <form>
        <label>
          First Name:
          <input
            type="text"
            name="firstName"
            value={formData.firstName}
            onChange={handleChange}
          />
        </label>
        <br />
        <label>
          Last Name:
          <input
            type="text"
            name="lastName"
            value={formData.lastName}
            onChange={handleChange}
          />
        </label>
        <br />
        <label>
          Card Number:
          <input
            type="text"
            name="cardNumber"
            value={formData.cardNumber}
            onChange={handleChange}
          />
        </label>
        <br />
        <button type="button" onClick={handleSubmit}>
          Checkout
        </button>
      </form>
    </div>
  );
};

export default PaymentForm;