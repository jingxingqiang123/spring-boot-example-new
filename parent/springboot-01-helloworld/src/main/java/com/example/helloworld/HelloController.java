package com.example.helloworld;

import com.example.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * Created by jingxingqiang on 2019/7/17 21:42
 */
@RestController
public class HelloController {
    // 不能定义为static不然无法获取
    @Value("${server.port}")
    private String serverPort;
    @Autowired
    private Environment environment;

    @RequestMapping("/")
    public String hello() {
        String environmentPort = environment.getProperty("server.port");
        System.out.println(environmentPort);
        return "hello: " + serverPort;
    }

    @PostMapping("/user")
    public List<User> user(@RequestBody User user) {
        System.out.println("user: " + user);
        List<User> list = new ArrayList();
        list.add(user);
        return list;
    }
}
