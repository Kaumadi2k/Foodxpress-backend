package com.onlineFoodPlatform.productservice.service;

import com.onlineFoodPlatform.productservice.dto.ProductRequest;
import com.onlineFoodPlatform.productservice.dto.ProductResponse;
import com.onlineFoodPlatform.productservice.dto.ProductUpdate;
import com.onlineFoodPlatform.productservice.model.Product;
import com.onlineFoodPlatform.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor //in compile time create the all the required constructors
public class ProductService {

    private final ProductRepository productRepository;
    private final FileStorageService fileStorageService;

    public void createProduct(ProductRequest productRequest){
        String imageName = fileStorageService.storeFile(productRequest.getImage(),"product");
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .pricePerUnit(productRequest.getPricePerUnit())
                .productUnit(productRequest.getProductUnit())
                .categoryId(productRequest.getCategoryId())
                .imageUrl("uploads/products/"+imageName)
                .build();

        productRepository.save(product);
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
                .categoryId(product.getCategoryId())
                .productUnit(product.getProductUnit())
                .build();
    }

    public ProductResponse getProduct(String id){
        Optional<Product> product = productRepository.findById(id);
        return new ProductResponse(
                product.get().getId(),
                product.get().getName(),
                product.get().getDescription(),
                product.get().getPricePerUnit(),
                product.get().getProductUnit(),
                product.get().getCategoryId()
        );

    }

    public void updateProduct(ProductUpdate productUpdate){
        Optional<Product> product = productRepository.findById(productUpdate.getId());
        product.get().setName(productUpdate.getName());
        product.get().setDescription(productUpdate.getDescription());
        product.get().setPricePerUnit(productUpdate.getPricePerUnit());

        productRepository.save(product.get());
    }

    public void deleteProduct(String id){
        Optional<Product> product = productRepository.findById(id);
        productRepository.delete(product.get());
    }
}
