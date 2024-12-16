package com.synopsis.capacitacion.product.service;

import com.synopsis.capacitacion.product.entity.ProductEntity;

public interface IProductService {
    ProductEntity getById(long id);

    ProductEntity getByCode1(String code);

    ProductEntity getByCode2(String code);
}
