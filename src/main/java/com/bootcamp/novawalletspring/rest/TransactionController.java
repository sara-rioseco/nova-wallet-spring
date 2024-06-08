package com.bootcamp.novawalletspring.rest;

import com.bootcamp.novawalletspring.entity.Transaction;
import com.bootcamp.novawalletspring.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping
    public Iterable<Transaction> getTransactions() {
        return transactionService.getAllTransactions();
    }

    @GetMapping("/{id}")
    public Transaction getById(@PathVariable int id) {
        return transactionService.getTransactionById(id);
    }

    @GetMapping("/user/{id}")
    public Iterable<Transaction> getByOwnerId(@PathVariable int id) {
        return transactionService.getTransactionsByUserId(id);
    }

    @PostMapping
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        return transactionService.createTransaction(transaction);
    }

    @DeleteMapping("/{id}")
    public boolean deleteTransaction(@PathVariable int id) {
        return transactionService.deleteTransaction(id);
    }
}
