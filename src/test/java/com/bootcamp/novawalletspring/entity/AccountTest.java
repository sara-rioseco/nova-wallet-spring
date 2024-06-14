package com.bootcamp.novawalletspring.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    private Account account;
    private User owner;
    private Currency currency;

    @BeforeEach
    void setUp() {
        owner = new User();
        owner.setId(1);
        owner.setFirstName("John");
        owner.setLastName("Doe");
        owner.setUsername("john.doe@example.com");

        currency = new Currency();
        currency.setId(1);
        currency.setName("US Dollar");
        currency.setSymbol("USD");

        account = new Account();
        account.setId(1);
        account.setOwner(owner);
        account.setCurrency(currency);
        account.setBalance(BigDecimal.valueOf(1000));
        account.setCreationDate(new Timestamp(System.currentTimeMillis()));
    }

    @Test
    void testGetId() {
        assertEquals(1, account.getId());
    }

    @Test
    void testGetOwner() {
        assertEquals(owner, account.getOwner());
    }

    @Test
    void testGetCurrency() {
        assertEquals(currency, account.getCurrency());
    }

    @Test
    void testGetBalance() {
        assertEquals(BigDecimal.valueOf(1000), account.getBalance());
    }

    @Test
    void testGetCreationDate() {
        assertNotNull(account.getCreationDate());
    }

    @Test
    void testSetId() {
        account.setId(2);
        assertEquals(2, account.getId());
    }

    @Test
    void testSetOwner() {
        User newOwner = new User();
        newOwner.setId(2);
        newOwner.setFirstName("Jane");
        newOwner.setLastName("Smith");
        newOwner.setUsername("jane.smith@example.com");

        account.setOwner(newOwner);
        assertEquals(newOwner, account.getOwner());
    }

    @Test
    void testSetCurrency() {
        Currency newCurrency = new Currency();
        newCurrency.setId(2);
        newCurrency.setName("Euro");
        newCurrency.setSymbol("EUR");

        account.setCurrency(newCurrency);
        assertEquals(newCurrency, account.getCurrency());
    }

    @Test
    void testSetBalance() {
        account.setBalance(BigDecimal.valueOf(2000));
        assertEquals(BigDecimal.valueOf(2000), account.getBalance());
    }

    @Test
    void testSetCreationDate() {
        Timestamp newTimestamp = new Timestamp(System.currentTimeMillis() - 10000);
        account.setCreationDate(newTimestamp);
        assertEquals(newTimestamp, account.getCreationDate());
    }

    @Test
    void testEqualsAndHashCode() {
        Account anotherAccount = new Account();
        anotherAccount.setId(1);
        anotherAccount.setOwner(owner);
        anotherAccount.setCurrency(currency);
        anotherAccount.setBalance(BigDecimal.valueOf(1000));
        anotherAccount.setCreationDate(account.getCreationDate());

        assertEquals(account, anotherAccount);
        assertEquals(account.hashCode(), anotherAccount.hashCode());
    }

    @Test
    void testToString() {
        String expected = "Account(id=1, owner=User(id=1, firstName=John, lastName=Doe, username=john.doe@example.com, password=null, role=ROLE_USER, creationDate=null, isEnabled=true, accountNoExpired=true, accountNoLocked=true, credentialNoExpired=true), " +
                "currency=Currency(id=1, name=US Dollar, symbol=USD), balance=1000, creationDate=" + account.getCreationDate() + ")";
        assertEquals(expected, account.toString());
    }
}