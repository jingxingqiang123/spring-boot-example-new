package com.jxq.ssm.controller;

import com.jxq.ssm.pojo.User;
import com.jxq.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by jingxingqiang on 2019/7/17 23:49
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    public String findAll(Model model) {
        List<User> userList = userService.findAll();
        model.addAttribute("userList",userList);

        return "userList";
    }

}
