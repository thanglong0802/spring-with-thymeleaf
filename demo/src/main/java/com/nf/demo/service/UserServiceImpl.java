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

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

//    @Override
//    public User loginAccount(String username, String password) {
//        validateUserName(username);
//        validatePassword(password);
//        return user;
//    }

//    private void validateUserName(String name) {
//        if(!userRepository.findByUserName(user.getUserName()).getUserName().equals(name)) {
//            throw new RuntimeException("UserNameNotFound");
//        }
//    }

//    private void validatePassword(String password) {
//        if (!userRepository.findByUserName(user.getUserName()).getPassword().equals(password)) {
//            throw new RuntimeException("PasswordIsNotCorrect");
//        }
//    }
}
