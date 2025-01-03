package com.synopsis.consumer_kafka.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "my-topic", groupId = "my-group")
    public void listen(ConsumerRecord<String, String> record) {
        System.out.println("Mensaje recibido: " + record.value());
    }

    @KafkaListener(topics = "my-topic2", groupId = "my-group")
    public void listen2(ConsumerRecord<String, String> record) {
        System.out.println("Mensaje recibido: " + record.value());
    }
}
