package com.bootcamp.novawalletspring.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionItemTest {

    @Test
    void testNoArgsConstructor() {
        TransactionItem transactionItem = new TransactionItem();
        assertNotNull(transactionItem);
    }

    @Test
    void testSetType() {
        TransactionItem transactionItem = new TransactionItem();
        transactionItem.setType("Deposit");
        assertEquals("Deposit", transactionItem.getType());
    }

    @Test
    void testSetAmount() {
        TransactionItem transactionItem = new TransactionItem();
        transactionItem.setAmount("$1000");
        assertEquals("$1000", transactionItem.getAmount());
    }

    @Test
    void testSetSymbol() {
        TransactionItem transactionItem = new TransactionItem();
        transactionItem.setSymbol("-");
        assertEquals("-", transactionItem.getSymbol());
    }

    @Test
    void testSetCurrency() {
        TransactionItem transactionItem = new TransactionItem();
        transactionItem.setCurrency("USD");
        assertEquals("USD", transactionItem.getCurrency());
    }

    @Test
    void testSetDate() {
        TransactionItem transactionItem = new TransactionItem();
        transactionItem.setDate("12-06-2024");
        assertEquals("12-06-2024", transactionItem.getDate());
    }

    @Test
    void testToString() {
        TransactionItem transactionItem = new TransactionItem();
        transactionItem.setType("Deposit");
        transactionItem.setAmount("$1000");
        transactionItem.setSymbol("-");
        transactionItem.setCurrency("USD");
        transactionItem.setDate("12-06-2024");

        String expected = "TransactionItem(type=Deposit, amount=$1000, symbol=-, currency=USD, date=12-06-2024)";
        assertEquals(expected, transactionItem.toString());
    }

    @Test
    void testEqualsAndHashCode() {
        TransactionItem transactionItem1 = new TransactionItem();
        transactionItem1.setType("Deposit");
        transactionItem1.setAmount("$1000");
        transactionItem1.setSymbol("-");
        transactionItem1.setCurrency("USD");
        transactionItem1.setDate("12-06-2024");

        TransactionItem transactionItem2 = new TransactionItem();
        transactionItem2.setType("Deposit");
        transactionItem2.setAmount("$1000");
        transactionItem2.setSymbol("-");
        transactionItem2.setCurrency("USD");
        transactionItem2.setDate("12-06-2024");

        assertEquals(transactionItem1, transactionItem2);
        assertEquals(transactionItem1.hashCode(), transactionItem2.hashCode());
    }
}