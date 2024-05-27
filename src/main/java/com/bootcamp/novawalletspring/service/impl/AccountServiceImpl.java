package com.bootcamp.novawalletspring.service.impl;

import com.bootcamp.novawalletspring.entity.AccountEntity;
import com.bootcamp.novawalletspring.repository.AccountRepository;
import com.bootcamp.novawalletspring.repository.CurrencyRepository;
import com.bootcamp.novawalletspring.repository.UserRepository;
import com.bootcamp.novawalletspring.model.Account;
import com.bootcamp.novawalletspring.model.TransactionType;
import com.bootcamp.novawalletspring.repository.impl.CurrencyRepositoryImpl;
import com.bootcamp.novawalletspring.repository.impl.UserRepositoryImpl;
import com.bootcamp.novawalletspring.service.AccountService;
import com.bootcamp.novawalletspring.service.CurrencyService;
import com.bootcamp.novawalletspring.service.UserService;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.bootcamp.novawalletspring.model.TransactionType.*;

@Service
@CommonsLog
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public boolean createAccount(Account account) {
        UserRepository userRepository = new UserRepositoryImpl();
        CurrencyRepository currencyRepository = new CurrencyRepositoryImpl();
        if (account != null
                && account.getOwnerId() > 0
                && userRepository.findById(account.getOwnerId()).isPresent()
                && account.getCurrencyId() > 0
                && currencyRepository.findById(account.getCurrencyId()).isPresent()
                && account.getBalance().compareTo(BigDecimal.ZERO) == 0
                ) {
            return accountRepository.save(account) > 0;
        } else {
            System.out.println("Error creating account");
            return false;
        }
    }

    @Override
    public Account getAccountById(int id) {
        return new Account(accountRepository.getById(id));
    }

    @Override
    public boolean updateBalance(int id, BigDecimal amount, TransactionType type, boolean ownerUser) {
        Account account = new Account(accountRepository.getById(id));
        if (id > 0
                && amount.compareTo(BigDecimal.ZERO) > 0
                && (type == deposit || type == withdrawal || type == transfer)) {
            if ((type == transfer && ownerUser)|| type == withdrawal) {
                account.subtractBalance(amount);
            }
            if((type == transfer && !ownerUser)|| type == deposit) {
                account.addBalance(amount);
            return accountRepository.update(account);
        } else {
            System.out.println("Error updating balance");
            return false;
        }
    }

    @Override
    public boolean deleteAccount(int id) {
        if (accountRepository.getAccountById(id) != null) {
            return accountRepository.deleteAccount(id);
        } else {
            System.out.println("Error deleting account");
            return false;
        }
    }

    @Override
    public List<Account> getAccountsByOwnerId(int id) {
        return accountRepository.getAccountsByOwnerId(id);
    }

    @Override
    public List<Account> getAllAccounts() {
        List<AccountEntity> accounts = accountRepository.getAll();
        for (AccountEntity account : accounts) {

        }

        return
    }
}
