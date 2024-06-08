package com.onlineFoodPlatform.productservice.dto;

import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ProductResponse {
    private long id;
    private String name;
    private String description;
    private BigDecimal pricePerUnit;
    private long categoryId;
    private String productUnit;
    private String imgUrl;

    public ProductResponse(long id, String name, String description, BigDecimal pricePerUnit, String productUnit, long categoryId) {
    }
}
