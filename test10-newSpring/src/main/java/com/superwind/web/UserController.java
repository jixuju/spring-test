package com.superwind.web;

import com.superwind.pojo.UserInfo;
import com.superwind.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jiangxj on 2018/4/11.
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/test/qryUser")
    public UserInfo qryUser(@RequestBody UserInfo userInfo) {
        return userService.qryUser(userInfo);
    }
}
