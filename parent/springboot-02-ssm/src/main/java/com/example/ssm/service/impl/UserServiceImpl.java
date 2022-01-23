package com.example.ssm.service.impl;

import com.example.ssm.mapper.UserMapper;
import com.example.ssm.pojo.User;
import com.example.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jingxingqiang on 2019/7/17 23:51
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public String findUserNameByUserName(String username) {

        return userMapper.findUserNameByUserName(username);
    }

    @Override
    public int insertUser(User user) {
        return userMapper.insertUserInfo(user);
    }


    @Override
    public User checkByUP(String username, String password) throws Exception {
        User user = new User();
        if (username == null || password == null) {
            throw new Exception("用户名和密码不能为空");
        }
        user = userMapper.checkByUP(username, password);
        if (user == null) {
            throw new Exception("用户不存在");
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }
}
