package com.bootcamp.novawalletspring.service.impl;

import com.bootcamp.novawalletspring.entity.Account;
import com.bootcamp.novawalletspring.entity.Transaction;
import com.bootcamp.novawalletspring.entity.User;
import com.bootcamp.novawalletspring.model.TransactionType;
import com.bootcamp.novawalletspring.repository.AccountRepository;
import com.bootcamp.novawalletspring.service.AccountService;
import com.bootcamp.novawalletspring.service.TransactionService;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * The type Account service.
 */
@Service
@CommonsLog
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final TransactionService transactionService;

    /**
     * Instantiates a new Account service.
     *
     * @param accountRepository  the account repository
     * @param transactionService the transaction service
     */
    public AccountServiceImpl(AccountRepository accountRepository, TransactionService transactionService) {
        this.accountRepository = accountRepository;
        this.transactionService = transactionService;
    }

    @Override
    public Account createAccount(Account account) {
        try {
            return accountRepository.save(account);
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public Account getAccountById(int id) {
        try {
            Optional<Account> acc = accountRepository.findById(id);
            if (acc.isPresent()) {
                return acc.get();
            }
            else {
                throw new Exception("Error getting account");
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public Account updateBalance(Transaction transaction, Account account) {
        if(accountRepository.existsById(account.getId())
                && transaction.getAmount().compareTo(BigDecimal.ZERO) > 0 ) {
            TransactionType type = transaction.getTransactionType();
            BigDecimal amount = transaction.getAmount();
            User sender = transaction.getSenderUser();
            User receiver = transaction.getReceiverUser();
            Account senderAccount = getAccountById(account.getId());
            Account receiverAccount = null;
            if (type == TransactionType.DEPOSIT && sender.getId().equals(receiver.getId())) {
                BigDecimal newBalance = account.getBalance().add(amount);
                account.setBalance(newBalance);
            }
            if (type == TransactionType.WITHDRAWAL && senderAccount.getBalance().compareTo(amount) >= 0) {
                BigDecimal newBalance = account.getBalance().subtract(amount);
                account.setBalance(newBalance);
            }
            if (type == TransactionType.TRANSFER
                    && senderAccount.getBalance().compareTo(amount) >= 0
                    && !sender.getId().equals(receiver.getId())) {
                receiverAccount = getAccountByOwnerId(receiver.getId());
                BigDecimal newOwnerBalance = account.getBalance().subtract(amount);
                BigDecimal newReceiverBalance = receiverAccount.getBalance().add(amount);
                account.setBalance(newOwnerBalance);
                receiverAccount.setBalance(newReceiverBalance);
            }
            try {
                if (receiverAccount != null) accountRepository.save(receiverAccount);
                transactionService.createTransaction(transaction);
                return accountRepository.save(account);
            } catch (Exception e) {
                log.error(e.getMessage());
                return null;
            }
        } else {
            log.error("There was an error updating the balance");
            return null;
        }
    }

    @Override
    public boolean deleteAccount(int id) {
        try {
            accountRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
    }

    @Override
    public Account getAccountByOwnerId(int id) {
        try {
            Optional<Account> acc = accountRepository.findByOwnerId(id);
            if (acc.isPresent()) {
                return acc.get();
            }
            else {
                throw new Exception("Error getting account");
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public Iterable<Account> getAllAccounts() {
        try {
            Iterable<Account> accounts = accountRepository.findAll();
            if (accounts.iterator().hasNext()) {
                return accounts;
            }
            else {
                throw new Exception("Error getting accounts");
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }
}
