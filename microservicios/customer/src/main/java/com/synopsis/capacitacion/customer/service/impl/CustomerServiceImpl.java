package com.synopsis.capacitacion.customer.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.synopsis.capacitacion.customer.bean.TransactionBean;
import com.synopsis.capacitacion.customer.entities.Customer;
import com.synopsis.capacitacion.customer.entities.CustomerProduct;
import com.synopsis.capacitacion.customer.formatter.FormatterTransaction;
import com.synopsis.capacitacion.customer.respository.CustomerRepository;
import com.synopsis.capacitacion.customer.service.ICustomerService;
import com.synopsis.capacitacion.customer.webclient.IWebClientCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private IWebClientCustomer webClientCustomer;

    @Override
    public Object findById(long id) {
        Optional<Customer> response = customerRepository.findById(id);
        if (response.isPresent()){
            List<CustomerProduct> products = response.get().getProducts();
            products.forEach(
                    product -> {
                    product.setProductName(webClientCustomer.getProductName(product.getId()));
                    }
            );

            response.get().setTransactions(
                    FormatterTransaction.formatter(
                            webClientCustomer.getListTransaction(response.get().getIban())
                    )
            );
            return response.get();
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> customers =  customerRepository.findAll();
        customers.forEach(customer -> {
            List<CustomerProduct> products = customer.getProducts();
            products.forEach(
                    product -> {
                        product.setProductName(webClientCustomer.getProductName(product.getId()));
                    }
            );
            customer.setTransactions(
                    FormatterTransaction.formatter(
                            webClientCustomer.getListTransaction(customer.getIban())
                    )
            );
        });
        return customers;
    }

    @Override
    public Object findByCode(String code) {
        Optional<Customer> response = customerRepository.findCustomerByCode(code);
        if (response.isPresent()){
            List<CustomerProduct> products = response.get().getProducts();
            products.forEach(
                    product -> {
                        product.setProductName(webClientCustomer.getProductName(product.getId()));
                    }
            );
            return response.get();
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @Override
    public Object findByName(String name) {
        Optional<Customer> response = customerRepository.findCustomerByName(name);
        if (response.isPresent()){
            List<CustomerProduct> products = response.get().getProducts();
            products.forEach(
                    product -> {
                        product.setProductName(webClientCustomer.getProductName(product.getId()));
                    }
            );
            return response.get();
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @Override
    public Object findByAccountNumber(String accountNumber) {
        Optional<Customer> response = customerRepository.findCustomerByIban(accountNumber);
        if (response.isPresent()){
            List<CustomerProduct> products = response.get().getProducts();
            products.forEach(
                    product -> {
                        product.setProductName(webClientCustomer.getProductName(product.getId()));
                    }
            );
            return response.get();
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @Override
    public Object createCustomer(Customer customer) {
        customer.getProducts().forEach(x -> x.setCustomer(customer));
        Customer save = customerRepository.save(customer);
        return ResponseEntity.ok(save);
    }

    @Override
    public Object updateCustomer(long id, Customer customer) {
        Optional<Customer> response = customerRepository.findById(id);
        if(response.isPresent()){
            response.get().setCode(customer.getCode());
            response.get().setName(customer.getName());
            customerRepository.save(response.get());
        }
        return findById(id);
    }

    @Override
    public Object updateProducts(long id, List<CustomerProduct> products) {
        Optional<Customer> response = customerRepository.findById(id);
        if(response.isPresent()){
            response.get().setProducts(products);
            customerRepository.save(response.get());
        }
        return findById(id);
    }

    @Override
    public Object deleteById(long id) {
        Optional<Customer> findById = customerRepository.findById(id);
        if(findById.isPresent()){
            customerRepository.delete(findById.get());
        }
        return ResponseEntity.ok().build();
    }

    @Override
    public Object deleteAll() {
        return null;
    }
}
