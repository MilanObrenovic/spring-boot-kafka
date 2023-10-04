package com.example.kafkademo.controller;

import com.example.kafkademo.dto.UserDTO;
import com.example.kafkademo.service.KafkaProducerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/v1/kafka")
public class KafkaController {

    private final KafkaProducerService kafkaProducerService;

    @GetMapping("/publish")
    public ResponseEntity<String> publish(
            @RequestParam("message") String message
    ) {
        kafkaProducerService.sendMessage(message);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("STRING message sent to Kafka topic.");
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(
            @RequestBody UserDTO userDTO
    ) {
        kafkaProducerService.sendMessage(userDTO);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("JSON message sent to Kafka topic.");
    }

}
