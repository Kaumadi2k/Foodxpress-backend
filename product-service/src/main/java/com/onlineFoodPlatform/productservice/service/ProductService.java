package com.onlineFoodPlatform.productservice.service;

import com.onlineFoodPlatform.productservice.dto.ProductRequest;
import com.onlineFoodPlatform.productservice.dto.ProductResponse;
import com.onlineFoodPlatform.productservice.dto.ProductUpdate;
import com.onlineFoodPlatform.productservice.model.Category;
import com.onlineFoodPlatform.productservice.model.Product;
import com.onlineFoodPlatform.productservice.repository.CategoryRepository;
import com.onlineFoodPlatform.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor //in compile time create the all the required constructors
public class ProductService {

    private final ProductRepository productRepository;
    private final FileStorageService fileStorageService;
    private final CategoryRepository categoryRepository;

    public void createProduct(String productName, String productDescription, BigDecimal pricePerUnit, long categoryId, String priceUnit, MultipartFile image){
        String imageName = fileStorageService.storeFile(image,"product");

        Optional<Category> categoryOptional = categoryRepository.findById(categoryId);
        Category category = categoryOptional.get();

        Product product = Product.builder()
                .name(productName)
                .description(productDescription)
                .pricePerUnit(pricePerUnit)
                .productUnit(priceUnit)
                .category(category)
                .imageUrl(imageName)
                .build();

        productRepository.save(product);
    }

    public List<ProductResponse> getAllProducts(){
        List<Product> products = productRepository.findAll();

        //map Product class to ProductResponse class
        return products.stream().map(this::mapToProductResponse).toList();
    }

    private ProductResponse mapToProductResponse(Product product) {
        String imgPath = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/v1/files/product/")
                .path(product.getImageUrl())
                .toUriString();

        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .pricePerUnit(product.getPricePerUnit())
                .description(product.getDescription())
                .categoryId(product.getCategory().getId())
                .productUnit(product.getProductUnit())
                .imgUrl(imgPath)
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

    public void updateProduct(ProductUpdate productUpdate){
        Optional<Product> product = productRepository.findById(productUpdate.getId());
        product.get().setName(productUpdate.getName());
        product.get().setDescription(productUpdate.getDescription());
        product.get().setPricePerUnit(productUpdate.getPricePerUnit());

        productRepository.save(product.get());
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
