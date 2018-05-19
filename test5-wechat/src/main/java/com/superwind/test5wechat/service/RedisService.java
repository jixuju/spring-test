package com.superwind.test5wechat.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class RedisService {
    @Autowired
    private RedisTemplate redisTemplate;

    /** key定义说明：业务标识+唯一标识符*/
    /** 用户token前缀 */
    public static final String WECHAT_TOKEN_KEY_PREFIX = "WECHAT_INFRA_TOKEN_";
    /**
     * 批量删除对应的value
     *
     * @param keys
     */
    public void remove(final String... keys) {
        for (String key : keys) {
            remove(key);
        }
    }

    /**
     * 删除对应的value
     *
     * @param key
     */
    public void remove(final String key) {
        if (exists(key)) {
            redisTemplate.delete(key);
        }
    }

    /**
     * 判断缓存中是否有对应的value
     *
     * @param key
     * @return
     */
    public Boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 读取缓存
     *
     * @param key
     * @return
     */
    public Object get(final String key) {
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        return operations.get(key);
    }

    public<T> T get(final String key, Class<T> clazz) {
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        return clazz.cast(operations.get(key));
    }

    /**
     * 写入缓存
     *
     * @param key
     * @param value
     * @return
     */
    public Boolean set(final String key, Object value) {
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            return true;
        } catch (Exception e) {
            log.info("", e);
        }
        return false;
    }

    /**
     * 写入缓存
     * @param key
     * @param value
     * @param expireTime 单位：秒
     * @return
     */
    public Boolean set(final String key, Object value, Long expireTime) {
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            return true;
        } catch (Exception e) {
            log.info("", e);
        }
        return false;
    }

    public Object getAndSet(final String key, Object value) {
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            return operations.getAndSet(key, value);
        } catch (Exception e) {
            log.info("", e);
        }
        return null;
    }

    public Object getAndSet(final String key, Object value, Long expireTime) {
        try {
            Object oldValue = null;
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            oldValue = operations.getAndSet(key, value);
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            return oldValue;
        } catch (Exception e) {
            log.info("", e);
        }
        return null;
    }

    public Boolean setIfAbsent(final String key, Object value) {
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            return operations.setIfAbsent(key, value);
        } catch (Exception e) {
            log.info("", e);
        }
        return false;
    }

    public Boolean addSort(String sortKey, Object obj, Integer score){
        try {
            ZSetOperations zSetOperations = redisTemplate.opsForZSet();
            return zSetOperations.add(sortKey, obj, score);
        } catch (Exception e) {
            log.info("", e);
        }
        return false;
    }

    public Set getReverseRangeSort(String sortKey, Integer start, Integer end) {
        try {
            ZSetOperations zSetOperations = redisTemplate.opsForZSet();
            return zSetOperations.reverseRange(sortKey, start, end);
        } catch (Exception e) {
            log.info("", e);
        }
        return Collections.emptySet();
    }

    /**
     *  根据pattern查询相关key
     * @param pattern
     * @return
     */
    public Set<String> keys(String pattern) {
        return redisTemplate.keys(pattern);
    }

    /**
     * 获取TTL
     */
    public Long getExpire(final String key) {
        return redisTemplate.getExpire(key);
    }

    /**
     * 设置TTL
     */
    public Boolean setExpire(final String key, Long expireTime) {
        return redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
    }
    /**
     * 获取微信token的Redis Key
     *
     * @param source
     * @return
     */
    public static String getWechatInfraTokenKeyPrefix(String source) {
        return WECHAT_TOKEN_KEY_PREFIX + source;
    }
}
