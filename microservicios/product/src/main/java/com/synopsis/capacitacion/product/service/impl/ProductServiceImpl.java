package com.synopsis.capacitacion.product.service.impl;

import com.synopsis.capacitacion.product.entity.ProductEntity;
import com.synopsis.capacitacion.product.repository.ProductRepository;
import com.synopsis.capacitacion.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductEntity getById(long id) {
        return productRepository.findById(id).get();
    }
}
