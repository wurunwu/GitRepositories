package com.wu.test;

import lombok.Data;

import java.io.Serializable;

@Data
public class Users implements Serializable {
    private String username;
    private String password;

    public Users(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
