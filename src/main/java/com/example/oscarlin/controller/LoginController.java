package com.example.oscarlin.controller;

import com.example.oscarlin.domain.User;
import com.example.oscarlin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoginController {
    @Autowired
    private UserService userService;
    @GetMapping("/selectALL")
    public List<User> selectALL(User user){
        return userService.selectAll(user);
    }
}
