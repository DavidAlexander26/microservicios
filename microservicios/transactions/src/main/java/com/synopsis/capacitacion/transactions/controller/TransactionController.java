package com.synopsis.capacitacion.transactions.controller;

import com.synopsis.capacitacion.transactions.entity.Transaction;
import com.synopsis.capacitacion.transactions.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private ITransactionService iTransactionService;

    @GetMapping()
    public Object getAll() {
        return iTransactionService.findAll();
    }

    @GetMapping("/{id}")
    public Object getById(@PathVariable(name = "id") Long id) {
        return iTransactionService.findById(id);
    }

    @GetMapping("/accountNumber/{accountNumber}")
    public Object getByAccountNumber(@PathVariable(name = "accountNumber") String accountNumber) {
        return iTransactionService.findByAccountNumber(accountNumber);
    }

    @PostMapping()
    public Object post(@RequestBody Transaction transaction) {
        return iTransactionService.createProduct(transaction);
    }
}
