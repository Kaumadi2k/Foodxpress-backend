package com.onlineFoodPlatform.userservice.controller;

import com.onlineFoodPlatform.userservice.model.User;
import com.onlineFoodPlatform.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
@CrossOrigin("*")
public class UserController {

    private final UserService userService;
    @PostMapping
    public String addUser(@RequestBody User user){
        userService.addUser(user);
        return "User successfully added";
    }

}
