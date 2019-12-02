package cn.itcast.controller;

import cn.itcast.pojo.User;
import cn.itcast.servcice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author: HuYi.Zhang
 * @create: 2018-05-20 09:11
 **/
@Controller
@RequestMapping
public class HelloController {


    @Autowired
    private UserService userService;

    @GetMapping("hello")
    @ResponseBody
    public User hello() {
        User user = this.userService.queryById(1L);
        return user;
    }

    @GetMapping("/all")
    public String all(Model model) {
        // 查询用户
        List<User> users = this.userService.queryAll();
        // 放入模型
        model.addAttribute("users", users);
        // 返回模板名称（就是classpath:/templates/目录下的html文件名）
        return "users";
    }
}
