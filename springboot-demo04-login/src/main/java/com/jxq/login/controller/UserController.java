package com.jxq.login.controller;

import com.jxq.login.pojo.User;
import com.jxq.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by jingxingqiang on 2019/7/21 20:59
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    User user = new User();

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping("/uLogin")
    public String login(HttpServletRequest request, HttpSession session) throws Exception {
        String username = request.getParameter("username");
        String usernameDB = userService.findUserNameByUserName(username);
        if (usernameDB == null)
            return "redirect:register";
        String password = request.getParameter("password");
        user = userService.checkByUP(username, password);
        if (user != null) {
            session.setAttribute("user_login", user);
            return "redirect:index";
        }
        return "redirect:/";
    }

    @RequestMapping("/uregister")
    public String register(HttpServletRequest request,User user) throws Exception {
        if (user.getUsername()==null||user.getPassword()==null||user.getRealname()==null)
            throw new Exception("注册信息不能为空");
        user.setUsername(user.getUsername());
        user.setPassword(user.getPassword());
        user.setRealname(user.getRealname());
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        if (!password.equals(password2))
            throw new Exception("两次输入的密码不一致");
        userService.insertUser(user);
        return "redirect:login";
    }

}
