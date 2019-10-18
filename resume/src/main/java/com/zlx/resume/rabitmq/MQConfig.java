package com.zlx.resume.rabitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQConfig {
    public static final String MESSAGE_QUEUE = "message";
    public static final String TOPIC_EXCHANGE="topicExchange";

    @Bean
    public Queue topicQueue(){
        return new Queue(MESSAGE_QUEUE,true);
    }

    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange(TOPIC_EXCHANGE);
    }
    //绑定
    @Bean
    public Binding topicBinding1() {
        return BindingBuilder.bind(topicQueue()).to(topicExchange()).with("topic.key1");
    }


}
