package com.bootcamp.novawalletspring.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;

public class Transaction {
    private int id;
    private BigDecimal amount;
    private int currencyId;
    private TransactionType transactionType;
    private int senderUserId;
    private int senderAccountId;
    private int receiverUserId;
    private int receiverAccountId;
    private final Timestamp creationDate;

    public Transaction(int id, BigDecimal amount, int currencyId, TransactionType transactionType,
                       int senderUserId, int senderAccountId, int receiverUserId,
                       int receiverAccountId, Timestamp creationDate) {
        this.id = id;
        this.amount = amount;
        this.currencyId = currencyId;
        this.transactionType = transactionType;
        this.senderUserId = senderUserId;
        this.senderAccountId = senderAccountId;
        this.receiverUserId = receiverUserId;
        this.receiverAccountId = receiverAccountId;
        this.creationDate = creationDate;
    }

    public Transaction(BigDecimal amount, int currencyId, TransactionType transactionType,
                       int senderUserId, int senderAccountId, int receiverUserId,
                       int receiverAccountId) {
        this(0, amount, currencyId, transactionType, senderUserId, senderAccountId,
                receiverUserId, receiverAccountId, Timestamp.from(Instant.now()));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public int getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(int currencyId) {
        this.currencyId = currencyId;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public int getSenderUserId() {
        return senderUserId;
    }

    public void setSenderUserId(int senderUserId) {
        this.senderUserId = senderUserId;
    }

    public int getSenderAccountId() {
        return senderAccountId;
    }

    public void setSenderAccountId(int senderAccountId) {
        this.senderAccountId = senderAccountId;
    }

    public int getReceiverAccountId() {
        return receiverAccountId;
    }

    public void setReceiverAccountId(int receiverAccountId) {
        this.receiverAccountId = receiverAccountId;
    }

    public int getReceiverUserId() {
        return receiverUserId;
    }

    public void setReceiverUserId(int receiverUserId) {
        this.receiverUserId = receiverUserId;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }
}
