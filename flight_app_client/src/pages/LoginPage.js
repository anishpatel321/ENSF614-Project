import React from 'react';
import  { useState } from 'react';
import './LoginPage.css';
import Button from '../components/Button';


const LoginPage = () => {
  const [formData, setFormData] = useState({
    username: '',
    password: '',
  });

  const handleChange = (e) => {
    setFormData({
      ...formData,
      [e.target.name]: e.target.value,
    });
  };

  const handleSubmit = async () => {
    try {
      const response = await fetch('/api/login', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(formData),
      });

      if (response.ok) {
        console.log('Login successful!');
        window.location.href = '/welcome'
      } else {
        console.error('login failed.');
      }
    } catch (error) {
      console.error('Error during login:', error);
    }
  };

  return (
    <div>
    <h2>Login Page</h2>
    <form>
      <label>
        Username:
        <input type="text" name="username" value={formData.username} onChange={handleChange} />
      </label>
      <br />
      <label>
        Password:
        <input type="password" name="password" value={formData.password} onChange={handleChange} />
      </label>
      <br />
      <Button
        label = {"Log In"} 
        onClick={handleSubmit} 
      />
    </form>
    <Button 
        label = {"Register"} 
        onClick={() => window.location.href = '/register'}
      />
  </div>
  );
};

export default LoginPage;