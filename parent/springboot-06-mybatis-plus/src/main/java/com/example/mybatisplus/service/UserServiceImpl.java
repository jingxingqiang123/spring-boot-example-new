package com.example.mybatisplus.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.mybatisplus.mapper.UserMapper;
import com.example.mybatisplus.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * UserServiceIml
 *
 * @author: admin
 * @create: 2022/07/24 22:51
 */
@Service
public class UserServiceImpl {
    @Autowired
    private UserMapper userMapper;

    public List<User> getUserList(User user) {
        LambdaQueryWrapper<User> lambdaWrapper = new LambdaQueryWrapper();
//        lambdaWrapper.eq(User::getId, user.getId());
        lambdaWrapper.eq(user.getId() != null, User::getId, user.getId());
        return userMapper.getAll(lambdaWrapper);
    }
}
