package com.superwind.test3rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by jiangxj on 2017/9/3.
 */
@Configuration
public class TopicRabbitConfig {
    final static String messageA = "topic.A";
    final static String messageB = "topic.B";

    @Bean
    public Queue queueA() {
        return new Queue(TopicRabbitConfig.messageA);
    }

    @Bean
    public Queue queueB() {
        return new Queue(TopicRabbitConfig.messageB);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange("topicExchange");
    }

    @Bean
    Binding bindingExchangeQeueuA(Queue queueA, TopicExchange exchange) {
        return BindingBuilder.bind(queueA).to(exchange).with("topic.A"); //只有路由key=topic.A的才到A队列
    }

    @Bean
    Binding bindingExchangeQeueuB(Queue queueB, TopicExchange exchange) {
        return BindingBuilder.bind(queueB).to(exchange).with("topic.#"); //topic开头的路由key都可以到B队列
    }
}
