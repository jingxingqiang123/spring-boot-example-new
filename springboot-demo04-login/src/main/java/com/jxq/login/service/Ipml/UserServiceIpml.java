package com.jxq.login.service.Ipml;

import com.jxq.login.mapper.UserMapper;
import com.jxq.login.pojo.User;
import com.jxq.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jingxingqiang on 2019/7/21 21:00
 */
@Service
public class UserServiceIpml implements UserService {

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
}


