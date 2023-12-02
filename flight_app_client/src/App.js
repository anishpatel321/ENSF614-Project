import React from 'react';
import './App.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import LoginPage from './pages/LoginPage';
import RegistrationPage from './pages/RegistrationPage';
import WelcomePage from './pages/WelcomePage';
import BrowseFlightsPage from './pages/BrowseFlightsPage';
import SeatMap from './pages/SeatMap';

const App = () => {
  return (
    <BrowserRouter>
      <Routes>
        <Route index element={<LoginPage/>} />
        <Route path='/register' element={<RegistrationPage />} />
        <Route path='/welcome' element={<WelcomePage />} />
        <Route path='/browse' element={<BrowseFlightsPage />} />
        <Route path='/map' element={<SeatMap />} />
      </Routes>
    </BrowserRouter>
  );
};

export default App;