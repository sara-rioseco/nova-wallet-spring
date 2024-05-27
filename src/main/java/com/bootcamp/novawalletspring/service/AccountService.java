package com.bootcamp.novawalletspring.service;

import com.bootcamp.novawalletspring.model.Account;
import com.bootcamp.novawalletspring.model.TransactionType;

import java.math.BigDecimal;
import java.util.List;

public interface AccountService {
    boolean createAccount(Account account);
    Account getAccountById(int id);
    boolean updateBalance(int id, BigDecimal amount, TransactionType type, boolean ownerUser);
    boolean deleteAccount(int id);
    List<Account> getAccountsByOwnerId(int id);
    List<Account> getAllAccounts();
}
