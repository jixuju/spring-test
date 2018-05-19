package com.superwind.test4kafkaproducer.service;

import com.superwind.test4kafkaproducer.pojo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

/**
 * Created by jiangxj on 2017/7/4.
 */
@Component
public class SenderService {
    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void send(String message) {
        String context = message + " " + new Date();
        System.out.println("Sender : " + context);
        Message m = new Message();
        String id = UUID.randomUUID().toString();
        m.setId(id);
        m.setMsg(context);
        m.setSendTime(new Date());
        kafkaTemplate.send("test1", id, m.toString());
    }

}
