package com.jxq.springboothiberbate.controller;

import com.jxq.springboothiberbate.common.ResponseEntity;
import com.jxq.springboothiberbate.entity.User;
import com.jxq.springboothiberbate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by jingxingqiang on 2019/11/27 22:31
 */
@Controller
@RequestMapping("/user/")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("save")
    @ResponseBody
    public String save(@RequestBody User user) {
        userService.saveEntity(user);
        return "success";
    }
    @RequestMapping("get")
    @ResponseBody
    public ResponseEntity get(@RequestParam("name") String name) {
        User user = userService.getUser(name);

        return new ResponseEntity(user);
    }
}
