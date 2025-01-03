package com.synopsis.ms_payment.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;

@Service
public class KafkaConsumerService {

    @Autowired
    private Environment env;

    //private final String topic = Optional.ofNullable(env.getProperty("kafka.topic.order")).orElse("default_order_topic");
    @KafkaListener(topics = "topic-order", groupId = "my-group")
    public void listen(ConsumerRecord<String, String> record) {
        //System.out.println("Mensaje recibido: " + record.value());


        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode rootNode = objectMapper.readTree(record.value());

            String numberOrder = rootNode.path("numberOrder").asText();
            String codClient = rootNode.path("codClient").asText();

            BigDecimal totalPago = BigDecimal.ZERO;
            for (JsonNode jsonOrders : rootNode.path("order")) {
                totalPago = totalPago.add(new BigDecimal(jsonOrders.path("total").asText()));
            }


            System.out.println("Numero Orden: " + numberOrder);
            System.out.println("Cliente: " + codClient);
            System.out.println("Total Pago: " + totalPago);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
