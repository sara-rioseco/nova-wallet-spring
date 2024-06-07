package com.bootcamp.novawalletspring.rest;

import com.bootcamp.novawalletspring.entity.Account;
import com.bootcamp.novawalletspring.repository.AccountRepository;
import com.bootcamp.novawalletspring.service.AccountService;
import com.bootcamp.novawalletspring.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping
    public Iterable<Account> getEmployees() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/{id}")
    public Account getById(@PathVariable int id) {
        return accountService.getAccountById(id);
    }
}
