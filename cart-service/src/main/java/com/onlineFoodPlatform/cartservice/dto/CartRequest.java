package com.onlineFoodPlatform.cartservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartRequest {
    private String cartName;
    private String userId;
    //public List<CartItemDto> cartItemDtoList;
}
