package com.superwind.test3rabbitmq.service;

import com.superwind.test3rabbitmq.pojo.UserInfo;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

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
        System.out.println("Sender : " + message);
        rabbitTemplate.convertAndSend("direct", message);
    }

    public void sendObj(UserInfo userInfo) {
        System.out.println("Sender object: " + userInfo);
        rabbitTemplate.convertAndSend("direct", userInfo);
    }

    public void sendMap(UserInfo userInfo) {
        Map<String,String> map = new HashMap();
        map.put("id",String.valueOf(userInfo.getId()));
        map.put("name",userInfo.getName());
        map.put("sex",String.valueOf(userInfo.getSex()));
        System.out.println("Sender map: " + map);
        rabbitTemplate.convertAndSend("direct", map);
    }
}
