import React from 'react';
import { Routes, Route } from 'react-router-dom';
import Home from './pages/Home/Home';
import Cart from './pages/Cart/Cart';
import Login from './pages/Login/Login';

function App() {
  return (
    <>
      <div className='app'>
        <Routes>
          <Route path='/' element={<Home/>}></Route>
          <Route path='/Cart' element={<Cart/>}></Route>
          <Route path='/Login' element={<Login/>}></Route>
        </Routes>
      </div>
    </>
  );
}

export default App;


