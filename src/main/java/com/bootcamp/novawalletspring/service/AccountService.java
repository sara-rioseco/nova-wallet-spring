package com.bootcamp.novawalletspring.service;

import com.bootcamp.novawalletspring.entity.Account;
import com.bootcamp.novawalletspring.model.TransactionType;

import java.math.BigDecimal;

public interface AccountService {
    Account createAccount(Account account);
    Account getAccountById(int id);
    // boolean updateBalance(int id, BigDecimal amount, TransactionType type, boolean ownerUser);
    boolean deleteAccount(int id);
    // Account getAccountByOwnerId(int id);
    Iterable<Account> getAllAccounts();
}
