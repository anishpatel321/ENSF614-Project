import React, { useState } from 'react';
import './RegistrationPage.css';
import Button from '../components/Button';


const RegistrationPage = () => {
  const [formData, setFormData] = useState({
    username: '',
    email: '',
    password: '',
  });

  const handleChange = (e) => {
    console.log('Registration !');
    setFormData({
      ...formData,
      [e.target.name]: e.target.value,
    });
  };

  const handleSubmit = async () => {
    try {
      const response = await fetch('/api/register', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(formData),
      });

      if (response.ok) {
        console.log('Registration successful!');
        window.location.href = '/login'
        // Optionally, you can redirect the user or perform other actions upon successful registration.
      } else {
        console.error('Registration failed.');
      }
    } catch (error) {
      console.error('Error during registration:', error);
    }
  };

  return (
    <div>
      <h2>Register Page</h2>
      <form>
        <label>
          Username:
          <input type="text" name="username" value={formData.username} onChange={handleChange} />
        </label>
        <br />
        <label>
          Email:
          <input type="email" name="email" value={formData.email} onChange={handleChange} />
        </label>
        <br />
        <label>
          Password:
          <input type="password" name="password" value={formData.password} onChange={ handleChange} />
        </label>
        <br />
        <Button
          label = {"Register"} 
          onClick={ handleSubmit} 
        />
      </form>
    </div>
  );
};

export default RegistrationPage;