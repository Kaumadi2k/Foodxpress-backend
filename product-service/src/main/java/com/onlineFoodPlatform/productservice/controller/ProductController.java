package com.onlineFoodPlatform.productservice.controller;

import com.onlineFoodPlatform.productservice.dto.ProductRequest;
import com.onlineFoodPlatform.productservice.dto.ProductResponse;
import com.onlineFoodPlatform.productservice.dto.ProductUpdate;
import com.onlineFoodPlatform.productservice.model.Product;
import com.onlineFoodPlatform.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ProductController {

    private final ProductService productService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(Product product){
        productService.createProduct(product);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductResponse getProduct(@PathVariable long id){
        return productService.getProduct(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void updateProduct(@RequestBody Product product){
        productService.updateProduct(product);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteProduct(@PathVariable long id){
        productService.deleteProduct(id);
    }

    @GetMapping("/byCategory")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getProductByCategory(@RequestParam("categoryId") long categoryId){
        return productService.getProductByCategory(categoryId);
    }

}
