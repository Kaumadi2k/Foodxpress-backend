package com.onlineFoodPlatform.productservice.service;

import com.onlineFoodPlatform.productservice.dto.CategoryDto;
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

    public void addCategory(CategoryDto categoryDto){
        Category category = Category.builder()
                .categoryName(categoryDto.getCategoryName())
                .categoryDescription(categoryDto.getCategoryDescription())
                .build();

        categoryRepository.save(category);
    }

    public List<CategoryDto> getAllCategory(){
        List<Category> categoryList = categoryRepository.findAll();
        return categoryList.stream().map(this::mapToCategoryDto).toList();
    }

    private CategoryDto mapToCategoryDto(Category category) {
        return CategoryDto.builder()
                .categoryName(category.getCategoryName())
                .categoryDescription(category.getCategoryDescription())
                .build();
    }

    public CategoryDto getCategoryById(String categoryId){
        Optional<Category> category = categoryRepository.findById(categoryId);
        return new CategoryDto(
                category.get().getCategoryName(),
                category.get().getCategoryDescription()
        );
    }
}
