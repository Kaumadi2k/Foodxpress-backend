package com.onlineFoodPlatform.productservice.controller;

import com.onlineFoodPlatform.productservice.dto.CategoryResponse;
import com.onlineFoodPlatform.productservice.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    @PostMapping(consumes = "multipart/form-data")
    public String addCategory(@RequestParam("categoryName") String categoryName,@RequestParam("file") MultipartFile file){
        categoryService.addCategory(categoryName,file);
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

//    @PostMapping(consumes = "multipart/form-data")
//    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
//        if (file.isEmpty()) {
//            return new ResponseEntity<>("File is empty", HttpStatus.BAD_REQUEST);
//        }
//        // Store file logic here
//        return new ResponseEntity<>("File uploaded successfully", HttpStatus.OK);
//    }

}
