import React from 'react';
import './App.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import LoginPage from './pages/LoginPage';
import RegistrationPage from './pages/RegistrationPage';
import WelcomePage from './pages/WelcomePage';
import BrowseFlightsPage from './pages/BrowseFlightsPage';
import SeatMap from './pages/SeatMap';
import CheckoutPage from './pages/CheckoutPage';
import MainPage from './pages/MainPage';
import PaymentForm from './pages/PaymentForm';
import TicketDisplay from './pages/TicketDisplay';
import StaffLoginPage from './pages/StaffLoginPage';

const App = () => {
  return (
    <BrowserRouter>
      <Routes>
        <Route index element={<MainPage/>} />
        <Route path='/goldlogin' element={<LoginPage />} />
        <Route path='/goldregister' element={<RegistrationPage />} />
        <Route path='/welcome' element={<WelcomePage />} />
        <Route path='/browse' element={<BrowseFlightsPage />} />
        <Route path='/map' element={<SeatMap />} />
        <Route path='/checkout' element={<CheckoutPage />} />
        <Route path='/pay' element={<PaymentForm />} />
        <Route path='/confirmation' element={<TicketDisplay />} />
        <Route path='/stafflogin' element={<StaffLoginPage />} />
      </Routes>
    </BrowserRouter>
  );
};

export default App;