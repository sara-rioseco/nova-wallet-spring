package com.bootcamp.novawalletspring.rest;

import com.bootcamp.novawalletspring.entity.Transaction;
import com.bootcamp.novawalletspring.service.TransactionService;
import org.springframework.web.bind.annotation.*;

/**
 * The type Transaction rest controller.
 */
@RestController
@RequestMapping("api/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    /**
     * Instantiates a new Transaction controller.
     *
     * @param transactionService the transaction service
     */
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    /**
     * Gets transactions.
     *
     * @return the transactions
     */
    @GetMapping
    public Iterable<Transaction> getTransactions() {
        return transactionService.getAllTransactions();
    }

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
    @GetMapping("/{id}")
    public Transaction getById(@PathVariable int id) {
        return transactionService.getTransactionById(id);
    }

    /**
     * Gets by owner id.
     *
     * @param id the id
     * @return the by owner id
     */
    @GetMapping("/user/{id}")
    public Iterable<Transaction> getByOwnerId(@PathVariable int id) {
        return transactionService.getTransactionsByUserId(id);
    }

    /**
     * Create transaction.
     *
     * @param transaction the transaction
     * @return the transaction
     */
    @PostMapping
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        return transactionService.createTransaction(transaction);
    }

    /**
     * Delete transaction.
     *
     * @param id the id
     * @return the boolean
     */
    @DeleteMapping("/{id}")
    public boolean deleteTransaction(@PathVariable int id) {
        return transactionService.deleteTransaction(id);
    }
}
