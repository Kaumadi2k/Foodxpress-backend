package com.onlineFoodPlatform.productservice.controller;

import com.onlineFoodPlatform.productservice.dto.ProductRequest;
import com.onlineFoodPlatform.productservice.dto.ProductResponse;
import com.onlineFoodPlatform.productservice.dto.ProductUpdate;
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
    @PostMapping(consumes = "multipart/form-data")
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(
            @RequestParam("productName") String productName,
            @RequestParam("productDescription") String productDescription,
            @RequestParam("pricePerUnit") BigDecimal pricePerUnit,
            @RequestParam("categoryId") long categoryId,
            @RequestParam("priceUnit") String priceUnit,
            @RequestParam("image") MultipartFile image){
        productService.createProduct(productName,productDescription,pricePerUnit,categoryId,priceUnit,image);
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
    public void updateProduct(@RequestBody ProductUpdate productUpdate){
        productService.updateProduct(productUpdate);
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
