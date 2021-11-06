package com.jxq.helloworld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jingxingqiang on 2019/7/17 21:42
 */
@RestController
public class HelloController {
    @RequestMapping("/")
    public String hello(){
        return "hello";
    }
}
