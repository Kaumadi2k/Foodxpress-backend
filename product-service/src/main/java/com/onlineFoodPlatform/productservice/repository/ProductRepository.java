package com.onlineFoodPlatform.productservice.repository;

import com.onlineFoodPlatform.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategoryId(long categoryId);
}
