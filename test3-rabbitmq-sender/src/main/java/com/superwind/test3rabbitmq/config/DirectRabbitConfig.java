package com.superwind.test3rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by jiangxj on 2017/7/4.
 */
@Configuration
public class DirectRabbitConfig {
    @Bean
    public Queue oneQueue() {
        return new Queue("direct");
    }
}
