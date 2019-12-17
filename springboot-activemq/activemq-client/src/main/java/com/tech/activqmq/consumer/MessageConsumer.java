package com.tech.activqmq.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by jingxingqiang on 2019/12/16 23:53
 */
@Component
public class MessageConsumer {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    // 使用JmsListener配置消费者监听的队列，其中name是接收到的消息
    @JmsListener(destination = "test-Queue")
    public void receiveMessage(Serializable message) {

        System.out.println("Consumer收到的消息是是：" + message);

    }
}
