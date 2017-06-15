package com.superwind.web;

import com.superwind.model.User;
import com.superwind.pojo.UserBean;
import com.superwind.service.DefaultCacheUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jiangxj on 2017/6/12.
 */
@RestController
public class DefaultCacheUserController {
    @Autowired
    private DefaultCacheUserService defaultCacheUserService;

    @PostMapping("/test/defaultcache/saveUser")
    public void save(@RequestBody UserBean userBean){
        User user = new User();
        BeanUtils.copyProperties(userBean,user);
        defaultCacheUserService.save(userBean.getOperType(),user);
    }

    @PostMapping("/test/defaultcache/qryUser")
    public User qryUser(@RequestBody User user){
        return defaultCacheUserService.findByPk(user.getId());
    }

    @PostMapping("/test/defaultcache/delUser")
    public void delUser(@RequestBody User user){
        defaultCacheUserService.delete(user.getId());
    }

}
