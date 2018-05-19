package com.superwind.service;

import com.superwind.dao.UserMapper;
import com.superwind.model.User;
import com.superwind.pojo.UserBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by jiangxj on 2017/6/12.
 */
@Slf4j
@Service
public class DefaultCacheUserService {
    @Autowired
    private UserMapper userMapper;

    @CachePut(value="User", key = "#user.id.toString()")
    public User save(byte operType, User user){
        log.info("save begin ...");
        if (1 == operType){
            userMapper.insert(user);
        } else {
            userMapper.updateByPrimaryKeySelective(user);
        }
        log.info("save end ...");
        return user;
    }

    @Cacheable(value = "User", key = "#id.toString()")
    public User findByPk(Integer id){
        log.info("find begin ...");
        return userMapper.selectByPrimaryKey(id);
    }

    @CacheEvict(value = "User", key = "#id.toString()")
    public void delete(Integer id){
        log.info("delete begin ...");
        userMapper.deleteByPrimaryKey(id);
    }
}
