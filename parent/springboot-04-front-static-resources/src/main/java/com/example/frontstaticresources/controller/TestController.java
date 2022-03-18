package com.example.frontstaticresources.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * TestController
 *
 * @author: admin
 * @create: 2022/03/13 22:12
 */
@RestController
@RequestMapping("/console")
public class TestController {
    @GetMapping("/hello")
    public String hello(@RequestParam("name") String name) {
        return "hello" + name;
    }
}
