package com.nf.demo.service;

import com.nf.demo.model.User;
import com.nf.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

@Service
@RequestScope
public class UserServiceImpl implements UserService {

    private User user;
//    private final BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
//    public UserServiceImpl(BCryptPasswordEncoder passwordEncoder, UserRepository userRepository) {
//        this.passwordEncoder = passwordEncoder;
//        this.userRepository = userRepository;
//    }

    @Override
    public User registerAccount(User user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User loginAccount(User user) {
        validateUserName();
        validatePassword();
        return user;
    }

//    private void validatePassword() {
//        if(!BCrypt.checkpw(user.getPassword(), userRepository.findByUserName(user.getUserName()).getPassword())) {
//            throw new RuntimeException("PasswordIsNotCorrect");
//        }
//    }

    private void validateUserName() {
        if(!userRepository.findByUserName(user.getUserName()).getUserName().equals(user.getUserName())) {
            throw new RuntimeException("UserNameNotFound");
        }
    }

    private void validatePassword() {
        if (!userRepository.findByUserName(user.getUserName()).getPassword().equals(user.getPassword())) {
            throw new RuntimeException("PasswordIsNotCorrect");
        }
    }
}
