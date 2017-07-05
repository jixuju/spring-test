package com.superwind.test3rabbitmq.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by jiangxj on 2017/7/4.
 */
@Component
public class SenderService {
    @Autowired
    private AmqpTemplate rabbitTemplate;
    @Autowired
    private Queue queue;

    public void send(String message) {
        String context = message + " " + new Date();
        System.out.println("Sender : " + context);
        rabbitTemplate.convertAndSend("one", context);
    }

}
