package com.synopsis.capacitacion.transactions.repository;

import com.synopsis.capacitacion.transactions.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {

    @Query(value = "SELECT t FROM Transaction t WHERE t.accountNumber = :accountNumber")
    List<Transaction> findTransactionByAccountNumber(String accountNumber);
}
