package com.onlineFoodPlatform.cartservice.repository;

import com.onlineFoodPlatform.cartservice.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
