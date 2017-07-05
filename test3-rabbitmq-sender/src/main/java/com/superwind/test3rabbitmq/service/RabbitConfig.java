package com.superwind.test3rabbitmq.service;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by jiangxj on 2017/7/4.
 */
@Configuration
public class RabbitConfig {
    @Bean
    public Queue oneQueue() {
        return new Queue("one");
    }
}
