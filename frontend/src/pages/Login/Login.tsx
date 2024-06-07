import React from 'react'
import { Container, Box, Card } from '@mui/material'

const Login = () => {
  return (
    <Container style={{marginTop:'50px',marginBottom:'50px'}}>
      <Box sx={{ bgcolor: 'white', height: '80vh', boxShadow:'0 0 10px rgba(0, 0, 0, 0.1)',borderRadius:'10px' }}>
        <Card>
          <Box sx={{display:'flex', flexDirection:'column', alignItems:'center',justifyContent:'center',height:'100%'}}>
            <h1>Login</h1>
          </Box>
        </Card>
      </Box>
    </Container>
  )
}

export default Login