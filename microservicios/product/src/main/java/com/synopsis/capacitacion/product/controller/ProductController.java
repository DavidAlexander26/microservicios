package com.synopsis.capacitacion.product.controller;

import com.synopsis.capacitacion.product.entity.ProductEntity;
import com.synopsis.capacitacion.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @GetMapping()
    public Object getAll() {
        return iProductService.findAll();
    }

    @GetMapping("/{id}")
    public Object getById(@PathVariable(name = "id") Long id) {
        return iProductService.findById(id);
    }

    @GetMapping("/code/{code}")
    public Object getByCode(@PathVariable(name = "code") String code) {
        return iProductService.findByCode(code);
    }
    @GetMapping("/name/{name}")
    public Object getByName(@PathVariable(name = "name") String name) {
        return iProductService.findByName(name);
    }

    @PostMapping("/create")
    public Object post(@RequestBody ProductEntity product) {
        return iProductService.createProduct(product);
    }

    @PutMapping("/update/{id}")
    public Object put(@PathVariable(name = "id") Long id, @RequestBody ProductEntity product) {
        return iProductService.updateProduct(id, product);
    }

    @DeleteMapping("")
    public Object deleteAll() {
        return iProductService.deleteAll();
    }
    @DeleteMapping("/{id}")
    public Object deleteById(@PathVariable Long id) {
      return iProductService.deleteById(id);
    }
}
