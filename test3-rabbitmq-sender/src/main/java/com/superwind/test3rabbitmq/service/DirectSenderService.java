package com.superwind.test3rabbitmq.service;

import com.superwind.test3rabbitmq.pojo.UserInfo;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by jiangxj on 2017/7/4.
 */
@Component
public class DirectSenderService {
    @Autowired
    private AmqpTemplate amqpTemplate;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(String message) {
        String context = message + " " + new Date();
        System.out.println("Sender : " + context);
        rabbitTemplate.convertAndSend("direct", context);
    }

    public void sendObj(UserInfo userInfo) {
        System.out.println("Sender object: " + userInfo);
        rabbitTemplate.convertAndSend("direct", userInfo);
    }

}
