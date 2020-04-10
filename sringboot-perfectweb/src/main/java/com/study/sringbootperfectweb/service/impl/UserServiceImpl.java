package com.study.sringbootperfectweb.service.impl;

import com.study.sringbootperfectweb.pojo.User;
import com.study.sringbootperfectweb.service.UserService;
import org.springframework.stereotype.Service;

/**
 * 用户业务实现类
 *
 * Created by jingxingqiang on 2020/4/10 21:17
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public String addUser(User user) {
        return "success";
    }
}
