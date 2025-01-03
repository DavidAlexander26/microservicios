package com.synopsis.producer_kafka.controller;

import com.synopsis.producer_kafka.service.KafkaProducerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/messages")
public class MessageController {
    private final KafkaProducerService kafkaProducerService;

    public MessageController(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    @PostMapping("/{topic}")
    public String sendMessage(@PathVariable String topic, @RequestBody String message) {
        kafkaProducerService.sendMessage(topic, message);
        return "Mensaje enviado al topic: " + topic;
    }
}
