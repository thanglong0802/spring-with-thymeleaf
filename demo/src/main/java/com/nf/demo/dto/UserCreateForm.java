package com.nf.demo.dto;

import lombok.Data;

@Data
public class UserCreateForm {
    private int id;
    private String userName;
    private String email;
    private String password;
}
