package com.example.oscarlin.service;

import com.example.oscarlin.domain.User;

import java.util.List;

public interface UserService {

    List<User> selectAll(User user);
}
