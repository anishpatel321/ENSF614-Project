import React, { useEffect, useState } from 'react';
import { useHistory } from 'react-router-dom';

const CheckoutLoadingPage = () => {
  const history = useHistory();
  const [isGold, setIsGold] = useState(null);

  useEffect(() => {
    // Fetch the boolean value from the Java backend
    const fetchData = async () => {
      try {
        const response = await fetch('/api/loggedin'); // Adjust the API endpoint
        const data = await response.json();

        // Assuming the API response is an object with a boolean property named 'isGold'
        setIsGold(data.isGold);
      } catch (error) {
        console.error('Error fetching data:', error);
      }
    };

    fetchData();
  }, []);

  useEffect(() => {
    // Redirect based on the boolean value once it is fetched
    if (isGold !== null) {
      if (isGold) {
        history.push('/RegularCheckoutForm');
      } else {
        history.push('/PaymentForm');
      }
    }
  }, [isGold, history]);

  return (
    <div>
      {/* This content won't be rendered until the boolean value is fetched */}
      <h2>Fetching data...</h2>
    </div>
  );
};

export default CheckoutLoadingPage;