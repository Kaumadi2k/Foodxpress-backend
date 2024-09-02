package com.onlineFoodPlatform.cartservice.service;

import com.onlineFoodPlatform.cartservice.dto.CartItemDto;
import com.onlineFoodPlatform.cartservice.dto.CartRequest;
import com.onlineFoodPlatform.cartservice.dto.ProductResponse;
import com.onlineFoodPlatform.cartservice.model.Cart;
import com.onlineFoodPlatform.cartservice.model.CartItem;
import com.onlineFoodPlatform.cartservice.repository.CartItemRepository;
import com.onlineFoodPlatform.cartservice.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class CartService {
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
//    private final WebClient.Builder webClientBuilder;

    public void createCart(CartRequest cartRequest){
        Cart cart = new Cart();
        cart.setCart_name(cartRequest.getCartName());
        cart.setUserId(cartRequest.getUserId());

        cartRepository.save(cart);
    }

    public void addProductToCart(long cartId,long productId){
        Optional<Cart> optionalCart = cartRepository.findById(cartId);
        if(optionalCart.isPresent()){
          Cart cart = optionalCart.get();
          CartItem cartItem = new CartItem();
          cartItem.setProduct_id(productId);
          cartItem.setQuantity(1);

            //add cartItem to cart
            cart.getCartItemList().add(cartItem);
            cartItemRepository.save(cartItem);
            cartRepository.save(cart);
        }
        else {
            throw new RuntimeException("Cart Not found");
        }
    }

    public void deleteCart(long cart_id){
        Optional<Cart> cart = cartRepository.findById(cart_id);
        cartRepository.delete(cart.get());
    }

    public Optional<Cart> getCart(long cart_id){
        Optional<Cart> cart =  cartRepository.findById(cart_id);
        return cart;
    }

    public List<Cart> getUserCarts(String userId){
       List<Cart> carts;
        carts = cartRepository.findByUserId(userId);
        return carts;
    }
}
