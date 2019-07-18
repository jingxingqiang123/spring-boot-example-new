package com.jxq.demojsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jingxingqiang on 2019/7/17 21:02
 */
@Controller
@ResponseBody
@RequestMapping("/")
public class HelloWorldController {

    @RequestMapping("hello")
    public String Hello(){

        return "hello";
    }

}
