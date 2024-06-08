package com.onlineFoodPlatform.productservice.repository;

import com.onlineFoodPlatform.productservice.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
