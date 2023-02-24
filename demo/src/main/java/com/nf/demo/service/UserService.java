package com.nf.demo.service;

import com.nf.demo.model.User;

public interface UserService {
    User registerAccount(User user);
    User loginAccount(User user);
}
