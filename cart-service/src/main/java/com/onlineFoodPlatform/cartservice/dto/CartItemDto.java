package com.onlineFoodPlatform.cartservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItemDto {
    //private long id;
    private String product_id;
    //private String product_name;
    private Integer quantity;
    //private BigDecimal price;
}
