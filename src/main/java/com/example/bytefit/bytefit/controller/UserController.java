package com.example.bytefit.bytefit.controller;


import com.example.bytefit.bytefit.entity.Users;
import com.example.bytefit.bytefit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("allUsers")
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

}
