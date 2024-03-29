package com.example.ssm.service;

import com.example.ssm.pojo.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User checkByUP(String username, String password) throws Exception;

    String findUserNameByUserName(String username);

    int insertUser(User user);
}
