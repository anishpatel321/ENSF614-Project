import React, { useEffect } from 'react';
import './MainPage.css';
import { Link } from 'react-router-dom';

const MainPage = () => {
  useEffect(() => {
    const fetchData = async () => {
      try {
        // Make a Java API call here
        await fetch('/api/resetSession'); // Replace with your actual API endpoint
        // You can perform any action with the response if needed

        console.log('API call successful');
      } catch (error) {
        console.error('Error fetching data:', error);
      }
    };
  
  fetchData();
  }, []); // Empty dependency array ensures the effect runs only once on mount

  return (
    <div className="main-page">
      <h1>Welcome To Flight App!</h1>
      <div className="button-container">
        <Link to="/browse">
          <button>Browse as Regular User</button>
        </Link>
        <Link to="/goldlogin">
          <button>Gold Login</button>
        </Link>
        <Link to="/goldregister">
          <button>Gold Registration</button>
        </Link>
        <Link to="/stafflogin">
          <button>Staff Login</button>
        </Link>
      </div>
    </div>
  );
};

export default MainPage;