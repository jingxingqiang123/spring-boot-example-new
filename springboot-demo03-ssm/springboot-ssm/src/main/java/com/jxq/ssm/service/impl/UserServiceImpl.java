package com.jxq.ssm.service.impl;

import com.jxq.ssm.mapper.UserMapper;
import com.jxq.ssm.pojo.User;
import com.jxq.ssm.service.UserService;
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
    public List<User> findAll() {
        return userMapper.findAll();
    }
}
