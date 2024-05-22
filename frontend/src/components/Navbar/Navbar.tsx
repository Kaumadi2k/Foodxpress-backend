import React from 'react'
import './NavBar.css'
import { assets } from '../../assets/assets'
import { Button, IconButton } from '@mui/material'
import { ShoppingCartRounded } from '@mui/icons-material'

function Navbar() {
  return (
    <div className='Navbar'>
      <img src={assets.logo2} className='logo'></img>
      <div className="contents">
        <ul>
          <li>Home</li>
          <li>About Us</li>
          <li>Contact Us</li>
          <li><IconButton aria-label='cart'><ShoppingCartRounded fontSize='large' sx={{color:'black'}}/></IconButton></li>
          <li><Button variant='contained'>Login</Button></li>
        </ul>
      </div>
    </div>
  );
}

export default Navbar