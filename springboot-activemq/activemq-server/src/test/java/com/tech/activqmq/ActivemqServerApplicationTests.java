package com.tech.activqmq;

import com.tech.activemq.jms.Producer;
import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.jms.Destination;

@SpringBootTest
class ActivemqServerApplicationTests {

    @Autowired
    private Producer producer;

    @Test
    void contextLoads() {
        Destination destination = new ActiveMQQueue("mytest.queue");
        for (int i = 0; i < 100; i++) {
            this.producer.sendMessage(destination, "myname is chhliu!!!" + i);
        }
    }
}


