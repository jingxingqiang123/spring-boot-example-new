package com.jxq.springboothiberbate.service;


import com.jxq.springboothiberbate.entity.User;

public interface UserService {

    void saveEntity(User user);

    User getUser(String name);
}
