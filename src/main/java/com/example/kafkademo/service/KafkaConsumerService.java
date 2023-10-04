package com.example.kafkademo.service;

import com.example.kafkademo.dto.UserDTO;

public interface KafkaConsumerService {

    void consume(String message);
    void consume(UserDTO userDTO);

}
