package com.nf.demo.service;

import com.nf.demo.model.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
//    boolean checkEmail(String email);
    User loginUser(String name);
}
