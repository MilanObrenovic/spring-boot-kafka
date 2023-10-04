package com.example.kafkademo.serviceImpl;

import com.example.kafkademo.constant.KafkaTopics;
import com.example.kafkademo.dto.UserDTO;
import com.example.kafkademo.service.KafkaConsumerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class KafkaConsumerServiceImpl implements KafkaConsumerService {

    @KafkaListener(topics = KafkaTopics.STRING_TOPIC, groupId = KafkaTopics.DEMO_GROUP)
    @Override
    public void consume(String message) {
        log.info("[RECEIVED] string message: \"%s\".".formatted(message));
    }

    @KafkaListener(topics = KafkaTopics.JSON_TOPIC, groupId = KafkaTopics.DEMO_GROUP)
    @Override
    public void consume(UserDTO userDTO) {
        log.info("[RECEIVED] json message: \"%s\".".formatted(userDTO));
    }

}
