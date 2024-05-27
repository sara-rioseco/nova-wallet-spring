package com.bootcamp.novawalletspring.service.impl;

import com.bootcamp.novawalletspring.repository.AccountRepository;
import com.bootcamp.novawalletspring.repository.CurrencyRepository;
import com.bootcamp.novawalletspring.repository.TransactionRepository;
import com.bootcamp.novawalletspring.repository.UserRepository;
import com.bootcamp.novawalletspring.repository.impl.AccountRepositoryImpl;
import com.bootcamp.novawalletspring.repository.impl.CurrencyRepositoryImpl;
import com.bootcamp.novawalletspring.repository.impl.UserRepositoryImpl;
import com.bootcamp.novawalletspring.model.Transaction;
import com.bootcamp.novawalletspring.service.TransactionService;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.util.List;

import static com.bootcamp.novawalletspring.model.TransactionType.*;

@Service
@CommonsLog
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public boolean createTransaction(Transaction transaction) {
        UserRepository userRepository = new UserRepositoryImpl();
        AccountRepository accountRepository = new AccountRepositoryImpl();
        CurrencyRepository currencyRepository = new CurrencyRepositoryImpl();
        if (transaction != null
                && transaction.getAmount().compareTo(BigDecimal.ZERO) > 0
                && transaction.getTransactionType() != null
                && (transaction.getTransactionType() == deposit
                    || transaction.getTransactionType() == transfer
                    || transaction.getTransactionType() == withdrawal)
                && currencyRepository.getCurrencyById(transaction.getCurrencyId()) != null
                && userRepository.getUserById(transaction.getSenderUserId()) != null
                && accountRepository.getAccountById(transaction.getSenderAccountId()) != null
                && userRepository.getUserById(transaction.getReceiverUserId()) != null
                && accountRepository.getAccountById(transaction.getReceiverAccountId()) != null) {
            return transactionRepository.addTransaction(transaction);
        } else {
            System.out.println("Error creating transaction");
            return false;
        }
    }

    @Override
    public Transaction getTransactionById(int id) {
        return transactionRepository.getTransactionById(id);
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepository.getAllTransactions();
    }

    @Override
    public List<Transaction> getTransactionsByUserId(int userId) {
        return transactionRepository.getTransactionsByUserId(userId);
    }
}
