package com.onlineFoodPlatform.productservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    public ProductResponse(String id, String name, String description, BigDecimal pricePerUnit, String productUnit) {
    }
}
