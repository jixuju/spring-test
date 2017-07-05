package com.superwind.test3rabbitmq.web;

import com.superwind.test3rabbitmq.service.SenderService;
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

    @PostMapping("/testMQ/send")
    public void addUser(@RequestBody String message) {
        senderService.send(message);
    }
}
