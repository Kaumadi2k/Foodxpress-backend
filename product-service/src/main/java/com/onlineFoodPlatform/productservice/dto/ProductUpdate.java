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
public class ProductUpdate {
    private long id;
    private String name;
    private String description;
    private BigDecimal pricePerUnit;
    private long categoryId;
    private String productUnit;
}
