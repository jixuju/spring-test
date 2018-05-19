package com.superwind.web;

import com.superwind.model.User;
import com.superwind.pojo.UserBean;
import com.superwind.service.EhCacheCacheUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jiangxj on 2017/6/12.
 */
@RestController
public class EhCacheCacheUserController {
    @Autowired
    private EhCacheCacheUserService ehCacheCacheUserService;

    @PostMapping("/test/ehcache/saveUser")
    public void save(@RequestBody UserBean userBean){
        User user = new User();
        BeanUtils.copyProperties(userBean,user);
        ehCacheCacheUserService.save(userBean.getOperType(),user);
    }

    @PostMapping("/test/ehcache/qryUser")
    public UserBean qryUser(@RequestBody User user){
        return ehCacheCacheUserService.findByPk(user.getId());
    }

    @PostMapping("/test/ehcache/delUser")
    public void delUser(@RequestBody User user){
        ehCacheCacheUserService.delete(user.getId());
    }

}
