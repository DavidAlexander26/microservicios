package com.synopsis.capacitacion.product.service;

import com.synopsis.capacitacion.product.entity.ProductEntity;

public interface IProductService {
    ProductEntity getById(long id);
}
