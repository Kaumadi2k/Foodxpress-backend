package com.onlineFoodPlatform.productservice.service;


import com.onlineFoodPlatform.productservice.dto.CategoryResponse;
import com.onlineFoodPlatform.productservice.model.Category;
import com.onlineFoodPlatform.productservice.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public void addCategory(Category category){
        Category newcategory = Category.builder()
                .categoryName(category.getCategoryName())
                .imgUrl(category.getImgUrl())
                .build();

        categoryRepository.save(newcategory);
    }

    public List<CategoryResponse> getAllCategory(){
        List<Category> categoryList = categoryRepository.findAll();
        return categoryList.stream().map(this::mapToCategoryResponse).toList();
    }

    private CategoryResponse mapToCategoryResponse(Category category) {
        return CategoryResponse.builder()
                .categoryName(category.getCategoryName())
                //.categoryDescription(category.getCategoryDescription())
                .imgUrl(category.getImgUrl())
                .build();
    }

    public CategoryResponse getCategoryById(long categoryId){
        Optional<Category> category = categoryRepository.findById(categoryId);
        return CategoryResponse.builder()
                .categoryName(category.get().getCategoryName())
                .imgUrl(category.get().getImgUrl())
                .build();
    }
}
