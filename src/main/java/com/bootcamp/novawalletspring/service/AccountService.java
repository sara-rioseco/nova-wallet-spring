package com.bootcamp.novawalletspring.service;

import com.bootcamp.novawalletspring.entity.Account;
import com.bootcamp.novawalletspring.entity.Transaction;

/**
 * The interface Account service.
 */
public interface AccountService {
    /**
     * Create account.
     *
     * @param account the account
     * @return the account
     */
    Account createAccount(Account account);

    /**
     * Gets account by id.
     *
     * @param id the id
     * @return the account by id
     */
    Account getAccountById(int id);

    /**
     * Gets account by owner id.
     *
     * @param id the id
     * @return the account by owner id
     */
    Account getAccountByOwnerId(int id);

    /**
     * Gets all accounts.
     *
     * @return the all accounts
     */
    Iterable<Account> getAllAccounts();

    /**
     * Update balance.
     *
     * @param transaction the transaction
     * @param account     the account
     * @return the account
     */
    Account updateBalance(Transaction transaction, Account account);

    /**
     * Delete account.
     *
     * @param id the id
     * @return the boolean
     */
    boolean deleteAccount(int id);
}
