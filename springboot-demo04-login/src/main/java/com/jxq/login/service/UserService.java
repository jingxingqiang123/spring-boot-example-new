package com.jxq.login.service;

import com.jxq.login.pojo.User;

public interface UserService {

    User checkByUP(String username, String password) throws Exception;

    String findUserNameByUserName(String username);

    int insertUser(User user);
}
