import React from 'react'
import './Home.css'
import { Card, Box, CardContent, Typography, CardMedia, Button, Grid, Container } from '@mui/material'
import { assets } from '../../assets/assets'
import theme from '../../theme'

const Home = () => {
  return (
    <div className='homeContent'>
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
    
    <Grid container spacing={2} p={2} marginLeft={0}>
        <Grid item xs={12} sm={6} md={4} style={{ border: '1px solid red' }}>
          <Box display="flex" flexDirection="column" alignItems="center">
            <img
              src={assets.food_1}
              alt='fast food'
              style={{ borderRadius: '50%', width: '100%', maxWidth: '200px', height: 'auto' }}
            />
            <Typography variant="subtitle1" align="center" mt={2}>
              Fast Food
            </Typography>
          </Box>
        </Grid>
        <Grid item xs={12} sm={6} md={4} style={{ border: '1px solid red' }}>
          <Box display="flex" flexDirection="column" alignItems="center">
            <img
              src={assets.food_2}
              alt='vegetables'
              style={{ borderRadius: '50%', width: '100%', maxWidth: '200px', height: 'auto' }}
            />
            <Typography variant="subtitle1" align="center" mt={2}>
              Vegetables
            </Typography>
          </Box>
        </Grid>
        <Grid item xs={12} sm={6} md={4} style={{ border: '1px solid red' }}>
          <Box display="flex" flexDirection="column" alignItems="center">
            <img
              src={assets.food_3}
              alt='Salad'
              style={{ borderRadius: '50%', width: '100%', maxWidth: '200px', height: 'auto' }}
            />
            <Typography variant="subtitle1" align="center" mt={2}>
              Salad
            </Typography>
          </Box>
        </Grid>
    </Grid>
    </div>
  )
}

export default Home