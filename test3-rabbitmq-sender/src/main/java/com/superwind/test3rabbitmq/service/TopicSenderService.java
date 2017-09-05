package com.superwind.test3rabbitmq.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by jiangxj on 2017/7/4.
 */
@Component
public class TopicSenderService {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(String message,String routingKey) {
        System.out.println("Sender : " + message);
        rabbitTemplate.convertAndSend("topicExchange", routingKey, message);
    }

}
