package com.onlineFoodPlatform.productservice.dto;

import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ProductResponse {
    private String id;
    private String name;
    private String description;
    private BigDecimal pricePerUnit;
    private String categoryId;
    private String productUnit;
    private String imgUrl;

    public ProductResponse(String id, String name, String description, BigDecimal pricePerUnit, String productUnit, String categoryId) {
    }
}
