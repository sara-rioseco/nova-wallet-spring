package com.bootcamp.novawalletspring.service;

import com.bootcamp.novawalletspring.entity.Transaction;

/**
 * The interface Transaction service.
 */
public interface TransactionService {
    /**
     * Create transaction.
     *
     * @param transaction the transaction
     * @return the transaction
     */
    Transaction createTransaction(Transaction transaction);

    /**
     * Gets transaction by id.
     *
     * @param id the id
     * @return the transaction by id
     */
    Transaction getTransactionById(int id);

    /**
     * Gets transactions by user id.
     *
     * @param ownerId the owner id
     * @return the transactions by user id
     */
    Iterable<Transaction> getTransactionsByUserId(int ownerId);

    /**
     * Gets all transactions.
     *
     * @return the all transactions
     */
    Iterable<Transaction> getAllTransactions();

    /**
     * Delete transaction.
     *
     * @param id the id
     * @return the boolean
     */
    boolean deleteTransaction(int id);
}
