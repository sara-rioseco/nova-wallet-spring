package com.bootcamp.novawalletspring.service;

import com.bootcamp.novawalletspring.entity.Account;
import com.bootcamp.novawalletspring.entity.Transaction;
import com.bootcamp.novawalletspring.entity.User;
import com.bootcamp.novawalletspring.model.TransactionType;

import java.math.BigDecimal;

public interface AccountService {
    Account createAccount(Account account);
    Account getAccountById(int id);
    Account updateBalance(Transaction transaction, Account account);
    boolean deleteAccount(int id);
    Account getAccountByOwnerId(int id);
    Iterable<Account> getAllAccounts();
}
