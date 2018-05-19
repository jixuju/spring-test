package com.superwind.web;

import com.superwind.model.User;
import com.superwind.pojo.UserBean;
import com.superwind.service.GuavaCacheUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jiangxj on 2017/6/12.
 */
@RestController
public class GuavaCacheUserController {
    @Autowired
    private GuavaCacheUserService guavaCacheUserService;

    @PostMapping("/test/guavacache/saveUser")
    public void save(@RequestBody UserBean userBean){
        User user = new User();
        BeanUtils.copyProperties(userBean,user);
        guavaCacheUserService.save(userBean.getOperType(),user);
    }

    @PostMapping("/test/guavacache/qryUser")
    public UserBean qryUser(@RequestBody User user){
        return guavaCacheUserService.findByPk(user.getId());
    }

    @PostMapping("/test/guavacache/delUser")
    public void delUser(@RequestBody User user){
        guavaCacheUserService.delete(user.getId());
    }

}
