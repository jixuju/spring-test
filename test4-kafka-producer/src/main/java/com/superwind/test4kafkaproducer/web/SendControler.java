package com.superwind.test4kafkaproducer.web;

import com.superwind.test4kafkaproducer.service.SenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jiangxj on 2017/7/4.
 */
@RestController
public class SendControler {
    @Autowired
    SenderService senderService;

    @PostMapping("/testKafka/send")
    public void addUser(@RequestBody String message) {
        senderService.send(message);
    }
}
