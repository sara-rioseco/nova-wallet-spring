package com.bootcamp.novawalletspring.repository;

import com.bootcamp.novawalletspring.model.Transaction;

import java.util.List;

public interface TransactionRepository {
    boolean createTransaction(Transaction transaction);
    Transaction getTransactionById(int id);
    List<Transaction> getAllTransactions();
    List<Transaction> getTransactionsByUserId(int ownerId);
}
