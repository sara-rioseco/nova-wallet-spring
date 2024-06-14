package com.bootcamp.novawalletspring.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTypeTest {

    @Test
    void testDeposit() {
        TransactionType deposit = TransactionType.DEPOSIT;
        assertNotNull(deposit);
        assertEquals("DEPOSIT", deposit.name());
        assertEquals(0, deposit.ordinal());
    }

    @Test
    void testWithdrawal() {
        TransactionType withdrawal = TransactionType.WITHDRAWAL;
        assertNotNull(withdrawal);
        assertEquals("WITHDRAWAL", withdrawal.name());
        assertEquals(1, withdrawal.ordinal());
    }

    @Test
    void testTransfer() {
        TransactionType transfer = TransactionType.TRANSFER;
        assertNotNull(transfer);
        assertEquals("TRANSFER", transfer.name());
        assertEquals(2, transfer.ordinal());
    }

    @Test
    void testValueOf() {
        TransactionType deposit = TransactionType.valueOf("DEPOSIT");
        TransactionType withdrawal = TransactionType.valueOf("WITHDRAWAL");
        TransactionType transfer = TransactionType.valueOf("TRANSFER");

        assertEquals(TransactionType.DEPOSIT, deposit);
        assertEquals(TransactionType.WITHDRAWAL, withdrawal);
        assertEquals(TransactionType.TRANSFER, transfer);
    }

    @Test
    void testValues() {
        TransactionType[] types = TransactionType.values();
        assertEquals(3, types.length);
        assertEquals(TransactionType.DEPOSIT, types[0]);
        assertEquals(TransactionType.WITHDRAWAL, types[1]);
        assertEquals(TransactionType.TRANSFER, types[2]);
    }
}