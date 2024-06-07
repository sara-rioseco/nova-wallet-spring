package com.bootcamp.novawalletspring.service.impl;

import com.bootcamp.novawalletspring.entity.Account;
import com.bootcamp.novawalletspring.model.TransactionType;
import com.bootcamp.novawalletspring.repository.AccountRepository;
import com.bootcamp.novawalletspring.service.AccountService;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@CommonsLog
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
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

//    @Override
//    public boolean updateBalance(int id, BigDecimal amount, TransactionType type, boolean ownerUser) {
//        return false;
//    }

    @Override
    public boolean deleteAccount(int id) {
        return false;
    }

//    @Override
//    public Account getAccountByOwnerId(int id) {
//        return null;
//    }

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
