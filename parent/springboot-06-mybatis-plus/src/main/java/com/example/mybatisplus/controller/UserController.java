package com.example.mybatisplus.controller;

import com.example.mybatisplus.mapper.UserMapper;
import com.example.mybatisplus.pojo.User;
import com.example.mybatisplus.service.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
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

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/")
    public List<User> user() {
        log.info(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
        return userList;
    }

    @GetMapping("/user")
    public List<User> user1(@Param("id") Long id) {
        log.info(("----- selectAll method test ------"));
        User user = new User();
        user.setId(id);
        List<User> userList = userService.getUserList(user);
        userList.forEach(System.out::println);
        return userList;
    }
}
