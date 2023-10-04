package com.example.kafkademo.service;

import com.example.kafkademo.dto.UserDTO;

public interface KafkaProducerService {

    void sendMessage(String message);
    void sendMessage(UserDTO userDTO);

}
