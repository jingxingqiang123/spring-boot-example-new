package com.example.mybatisplus.controller;

import com.example.mybatisplus.mapper.UserMapper;
import com.example.mybatisplus.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * UserController
 *
 * @author: admin
 * @create: 2022/07/24 10:41
 */
@RestController
@Slf4j
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/")
    public List<User> user() {
        log.info(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
        return userList;
    }
}
