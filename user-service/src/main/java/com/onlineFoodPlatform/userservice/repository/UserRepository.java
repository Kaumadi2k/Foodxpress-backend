package com.onlineFoodPlatform.userservice.repository;

import com.onlineFoodPlatform.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
