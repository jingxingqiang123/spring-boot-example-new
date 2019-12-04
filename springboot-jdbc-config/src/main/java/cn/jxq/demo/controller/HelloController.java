package cn.jxq.demo.controller;

import cn.jxq.demo.pojo.User;
import cn.jxq.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.List;


@RestController
public class HelloController {

    @Autowired
    private UserService userService;

    @Autowired
    private DataSource dataSource;


    @GetMapping("hello")
    @ResponseBody
    @Transactional
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
    @RequestMapping("jdbc")
    public String TestJdbc() {


        return "hello Sping Boot " + dataSource;

    }
}
