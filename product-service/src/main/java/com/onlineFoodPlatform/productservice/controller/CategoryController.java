package com.onlineFoodPlatform.productservice.controller;

import com.onlineFoodPlatform.productservice.dto.CategoryResponse;
import com.onlineFoodPlatform.productservice.model.Category;
import com.onlineFoodPlatform.productservice.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String addCategory(Category category){
        categoryService.addCategory(category);
        return "Product Category added successfully";
    }

    @GetMapping
    public List<CategoryResponse> getAllCategory(){
        return categoryService.getAllCategory();
    }

    @GetMapping("/{categoryId}")
    public CategoryResponse getCategoryById(@PathVariable long categoryId){
        return categoryService.getCategoryById(categoryId);
    }


}
