package com.jxq.springboothiberbate.service.impl;

import com.jxq.springboothiberbate.entity.User;
import com.jxq.springboothiberbate.mapper.UserMapper;
import com.jxq.springboothiberbate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jingxingqiang on 2019/11/27 22:32
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public void saveEntity(User user) {
        userMapper.save(user);
    }

    @Override
    public User getUser(String name) {
        User user = userMapper.findByName(name);
        return user;
    }
}
