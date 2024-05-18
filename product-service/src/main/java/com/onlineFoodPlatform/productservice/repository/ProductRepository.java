package com.onlineFoodPlatform.productservice.repository;

import com.onlineFoodPlatform.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
