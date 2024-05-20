package com.onlineFoodPlatform.productservice.repository;

import com.onlineFoodPlatform.productservice.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category,String> {
}
