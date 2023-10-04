package com.example.kafkademo.controller;

import com.example.kafkademo.service.KafkaProducerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/v1/messages")
public class MessageController {

    private final KafkaProducerService kafkaProducerService;

    @GetMapping("/publish")
    public ResponseEntity<String> publish(
            @RequestParam("message") String message
    ) {
        kafkaProducerService.sendMessage(message);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Message sent to the topic.");
    }

}
