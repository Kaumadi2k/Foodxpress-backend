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

import java.util.Optional;

@Service

public class CartService {
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final WebClient.Builder webClientBuilder;

    public CartService(CartRepository cartRepository, CartItemRepository cartItemRepository, WebClient.Builder webClientBuilder) {
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
        //this.webClient = webClient;
        this.webClientBuilder = webClientBuilder;
    }

    public void createCart(CartRequest cartRequest){
        Cart cart = new Cart();
        cart.setCart_name(cartRequest.getCart_name());
        cart.setUser_id(cartRequest.getUser_id());

//        List<CartItem> cartItems = cartRequest.getCartItemDtoList()
//                .stream()
//                .map(this::mapToDto)
//                .toList();
//        cart.setCartItemList(cartItems);
        cartRepository.save(cart);

        //Add a product to cart getting from product microservice
//        webClient.get()
//                .uri("http://localhost:8080/api/v1/product")
//                .retrieve()
//                .bodyToMono(ProductResponse.class)
//                .block();
    }

    public void addProductToCart(long cart_id,CartItemDto cartItemDto){
        Optional<Cart> optionalCart = cartRepository.findById(cart_id);
        if(optionalCart.isPresent()){
          Cart cart = optionalCart.get();

        //Get product details from product microservice to add the product to cart
            ProductResponse productResponse = webClientBuilder.build().get()
                    .uri("http://product-service/api/v1/product/"+cartItemDto.getProduct_id())
                    .retrieve()
                    .bodyToMono(ProductResponse.class)
                    .block();

            CartItem cartItem = new CartItem();
            cartItem.setProduct_id(productResponse.getId());
            cartItem.setProduct_name(productResponse.getName());
            cartItem.setQuantity(cartItemDto.getQuantity());
            cartItem.setPrice(productResponse.getPrice());

            //add cartItem to cart
            cart.getCartItemList().add(cartItem);
            cartItemRepository.save(cartItem);
            cartRepository.save(cart);
        }
        else {
            throw new RuntimeException("Cart Not found");
        }
    }


//    private CartItem mapToDto(CartItemDto cartItemDto) {
//        CartItem cartItem = new CartItem();
//        cartItem.setProduct_id(cartItemDto.getProduct_id());
//        cartItem.setProduct_name(cartItemDto.getProduct_name());
//        cartItem.setQuantity(cartItemDto.getQuantity());
//        return cartItem;
//    }
}
