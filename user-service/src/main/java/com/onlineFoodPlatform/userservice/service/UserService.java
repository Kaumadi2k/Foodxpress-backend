package com.onlineFoodPlatform.userservice.service;

import com.onlineFoodPlatform.userservice.model.User;
import com.onlineFoodPlatform.userservice.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void addUser(User user){
        userRepository.save(user);
    }
}
