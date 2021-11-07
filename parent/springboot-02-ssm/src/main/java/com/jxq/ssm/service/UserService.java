package com.jxq.ssm.service;

import com.jxq.ssm.pojo.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User checkByUP(String username, String password) throws Exception;

    String findUserNameByUserName(String username);

    int insertUser(User user);
}
