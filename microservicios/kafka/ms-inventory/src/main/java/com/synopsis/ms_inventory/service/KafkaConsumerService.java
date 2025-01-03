package com.synopsis.ms_inventory.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.synopsis.ms_inventory.bean.Inventory;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "topic-order", groupId = "my-group")
    public void listen(ConsumerRecord<String, String> record) {

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode rootNode = objectMapper.readTree(record.value());

            List<Inventory> inventoryList = new ArrayList<>();

            for (JsonNode jsonOrders : rootNode.path("order")) {
                Inventory item = new Inventory(
                        jsonOrders.path("codProduct").asText(),
                        jsonOrders.path("nameProduct").asText(),
                        new BigDecimal(jsonOrders.path("quantityProduct").asText())
                );
                inventoryList.add(item);
            }

            for (Inventory item: inventoryList) {
                System.out.println(item);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
