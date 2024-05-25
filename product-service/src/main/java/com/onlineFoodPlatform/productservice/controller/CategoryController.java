package com.onlineFoodPlatform.productservice.controller;

import com.onlineFoodPlatform.productservice.dto.CategoryDto;
import com.onlineFoodPlatform.productservice.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/v1/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    @PostMapping(consumes = "multipart/form-data")
    public String addCategory(@RequestParam("categoryName") String categoryName,@RequestParam("categoryDescription") String categoryDescription,@RequestParam("file") MultipartFile file){
        categoryService.addCategory(categoryName,categoryDescription,file);
        return "Product Category added successfully";
    }

    @GetMapping
    public List<CategoryDto> getAllCategory(){
        return categoryService.getAllCategory();
    }

    @GetMapping("/{id}")
    public CategoryDto getCategoryById(@PathVariable String categoryId){
        return categoryService.getCategoryById(categoryId);
    }

//    @PostMapping(consumes = "multipart/form-data")
//    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
//        if (file.isEmpty()) {
//            return new ResponseEntity<>("File is empty", HttpStatus.BAD_REQUEST);
//        }
//        // Store file logic here
//        return new ResponseEntity<>("File uploaded successfully", HttpStatus.OK);
//    }

}
