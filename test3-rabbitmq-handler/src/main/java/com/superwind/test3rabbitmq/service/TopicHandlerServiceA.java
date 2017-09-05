package com.superwind.test3rabbitmq.service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by jiangxj on 2017/7/4.
 */
@Component
@RabbitListener(queues = "topic.A")
public class TopicHandlerServiceA {
    @RabbitHandler
    public void process(String message) {
        System.out.println("Receiver : " + message);
    }

//    @RabbitHandler
//    public void processObj(UserInfo userInfo) {
//        System.out.println("Receiver object : " + userInfo);
//    }
}
