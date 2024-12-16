package com.synopsis.capacitacion.product.service.impl;

import com.synopsis.capacitacion.product.entity.ProductEntity;
import com.synopsis.capacitacion.product.repository.ProductRepository;
import com.synopsis.capacitacion.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductEntity getById(long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public ProductEntity getByCode1(String code) {
        Optional<ProductEntity> response = productRepository.findByCode(code);
        return (response.isPresent())? response.get() : null;
    }

    @Override
    public ProductEntity getByCode2(String code) {
        Optional<ProductEntity> response =  productRepository.findProductByCode(code);
        return response.get();
    }
}
