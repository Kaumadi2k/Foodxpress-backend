package com.onlineFoodPlatform.productservice.service;

import com.onlineFoodPlatform.productservice.dto.CategoryDto;
import com.onlineFoodPlatform.productservice.dto.CategoryResponse;
import com.onlineFoodPlatform.productservice.model.Category;
import com.onlineFoodPlatform.productservice.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final FileStorageService fileStorageService;

    public void addCategory(String categoryName, MultipartFile file){
        String fileName = fileStorageService.storeFile(file,"category");
        Category category = Category.builder()
                .categoryName(categoryName)
                //.categoryDescription(categoryDescription)
                .imgUrl(fileName)
                .build();

        categoryRepository.save(category);
    }

    public List<CategoryResponse> getAllCategory(){
        List<Category> categoryList = categoryRepository.findAll();
        return categoryList.stream().map(this::mapToCategoryResponse).toList();
    }

    private CategoryResponse mapToCategoryResponse(Category category) {
        String imgPath = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/v1/files/category/")
                .path(category.getImgUrl())
                .toUriString();
        return CategoryResponse.builder()
                .categoryName(category.getCategoryName())
                //.categoryDescription(category.getCategoryDescription())
                .imgUrl(imgPath)
                .build();
    }

    public CategoryResponse getCategoryById(long categoryId){
        Optional<Category> category = categoryRepository.findById(categoryId);
        String imgPath = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/v1/files/category/")
                .path(category.get().getImgUrl())
                .toUriString();
        return CategoryResponse.builder()
                .categoryName(category.get().getCategoryName())
                .imgUrl(imgPath)
                .build();
    }
}
