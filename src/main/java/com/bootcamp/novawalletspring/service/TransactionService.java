package com.bootcamp.novawalletspring.service;

import com.bootcamp.novawalletspring.model.Transaction;

import java.util.List;

public interface TransactionService {
    boolean createTransaction(Transaction transaction);
    Transaction getTransactionById(int id);
    List<Transaction> getAllTransactions();
    List<Transaction> getTransactionsByUserId(int ownerId);
}
