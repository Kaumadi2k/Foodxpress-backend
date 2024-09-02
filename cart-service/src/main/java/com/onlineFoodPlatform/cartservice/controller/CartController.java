package com.onlineFoodPlatform.cartservice.controller;

import com.onlineFoodPlatform.cartservice.dto.CartItemDto;
import com.onlineFoodPlatform.cartservice.dto.CartRequest;
import com.onlineFoodPlatform.cartservice.model.Cart;
import com.onlineFoodPlatform.cartservice.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/cart")
@RequiredArgsConstructor
@CrossOrigin("*")
public class CartController {

    private final CartService cartService;
    @PostMapping
    public String createCart(@RequestBody CartRequest cartRequest){
        cartService.createCart(cartRequest);
        return "Cart created successfully";
    }

    @PostMapping("/{cartId}/{productId}")
    public String addProductToCart(@PathVariable long cartId, @PathVariable long productId){
        cartService.addProductToCart(cartId,productId);
        return "Product added to cart successfully";
    }

    @DeleteMapping("/{cart_id}")
    public String deleteCart(@PathVariable long cart_id){
        cartService.deleteCart(cart_id);
        return "Cart successfully deleted";
    }

    @GetMapping("/{cart_id}")
    public Optional<Cart> getCart(@PathVariable long cart_id){
        return cartService.getCart(cart_id);
    }

    @GetMapping("/user/{userId}")
    public List<Cart> getUserCarts(@PathVariable String userId){
        return cartService.getUserCarts(userId);
    }

}
