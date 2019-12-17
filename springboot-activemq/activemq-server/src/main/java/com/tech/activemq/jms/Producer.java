package com.tech.activemq.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;

/**
 * Created by jingxingqiang on 2019/12/16 23:40
 */
@Service
public class Producer {
    // 也可以注入JmsTemplate，JmsMessagingTemplate对JmsTemplate进行了封装
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    // 发送消息，destination是发送到的队列，message是待发送的消息
    public void sendMessage(Destination destination,final String message){
        jmsMessagingTemplate.convertAndSend(destination,message);
    }
}
