package com.onlineFoodPlatform.productservice.controller;

import com.onlineFoodPlatform.productservice.dto.ProductRequest;
import com.onlineFoodPlatform.productservice.dto.ProductResponse;
import com.onlineFoodPlatform.productservice.dto.ProductUpdate;
import com.onlineFoodPlatform.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest ProductRequest){
        productService.createProduct(ProductRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductResponse getProduct(@PathVariable String id){
        return productService.getProduct(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void updateProduct(@RequestBody ProductUpdate productUpdate){
        productService.updateProduct(productUpdate);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteProduct(@PathVariable String id){
        productService.deleteProduct(id);
    }

}
