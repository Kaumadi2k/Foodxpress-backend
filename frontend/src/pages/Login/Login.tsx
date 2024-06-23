import React from 'react'
import { Box, Card, CardContent, CardMedia, TextField, Typography } from '@mui/material'
import './Login.css'
import { assets } from '../../assets/assets'

const Login = () => {
  return (
    <Box
      border='1px solid black'
      display='flex'
      height='100vh'
      alignItems='center'
      justifyContent='center'
    >
      <Card className='loginCard'>
        <CardContent className='cardContent'>
          <Box padding='10px'>
            <Typography variant='h5'>Login</Typography>
          </Box>
          <Box padding='10px'>
            <TextField required label="Email"></TextField>
          </Box>
          <Box padding='10px'>
            <TextField required label="Password" type='password'></TextField>
          </Box>
        </CardContent>
        <CardMedia
        component='img'
        image={assets.header_img}
        style={{width:'30%',borderRadius:'0px'}}/>
      </Card>
    </Box>
  )
}

export default Login