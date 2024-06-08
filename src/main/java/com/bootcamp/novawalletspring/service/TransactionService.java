package com.bootcamp.novawalletspring.service;

import com.bootcamp.novawalletspring.entity.Transaction;

public interface TransactionService {
    Transaction createTransaction(Transaction transaction);
    Transaction getTransactionById(int id);
    Iterable<Transaction> getTransactionsByUserId(int ownerId);
    Iterable<Transaction> getAllTransactions();
    boolean deleteTransaction(int id);
}
