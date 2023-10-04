package com.example.kafkademo.serviceImpl;

import com.example.kafkademo.constant.KafkaTopics;
import com.example.kafkademo.dto.UserDTO;
import com.example.kafkademo.service.KafkaProducerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class KafkaProducerServiceImpl implements KafkaProducerService {

    private final KafkaTemplate<String, String> kafkaStringTemplate;
    private final KafkaTemplate<String, UserDTO> kafkaJsonTemplate;

    @Override
    public void sendMessage(String message) {
        kafkaStringTemplate.send(KafkaTopics.STRING_TOPIC, message);
        log.info("[SENT] string message: \"%s\".".formatted(message));
    }

    @Override
    public void sendMessage(UserDTO userDTO) {
        Message<UserDTO> message = MessageBuilder
                .withPayload(userDTO)
                .setHeader(KafkaHeaders.TOPIC, KafkaTopics.JSON_TOPIC)
                .build();

        kafkaJsonTemplate.send(message);
        log.info("[SENT] json message: \"%s\".".formatted(userDTO));
    }

}
