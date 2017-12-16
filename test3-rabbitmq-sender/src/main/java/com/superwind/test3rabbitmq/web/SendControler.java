package com.superwind.test3rabbitmq.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.superwind.test3rabbitmq.pojo.UserInfo;
import com.superwind.test3rabbitmq.service.DirectSenderService;
import com.superwind.test3rabbitmq.util.CustomNullValueMapper;
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

    @PostMapping("/testMQ/sendString")
    public void send(@RequestBody UserInfo userInfo) {
        ObjectMapper mapper = new CustomNullValueMapper();
        try {
            directSenderService.send(mapper.writeValueAsString(userInfo));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/testMQ/sendObj")
    public void sendObj(@RequestBody UserInfo userInfo) {
        directSenderService.sendObj(userInfo);
    }

    @PostMapping("/testMQ/sendMap")
    public void sendMap(@RequestBody UserInfo userInfo) {
        directSenderService.sendMap(userInfo);
    }
}
