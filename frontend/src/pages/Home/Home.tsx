import React, { useEffect, useState } from 'react'
import './Home.css'
import { Card, Box, CardContent, Typography, CardMedia, Button, Grid,TextField,InputAdornment } from '@mui/material'
import { assets } from '../../assets/assets'

import { listCategory } from '../../services/productService'
import { Search } from '@mui/icons-material'
import Product from '../../components/Product'



const Home = () => {

  const [category, setCategory] = useState([]);

  useEffect(()=>{
    listCategory().then((response)=>{
      setCategory(response.data);
    }).catch(error=>{
      console.error(error);
    })
  }, [])
  
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
    
    <Grid container spacing={2} marginLeft={0}>
      {category.map(category=>
        <Grid item  style={{cursor:'pointer' }}>
          <Box display="flex" flexDirection="column" alignItems="center" margin={1} padding={1}>
            <img
              src={category.imgUrl}
              style={{ borderRadius: '60%', width: '100%', maxWidth: '100px', height:'auto'}}
            />
            <Typography variant="subtitle1" align="center" mt={2}>
              {category.categoryName}
            </Typography>
          </Box>
      </Grid>
      )}
      <Grid item style={{display:'flex',alignItems:'center'}}>
        <TextField fullWidth
            id="filled-search"
            label="Search Food Products"
            type="search"
            variant="outlined"
            style={{width:'400px',marginLeft:'50px'}}
            InputProps={{
              endAdornment: (
                <InputAdornment position="end">
                  <Search />
                </InputAdornment>
              ),
            }}
        />
      </Grid>
    </Grid>
    <Grid container spacing={0}>
      <Product/>
    </Grid>
    
    </div>
  )
}

export default Home