package com.bootcamp.novawalletspring.service;

import com.bootcamp.novawalletspring.entity.Account;
import com.bootcamp.novawalletspring.entity.Transaction;

public interface AccountService {
    Account createAccount(Account account);
    Account getAccountById(int id);
    Account getAccountByOwnerId(int id);
    Iterable<Account> getAllAccounts();
    Account updateBalance(Transaction transaction, Account account);
    boolean deleteAccount(int id);
}
