package com.nf.demo.service;

import com.nf.demo.model.User;
import com.nf.demo.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

@Service
@RequestScope
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private User user;

    @Override
    public User createUser(User user) {
        if (checkEmail(user.getEmail()) || checkUserName(user.getUserName())) {
            System.out.println("EmailOrUserNameExist");
        } else {
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public User loginUser(String name) {
        return userRepository.findByUserName(name);
    }

    private boolean checkUserName(String userName) {
        return userRepository.existsByUserName(userName);
    }

    private boolean checkEmail(String email) {
        return userRepository.existsByEmail(email);
    }

//    private void validateUserName(String name) {
//        if(!userRepository.findByUserName(user.getUserName()).getUserName().equals(name)) {
//            throw new RuntimeException("UserNameNotFound");
//        }
//    }
//
//    private void validatePassword(String password) {
//        if (!userRepository.findByUserName(user.getUserName()).getPassword().equals(password)) {
//            throw new RuntimeException("PasswordIsNotCorrect");
//        }
//    }
}
