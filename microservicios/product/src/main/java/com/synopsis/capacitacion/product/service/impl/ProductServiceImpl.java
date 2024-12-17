package com.synopsis.capacitacion.product.service.impl;

import com.synopsis.capacitacion.product.entity.ProductEntity;
import com.synopsis.capacitacion.product.repository.ProductRepository;
import com.synopsis.capacitacion.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Object findById(long id) {
        Optional<?> response = productRepository.findById(id);
        return (response.isPresent()) ? response.get() : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @Override
    public List<ProductEntity> findAll() {
       List<ProductEntity> response = productRepository.findAll();
       return response;
    }

    @Override
    public Object findByCode(String code) {
        Optional<?> response = productRepository.findProductByCode(code);
        return (response.isPresent()) ? response.get() : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @Override
    public Object findByName(String name) {
        Optional<?> response = productRepository.findProductByName(name);
        return (response.isPresent()) ? response.get() : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @Override
    public Object createProduct(ProductEntity product) {
        ProductEntity productEntity = productRepository.save(product);
        return productEntity;
    }

    @Override
    public Object updateProduct(long id, ProductEntity newProduct) {
        Optional<ProductEntity> response = productRepository.findById(id);
        if(response.isPresent()){
            response.get().setCode(newProduct.getCode());
            response.get().setName(newProduct.getName());
            productRepository.save(response.get());
        }
        return findById(id);
    }

    @Override
    public Object deleteById(long id) {
        productRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Override
    public Object deleteAll() {
        productRepository.deleteAll();
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
