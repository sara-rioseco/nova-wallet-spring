package com.bootcamp.novawalletspring.rest;

import com.bootcamp.novawalletspring.entity.Account;
import com.bootcamp.novawalletspring.entity.Transaction;
import com.bootcamp.novawalletspring.service.AccountService;
import com.bootcamp.novawalletspring.service.TransactionService;
import org.springframework.web.bind.annotation.*;

/**
 * The type Account rest controller.
 */
@RestController
@RequestMapping("api/account")
public class AccountController {

    private final AccountService accountService;
    private final TransactionService transactionService;

    /**
     * Instantiates a new Account controller.
     *
     * @param accountService     the account service
     * @param transactionService the transaction service
     */
    public AccountController(AccountService accountService, TransactionService transactionService) {
        this.accountService = accountService;
        this.transactionService = transactionService;
    }

    /**
     * Gets accounts.
     *
     * @return the accounts
     */
    @GetMapping
    public Iterable<Account> getAccounts() {
        return accountService.getAllAccounts();
    }

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
    @GetMapping("/{id}")
    public Account getById(@PathVariable int id) {
        return accountService.getAccountById(id);
    }

    /**
     * Gets by owner id.
     *
     * @param id the id
     * @return the by owner id
     */
    @GetMapping("/owner/{id}")
    public Account getByOwnerId(@PathVariable int id) {
        return accountService.getAccountByOwnerId(id);
    }

    /**
     * Create account.
     *
     * @param account the account
     * @return the account
     */
    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }

    /**
     * Update account balance.
     *
     * @param id          the id
     * @param transaction the transaction
     * @return the account
     */
    @PatchMapping("/{id}")
    public Account updateBalance(@PathVariable int id, @RequestBody Transaction transaction) {
        Account updatedAccount = accountService.updateBalance(transaction, accountService.getAccountById(id));
        if (updatedAccount != null) {
            transactionService.createTransaction(transaction);
        }
        return updatedAccount;
    }

    /**
     * Delete account.
     *
     * @param id the id
     * @return the boolean
     */
    @DeleteMapping("/{id}")
    public boolean deleteAccount(@PathVariable int id) {
        return accountService.deleteAccount(id);
    }
}
