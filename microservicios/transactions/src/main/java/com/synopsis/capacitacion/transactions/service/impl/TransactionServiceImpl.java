package com.synopsis.capacitacion.transactions.service.impl;

import com.synopsis.capacitacion.transactions.entity.Transaction;
import com.synopsis.capacitacion.transactions.repository.TransactionRepository;
import com.synopsis.capacitacion.transactions.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements ITransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Override
    public Object findById(long id) {
        Optional<?> response = transactionRepository.findById(id);
        return (response.isPresent()) ? response.get() : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @Override
    public List<Transaction> findAll() {
        List<Transaction> response = transactionRepository.findAll();
        return response;
    }

    @Override
    public Object findByAccountNumber(String accountNumber) {
        List<Transaction> response = transactionRepository.findTransactionByAccountNumber(accountNumber);
        return response;
    }

    @Override
    public Object createProduct(Transaction transaction) {
        Transaction productEntity = transactionRepository.save(transaction);
        return productEntity;
    }

    @Override
    public Object updateProduct(long id, Transaction transaction) {
        Optional<Transaction> response = transactionRepository.findById(id);
        if(response.isPresent()){
            response.get().setAccountNumber(transaction.getAccountNumber());
            response.get().setAmount(transaction.getAmount());
            response.get().setChannel(transaction.getChannel());
            response.get().setDescription(transaction.getDescription());
            transactionRepository.save(response.get());
        }
        return findById(id);
    }

    @Override
    public Object deleteById(long id) {
        transactionRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Override
    public Object deleteAll() {
        transactionRepository.deleteAll();
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
