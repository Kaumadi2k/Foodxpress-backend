package com.onlineFoodPlatform.productservice.service;

import com.onlineFoodPlatform.productservice.dto.ProductResponse;
import com.onlineFoodPlatform.productservice.model.Category;
import com.onlineFoodPlatform.productservice.model.Product;
import com.onlineFoodPlatform.productservice.repository.CategoryRepository;
import com.onlineFoodPlatform.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor //in compile time create the all the required constructors
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public void createProduct(Product product){

        Optional<Category> categoryOptional = categoryRepository.findById(product.getCategory().getId());
        Category category = categoryOptional.get();
        Product product1 = Product.builder()
                .name(product.getName())
                .description(product.getDescription())
                .pricePerUnit(product.getPricePerUnit())
                .productUnit(product.getProductUnit())
                .category(category)
                .imageUrl(product.getImageUrl())
                .build();

        productRepository.save(product1);
    }

    public List<ProductResponse> getAllProducts(){
        List<Product> products = productRepository.findAll();

        //map Product class to ProductResponse class
        return products.stream().map(this::mapToProductResponse).toList();
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .pricePerUnit(product.getPricePerUnit())
                .description(product.getDescription())
                .categoryId(product.getCategory().getId())
                .productUnit(product.getProductUnit())
                .imgUrl(product.getImageUrl())
                .build();
    }

    public ProductResponse getProduct(long id){
        Optional<Product> product = productRepository.findById(id);
        Product product1 = product.get();
        return ProductResponse.builder()
                .id(product1.getId())
                .name(product1.getName())
                .description(product1.getDescription())
                .productUnit(product1.getProductUnit())
                .pricePerUnit(product1.getPricePerUnit())
                .categoryId(product1.getCategory().getId())
                .imgUrl(product1.getImageUrl())
                .build();

    }

    public void updateProduct(Product product){
        Optional<Product> OptionalProduct = productRepository.findById(product.getId());
        Product product1 = OptionalProduct.get();

        product1.setName(product.getName());
        product1.setDescription(product.getDescription());
        product1.setPricePerUnit(product.getPricePerUnit());
        //product1.setCategory(product.getCategory().getId());
        product1.setProductUnit(product.getProductUnit());
        product1.setImageUrl(product.getImageUrl());

        productRepository.save(product1);
    }

    public void deleteProduct(long id){
        Optional<Product> product = productRepository.findById(id);
        productRepository.delete(product.get());
    }

    public List<ProductResponse> getProductByCategory(long categoryId){
        //findByCategory returns the list of products,that's why directly used it to map.
        return productRepository.findByCategoryId(categoryId).stream().map(this::mapToProductResponse).toList();
    }

}
