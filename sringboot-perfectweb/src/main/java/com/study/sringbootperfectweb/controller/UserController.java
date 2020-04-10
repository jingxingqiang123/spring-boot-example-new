package com.study.sringbootperfectweb.controller;

import com.study.sringbootperfectweb.pojo.User;
import com.study.sringbootperfectweb.service.UserService;
import com.study.sringbootperfectweb.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 用户接口
 * <p>
 * Created by jingxingqiang on 2020/4/10 21:15
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    //    /**
//     * 增加用户的接口
//     *
//     * @param user
//     * @return
//     * @Valid javax自带的注解
//     */
//    @PostMapping("/addUser")
//    public String addUser(@RequestBody @Valid User user, BindingResult bindingResult) {
//        // 如果有参数校验失败，会将错误信息封装成对象组装在BindingResult里
//        for (ObjectError error : bindingResult.getAllErrors()) {
//            return error.getDefaultMessage();
//        }
//        return this.userService.addUser(user);
//    }
    @PostMapping("/addUser")
    public String addUser(@RequestBody @Valid User user) {

        return this.userService.addUser(user);
    }

    @GetMapping("/getUser")
    public User getUser() {
        User user = new User();
        user.setId(1L);
        user.setAccount("12345678");
        user.setPassword("12345678");
        user.setEmail("123@qq.com");

        return user;
    }
}
