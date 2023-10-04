package com.example.kafkademo.config;

import com.example.kafkademo.constant.KafkaTopics;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic stringTopic() {
        return TopicBuilder
                .name(KafkaTopics.STRING_TOPIC)
                .build();
    }

    @Bean
    public NewTopic jsonTopic() {
        return TopicBuilder
                .name(KafkaTopics.JSON_TOPIC)
                .build();
    }

}
