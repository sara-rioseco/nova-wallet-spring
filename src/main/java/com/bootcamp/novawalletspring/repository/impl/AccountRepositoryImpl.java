package com.bootcamp.novawalletspring.repository.impl;

import com.bootcamp.novawalletspring.entity.AccountEntity;
import com.bootcamp.novawalletspring.model.Account;
import com.bootcamp.novawalletspring.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountRepositoryImpl implements AccountRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int save(@NonNull Account account) {
        String sql = "INSERT INTO accounts(owner_id, currency_id) VALUES (?,?);";
        return jdbcTemplate.update(sql, account.getOwnerId(), account.getCurrencyId());
    }

    @Override
    public int update(Account account, int id) {
        return 0;
    }

    @Override
    public int delete(int id) {
        return 0;
    }

    @Override
    public AccountEntity getById(int id) {
        return null;
    }

    @Override
    public AccountEntity getByOwnerId(int ownerId) {
        return null;
    }

    @Override
    public List<AccountEntity> getAll() {
        return List.of();
    }
}
