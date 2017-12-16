package com.superwind.test3rabbitmq.service;

import com.superwind.test3rabbitmq.pojo.UserInfo;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by jiangxj on 2017/7/4.
 */
@Component
@RabbitListener(queues = "direct" , containerFactory="rabbitListenerContainerFactory")
public class DirectHandlerService {
    @RabbitHandler
    public void process(String message) {
        System.out.println("Receiver : " + message);
    }

    @RabbitHandler
    public void processMap(Map map) {
        System.out.println("Receiver object : " + map);
    }

    @RabbitHandler
    public void processObj(UserInfo userInfo) {
        System.out.println("Receiver object : " + userInfo.toString());
    }
}
