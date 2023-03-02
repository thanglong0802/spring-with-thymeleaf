package com.nf.demo.service;

import com.nf.demo.model.User;

public interface UserService {
    User createUser(User user);
    User loginUser(String name);
}
