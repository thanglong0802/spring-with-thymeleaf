package com.nf.demo.mapper;

import com.nf.demo.dto.UserCreateForm;
import com.nf.demo.model.User;

public class Mapping {
    public UserCreateForm userCreateForm (User user, UserCreateForm userCreateForm) {
        userCreateForm.setUserName(user.getUserName());
        userCreateForm.setEmail(user.getEmail());
        return userCreateForm;
    }
}
