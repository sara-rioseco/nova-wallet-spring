package com.bootcamp.novawalletspring.service.impl;

import com.bootcamp.novawalletspring.entity.Transaction;
import com.bootcamp.novawalletspring.repository.TransactionRepository;
import com.bootcamp.novawalletspring.service.TransactionService;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

/**
 * The type Transaction service.
 */
@Service
@CommonsLog
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    /**
     * Instantiates a new Transaction service.
     *
     * @param transactionRepository the transaction repository
     */
    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Transaction createTransaction(Transaction transaction) {
        try {
            return transactionRepository.save(transaction);
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public Transaction getTransactionById(int id) {
        try {
            Optional<Transaction> tr = transactionRepository.findById(id);
            if (tr.isPresent()) {
                return tr.get();
            }
            else {
                throw new Exception("Error getting account");
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public Iterable<Transaction> getAllTransactions() {
        try {
            Iterable<Transaction> transactions = transactionRepository.findAll();
            if (transactions.iterator().hasNext()) {
                return transactions;
            }
            else {
                throw new Exception("Error getting transactions");
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean deleteTransaction(int id) {
        try {
            transactionRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
    }

    @Override
    public Iterable<Transaction> getTransactionsByUserId(int userId) {
        try {
            Iterable<Transaction> transactions = transactionRepository.findAllByUserId(userId);
            if (transactions.iterator().hasNext()) {
                return transactions;
            }
            else {
                return new ArrayList<>();
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ArrayList<>();
        }
    }

}
