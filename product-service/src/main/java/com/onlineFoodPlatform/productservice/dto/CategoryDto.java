package com.onlineFoodPlatform.productservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {
    private String categoryName;
    private MultipartFile categoryImg;

    public CategoryDto(String categoryName, String imgUrl) {
    }
}
