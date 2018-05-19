package com.superwind.web;

import com.superwind.model.User;
import com.superwind.pojo.UserBean;
import com.superwind.service.RedisCacheUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jiangxj on 2017/6/12.
 */
@RestController
public class RedisCacheUserController {
    @Autowired
    private RedisCacheUserService redisCacheUserService;

    @PostMapping("/test/rediscache/saveUser")
    public void save(@RequestBody UserBean userBean){
        User user = new User();
        BeanUtils.copyProperties(userBean,user);
        redisCacheUserService.save(userBean.getOperType(),user);
    }

    @PostMapping("/test/rediscache/qryUser")
    public UserBean qryUser(@RequestBody User user){
        return redisCacheUserService.findByPk(user.getId());
    }

    @PostMapping("/test/rediscache/delUser")
    public void delUser(@RequestBody User user){
        redisCacheUserService.delete(user.getId());
    }

}
