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
    private static final String USER_NAME_REGEX = "^[a-zA-Z0-9_-]{6,16}$";
    private static final String PASS_WORD_REGEX = "^[a-zA-Z0-9_-]{8,16}$";
    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\\\.[A-Za-z0-9]+)$";

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

    @Override
    public boolean validateUser(String username, String password, String email) {
        if (!isValidUserName(username)) {
            System.out.println("Tên người dùng có độ tài từ 6 đến 12 ký tự, không có khoảng trắng và không dấu");
            return false;
        } else if (!isValidPassword(password)) {
            System.out.println("Mật khẩu phải chứa ít nhất 1 ký tự số, 1 chữ thường, 1 chữ hoa và 1 ký tự đặc biệt");
            return false;
        }
//        else if (!isValidEmail(email)) {
//            System.out.println("Định dạng email không hợp lệ");
//            return false;
//        }
        return true;
    }

    public boolean isValidUserName(String username) {
        return username.matches(USER_NAME_REGEX);
    }
    public boolean isValidPassword(String password) {
        return password.matches(PASS_WORD_REGEX);
    }
    public boolean isValidEmail(String email) {
        return email.matches(EMAIL_REGEX);
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
