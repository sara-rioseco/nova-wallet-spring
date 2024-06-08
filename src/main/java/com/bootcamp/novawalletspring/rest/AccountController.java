package com.bootcamp.novawalletspring.rest;

import com.bootcamp.novawalletspring.entity.Account;
import com.bootcamp.novawalletspring.entity.Transaction;
import com.bootcamp.novawalletspring.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

//    @Autowired TODO
//    private TrasactionService trasactionService;

    @GetMapping
    public Iterable<Account> getEmployees() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/{id}")
    public Account getById(@PathVariable int id) {
        return accountService.getAccountById(id);
    }

    @GetMapping("/owner/{id}")
    public Account getByOwnerId(@PathVariable int id) {
        return accountService.getAccountByOwnerId(id);
    }

    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }

    @PatchMapping("/{id}")
    public Account updateBalance(@PathVariable int id, @RequestBody Transaction transaction) {
        Account updatedAccount = accountService.updateBalance(transaction, accountService.getAccountById(id));
//        if (updatedAccount != null) { TODO
//            Transaction transaction = transactionService.save(transaction);
//        }
        return updatedAccount;
    }

    @DeleteMapping("/{id}")
    public boolean deleteAccount(@PathVariable int id) {
        return accountService.deleteAccount(id);
    }
}
