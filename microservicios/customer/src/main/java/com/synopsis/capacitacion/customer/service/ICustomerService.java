package com.synopsis.capacitacion.customer.service;

import com.synopsis.capacitacion.customer.entities.Customer;
import com.synopsis.capacitacion.customer.entities.CustomerProduct;

import java.util.List;

public interface ICustomerService {

    //GET
    Object findById(long id);

    List<Customer> findAll();

    Object findByCode(String code);

    Object findByName(String name);

    Object findByAccountNumber(String accountNumber);

    //POST
    Object createCustomer (Customer customer);

    //UPDATE
    Object updateCustomer (long id, Customer customer);

    Object updateProducts (long id, List<CustomerProduct> products);

    //DELETE
    Object deleteById (long id);

    Object deleteAll ();
}
