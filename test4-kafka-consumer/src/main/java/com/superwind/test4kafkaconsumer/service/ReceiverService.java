package com.superwind.test4kafkaconsumer.service;

import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Created by jiangxj on 2017/7/4.
 */
@Component
@KafkaListener(topics = "test1")
public class ReceiverService {
    @KafkaHandler
    public void process(String message) {
        System.out.println("Receiver : " + message);
    }
}
