package com.superwind.test3rabbitmq.web;

import com.superwind.test3rabbitmq.pojo.UserInfo;
import com.superwind.test3rabbitmq.service.DirectSenderService;
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
    DirectSenderService directSenderService;

    @PostMapping("/testMQ/sendDirect")
    public void send(@RequestBody String message) {
        directSenderService.send(message);
    }

    @PostMapping("/testMQ/sendObj")
    public void sendObj(@RequestBody UserInfo userInfo) {
        directSenderService.sendObj(userInfo);
    }
}
