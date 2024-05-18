package com.onlineFoodPlatform.cartservice.controller;

import com.onlineFoodPlatform.cartservice.dto.CartItemDto;
import com.onlineFoodPlatform.cartservice.dto.CartRequest;
import com.onlineFoodPlatform.cartservice.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;
    @PostMapping
    public String createCart(@RequestBody CartRequest cartRequest){
        cartService.createCart(cartRequest);
        return "Cart created successfully";
    }

    @PostMapping("/{cart_id}")
    public String addProductToCart(@PathVariable long cart_id, @RequestBody CartItemDto cartItemDto){
        cartService.addProductToCart(cart_id,cartItemDto);
        return "Product added to cart successfully";
    }

}
