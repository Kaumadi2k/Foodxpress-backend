import React, { useEffect, useState } from 'react';
import { Card, CardContent, CardMedia, Typography, Grid  } from '@mui/material';
import { listProduct } from '../services/productService';

const Product = () => {

const [product, setProduct] = useState([]);
useEffect(()=>{
  listProduct().then((response)=>{
    setProduct(response.data);
  }).catch(error=>{
    console.error(error);
  })
}, [])


  return (
    product.map(product =>
    <Grid item style={{display:'flex',alignItems:'center', border:'2px solid orange', borderRadius:'5px', margin:'4px'}}>
    <Card style={{width:'300px',boxShadow:'none'}}>
      <CardMedia
        component="img"
        alt="green iguana"
        height="250"
        width="140"
        image={product.imgUrl}
      />
      <CardContent>
        <Typography variant="h5" component="h2">
          {product.name}
        </Typography>
        <Typography variant="body2" color="textSecondary" component="p">
          {product.description}
        </Typography>
        <Typography variant="h6" component="p">
          Price: Rs.{product.pricePerUnit}
        </Typography>
      </CardContent>
    </Card>
    </Grid>
    )
  );
}

export default Product;