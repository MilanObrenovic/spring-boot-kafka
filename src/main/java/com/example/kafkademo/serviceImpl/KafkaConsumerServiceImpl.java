package com.example.kafkademo.serviceImpl;

import com.example.kafkademo.service.KafkaConsumerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class KafkaConsumerServiceImpl implements KafkaConsumerService {

    @KafkaListener(topics = "example-topic", groupId = "demoGroup")
    @Override
    public void consume(String message) {
        log.info("Message received: \"%s\".".formatted(message));
    }

}
