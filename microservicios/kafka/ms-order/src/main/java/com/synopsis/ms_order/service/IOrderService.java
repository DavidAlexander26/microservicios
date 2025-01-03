package com.synopsis.ms_order.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.synopsis.ms_order.bean.RequestBean;

public interface IOrderService {

    Object createOrder (RequestBean order) throws JsonProcessingException;
}
