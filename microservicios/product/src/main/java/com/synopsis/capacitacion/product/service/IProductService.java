package com.synopsis.capacitacion.product.service;

import com.synopsis.capacitacion.product.entity.ProductEntity;

import java.util.List;

public interface IProductService {

    //GET
    Object findById(long id);

    List<ProductEntity> findAll();

    Object findByCode(String code);

    Object findByName(String name);

    //POST
    Object createProduct (ProductEntity product);

    //UPDATE
    Object updateProduct (long id, ProductEntity product);

    //DELETE
    Object deleteById (long id);

    Object deleteAll ();
}
