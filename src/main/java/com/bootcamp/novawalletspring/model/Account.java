package com.bootcamp.novawalletspring.model;

import com.bootcamp.novawalletspring.entity.AccountEntity;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;

@Data
public class Account {
    private int id;
    private final int ownerId;
    private final int currencyId;
    private BigDecimal balance;
    private final Timestamp creationDate;

    public Account(int id, int ownerId, int currencyId, BigDecimal balance, Timestamp creationDate) {
        this.id = id;
        this.ownerId = ownerId;
        this.currencyId = currencyId;
        this.balance = balance;
        this.creationDate = creationDate;
    }

    public Account(int ownerId, int currencyId) {
        this(0, ownerId, currencyId, new BigDecimal(0), Timestamp.from(Instant.now()));
    }

    public Account(AccountEntity account){
        this(account.getId(), account.getOwnerId().getId(), account.getCurrencyId().getId(), account.getBalance(), Timestamp.from(account.getCreationDate()));
    }

    public void addBalance(BigDecimal amount) {
        this.balance = this.balance.add(amount);
    }

    public void subtractBalance(BigDecimal amount) {
        this.balance = this.balance.subtract(amount);
    }

}
