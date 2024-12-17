package com.synopsis.capacitacion.customer.formatter;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.synopsis.capacitacion.customer.bean.TransactionBean;

import java.util.List;

public class FormatterTransaction {
    public static List<TransactionBean> formatter(JsonNode transactions){
        ObjectMapper objectMapper = new ObjectMapper();
        List<TransactionBean> transactionList = null;
        try {
            transactionList = objectMapper.convertValue(transactions,
                    objectMapper.getTypeFactory().constructCollectionType(List.class, TransactionBean.class)
            );
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        return transactionList;
    }
}
