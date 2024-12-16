package com.synopsis.capacitacion.product.controller;

import com.synopsis.capacitacion.product.entity.ProductEntity;
import com.synopsis.capacitacion.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @GetMapping("/{id}")
    public ProductEntity get(@PathVariable(name = "id") long id) {
        return iProductService.getById(id);
    }

}