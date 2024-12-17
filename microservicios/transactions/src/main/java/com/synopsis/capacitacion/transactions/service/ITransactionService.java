package com.synopsis.capacitacion.transactions.service;

import com.synopsis.capacitacion.transactions.entity.Transaction;

import java.util.List;

public interface ITransactionService {
    //GET
    Object findById(long id);
    List<Transaction> findAll();
    Object findByAccountNumber(String accountNumber);

    //POST
    Object createProduct (Transaction transaction);

    //UPDATE
    Object updateProduct (long id, Transaction transaction);

    //DELETE
    Object deleteById (long id);

    Object deleteAll ();
}
