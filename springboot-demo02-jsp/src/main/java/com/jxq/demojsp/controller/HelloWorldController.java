package com.jxq.demojsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jingxingqiang on 2019/7/17 21:02
 */
@Controller
@RequestMapping("/")
public class HelloWorldController {

    @RequestMapping("hello")
    public String Hello(){

        return "hello";
    }

}
