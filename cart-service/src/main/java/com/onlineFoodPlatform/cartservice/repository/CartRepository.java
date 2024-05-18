package com.onlineFoodPlatform.cartservice.repository;

import com.onlineFoodPlatform.cartservice.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {

}
