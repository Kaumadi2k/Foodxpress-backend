package com.onlineFoodPlatform.cartservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartRequest {
    private String cart_name;
    private Integer user_id;
    //public List<CartItemDto> cartItemDtoList;
}
