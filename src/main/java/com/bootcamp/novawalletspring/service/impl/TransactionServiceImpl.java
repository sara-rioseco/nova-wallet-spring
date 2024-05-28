package com.bootcamp.novawalletspring.service.impl;

import com.bootcamp.novawalletspring.entity.TransactionEntity;
import com.bootcamp.novawalletspring.model.Transaction;
import com.bootcamp.novawalletspring.repository.AccountRepository;
import com.bootcamp.novawalletspring.repository.CurrencyRepository;
import com.bootcamp.novawalletspring.repository.TransactionRepository;
import com.bootcamp.novawalletspring.repository.UserRepository;
import com.bootcamp.novawalletspring.service.TransactionService;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.bootcamp.novawalletspring.model.TransactionType.*;

@Service
@CommonsLog
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    CurrencyRepository currencyRepository;

    @Override
    public boolean createTransaction(Transaction transaction) {
        if (transaction != null
                && transaction.getAmount().compareTo(BigDecimal.ZERO) > 0
                && transaction.getTransactionType() != null
                && (transaction.getTransactionType() == deposit
                    || transaction.getTransactionType() == transfer
                    || transaction.getTransactionType() == withdrawal)
                && currencyRepository.getById(transaction.getCurrencyId()) != null
                && userRepository.getById(transaction.getSenderUserId()) != null
                && accountRepository.getById(transaction.getSenderAccountId()) != null
                && userRepository.getById(transaction.getReceiverUserId()) != null
                && accountRepository.getById(transaction.getReceiverAccountId()) != null) {
            return transactionRepository.save(transaction) > 0;
        } else {
            System.out.println("Error creating transaction");
            return false;
        }
    }

    @Override
    public Transaction getTransactionById(int id) {
        return new Transaction(transactionRepository.getById(id));
    }

    @Override
    public List<Transaction> getAllTransactions() {
        List<TransactionEntity> transactions = transactionRepository.getAll();
        List<Transaction> result = new ArrayList<>();
        for (TransactionEntity transaction : transactions) {
            result.add(new Transaction(transaction));
        }
        return result;
    }

    @Override
    public List<Transaction> getTransactionsByUserId(int userId) {
        List<TransactionEntity> transactions = transactionRepository.getAllByUserId(userId);
        List<Transaction> result = new ArrayList<>();
        for (TransactionEntity transaction : transactions) {
            result.add(new Transaction(transaction));
        }
        return result;
    }
}
