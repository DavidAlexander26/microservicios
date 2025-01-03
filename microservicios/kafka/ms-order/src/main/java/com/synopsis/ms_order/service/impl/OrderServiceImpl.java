package com.synopsis.ms_order.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.synopsis.ms_order.bean.Order;
import com.synopsis.ms_order.bean.RequestBean;
import com.synopsis.ms_order.kafka.KafkaProducerService;
import com.synopsis.ms_order.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OrderServiceImpl implements IOrderService {


    @Autowired
    KafkaProducerService kafkaProducerService;

    @Override
    public Object createOrder(RequestBean order) throws JsonProcessingException {

        for (Order item: order.getOrder()) {
            item.setTotal(item.getQuantityProduct().multiply(item.getPriceProduct()));
        }

        // Crear un ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();

        // Opcional: Formatear el JSON para que sea más legible
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        // Convertir el objeto a String JSON
        String jsonString = objectMapper.writeValueAsString(order);

        kafkaProducerService.sendMessage(jsonString);

        return "Mensaje enviado al topico: ";
    }
}
