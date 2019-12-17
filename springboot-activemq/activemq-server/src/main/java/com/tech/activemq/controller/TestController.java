package com.tech.activemq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;
import java.io.Serializable;


/**
 * Created by jingxingqiang on 2019/12/17 22:43
 */
@RestController
public class TestController {

    //注入存放消息的队列，用于下列方法一
    @Autowired
    private Queue queue;

    //注入springboot封装的工具类

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @RequestMapping("send")
    public String send(@RequestParam("message") Serializable message) {
        //方法一：添加消息到消息队列
        jmsMessagingTemplate.convertAndSend(queue, message);
        //方法二：这种方式不需要手动创建queue，系统会自行创建名为test的队列
        //jmsMessagingTemplate.convertAndSend("test", name);
        return "消息发送成功";
    }
}
