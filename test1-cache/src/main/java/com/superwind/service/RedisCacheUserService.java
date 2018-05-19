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
import org.springframework.cache.annotation.Caching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;

/**
 * Created by jiangxj on 2017/6/12.
 */
@Slf4j
@Service
public class RedisCacheUserService {
    @Autowired
    private UserMapper userMapper;

    public static class RedisUserKeyGenerator implements KeyGenerator {
        @Override
        public Object generate(Object target, Method method, Object... params) {
            StringBuilder key = new StringBuilder();
            key.append("user:redis:"+((User) params[1]).getId());
            String keyStr= key.toString();
            return keyStr;
        }
    }
    @Bean
    public RedisUserKeyGenerator redisUserKeyGenerator() {
        return new RedisUserKeyGenerator();
    }

    @Caching(
        put = {
            @CachePut(
                value = "RedisUser#60",
                keyGenerator = "redisUserKeyGenerator"
            )
        },
        evict = {
            @CacheEvict(
                value = "GuavaUser",
                allEntries = true
            )
        }
    )
    public UserBean save(byte operType, User user){
        log.info("save begin ...");
        if (1 == operType){
            userMapper.insert(user);
        } else {
            userMapper.updateByPrimaryKeySelective(user);
        }
        log.info("save end ...");
        UserBean userBean = new UserBean();
        BeanUtils.copyProperties(user,userBean);
        return userBean;
    }

    @Cacheable(value = "RedisUser", key = "#id.toString()")
    public UserBean findByPk(Integer id){
        log.info("find begin ...");
        User userRsp = userMapper.selectByPrimaryKey(id);
        UserBean userBean = new UserBean();
        BeanUtils.copyProperties(userRsp,userBean);
        return userBean;
    }

    @CacheEvict(value = "RedisUser", key = "#id.toString()")
    public void delete(Integer id){
        log.info("delete begin ...");
        userMapper.deleteByPrimaryKey(id);
    }
}
