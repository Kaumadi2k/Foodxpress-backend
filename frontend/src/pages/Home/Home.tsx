import React from 'react'
import './Home.css'
import { Card, Box, CardContent, Typography, CardMedia, Button } from '@mui/material'
import { assets } from '../../assets/assets'
import theme from '../../theme'

const Home = () => {
  return (
    <Card sx={{display:'flex',padding:2,boxShadow:'none'}}>
      <Box sx={{display:'flex', flexDirection:'column', bgcolor:'primary.main', borderTopLeftRadius:8, borderBottomLeftRadius:8}}>
        <CardContent sx={{flex:'1 0 auto'}}>
          <Typography variant='h3' gutterBottom color='secondary'>Welcome to FoodXpress</Typography>
          <Typography variant='h5' gutterBottom color='secondary'>Discover Delicousness at your fingertips.</Typography>
          <Typography variant='subtitle1' gutterBottom color='secondary'>Whether you're craving a gourmet meal, a quick bite, or something in between, FoodXpress brings your favorite dishes from top local restaurants right to you. Enjoy a seamless and delightful food ordering experience with just a few clicks.</Typography>
          <Button variant='outlined' color='secondary'>Register Now</Button>
        </CardContent>
      </Box>
      <CardMedia
        component="img"
        sx={{width:700, borderTopLeftRadius:0,borderBottomLeftRadius:0}}
        image={assets.header_img}
        alt='header image'/>
    </Card>
  )
}

export default Home