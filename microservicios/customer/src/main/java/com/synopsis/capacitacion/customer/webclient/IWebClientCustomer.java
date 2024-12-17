package com.synopsis.capacitacion.customer.webclient;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;

public interface IWebClientCustomer {
    public String getProductName (long id);
    public JsonNode getListTransaction (String accountNumber);
}
