package com.example.controller;

import com.example.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jingxingqiang on 2019/7/17 21:42
 */
@RestController
@Slf4j
public class SwaggerController {
//    @RequestMapping("/")
//    public String hello(){
//        return "hello";
//    }

    @PostMapping("/swagger")
    public User swagger(@RequestParam("userId") String useId, @RequestBody User user) {
        log.info("swagger useId: {} user: {} ", useId, user);
        return user;
    }


    @GetMapping("/swagger")
    public String swagger1(@RequestParam("swagger") String swagger) {
        log.info("swagger: {} ", swagger);
        return swagger;
    }
}
