package com.example.kafkademo.serviceImpl;

import com.example.kafkademo.dto.UserDTO;
import com.example.kafkademo.service.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaProducerServiceImpl implements KafkaProducerService {

    @Value("${spring.kafka.topicName.string}")
    private String stringTopic;

    @Value("${spring.kafka.topicName.json}")
    private String jsonTopic;

    private final KafkaTemplate<String, String> kafkaStringTemplate;
    private final KafkaTemplate<String, UserDTO> kafkaJsonTemplate;

    @Override
    public void sendMessage(String message) {
        kafkaStringTemplate.send(stringTopic, message);
        log.info("[SENT] string message: \"%s\".".formatted(message));
    }

    @Override
    public void sendMessage(UserDTO userDTO) {
        Message<UserDTO> message = MessageBuilder
                .withPayload(userDTO)
                .setHeader(KafkaHeaders.TOPIC, jsonTopic)
                .build();

        kafkaJsonTemplate.send(message);
        log.info("[SENT] json message: \"%s\".".formatted(userDTO));
    }

}
