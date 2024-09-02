package com.onlineFoodPlatform.cartservice.repository;

import com.onlineFoodPlatform.cartservice.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findByUserId(String userId);

}
