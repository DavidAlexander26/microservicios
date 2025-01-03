package com.synopsis.ms_order.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class KafkaProducerService {

    @Autowired
    private Environment env;

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final AtomicInteger partitionCounter = new AtomicInteger(0);

    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {

        // Número total de particiones (puedes obtenerlo dinámicamente si lo necesitas)
       // int totalPartitions = 2; // Cambia esto según las particiones de tu tópico

        int totalPartitions = kafkaTemplate.partitionsFor(env.getProperty("kafka.topic.order")).size();

        System.out.println("TOTAL PARTICIONES "+ totalPartitions);

        // Calcular la partición a usar (rotación entre particiones)
        int partition = partitionCounter.getAndIncrement() % totalPartitions;

        // Enviar el mensaje a la partición específica
        kafkaTemplate.send(env.getProperty("kafka.topic.order"), 0, null, message);
        kafkaTemplate.send(env.getProperty("kafka.topic.order"), 1, null, message);
    }
}

