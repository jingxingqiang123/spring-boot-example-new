package com.tech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsMessagingTemplate;

@SpringBootApplication
@EnableJms //启动消息队列
public class ActivemqServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActivemqServerApplication.class, args);
    }

}
