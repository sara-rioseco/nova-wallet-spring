package com.bootcamp.novawalletspring.entity;

import com.bootcamp.novawalletspring.model.TransactionType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {

    private Transaction transaction;
    private Currency currency;
    private User senderUser;
    private Account senderAccount;
    private User receiverUser;
    private Account receiverAccount;
    private Timestamp creationDate;

    @BeforeEach
    void setUp() {
        creationDate = Timestamp.from(Instant.now());
        currency = new Currency();
        currency.setId(1);
        currency.setName("USD");
        currency.setSymbol("$");

        senderUser = new User();
        senderUser.setId(1);
        senderUser.setFirstName("Jane");
        senderUser.setLastName("Doe");
        senderUser.setUsername("jane.doe@example.com");

        receiverUser = new User();
        receiverUser.setId(2);
        receiverUser.setFirstName("John");
        receiverUser.setLastName("Smith");
        receiverUser.setUsername("john.smith@example.com");

        senderAccount = new Account();
        senderAccount.setId(1);
        senderAccount.setOwner(senderUser);
        senderAccount.setCurrency(currency);
        senderAccount.setBalance(BigDecimal.valueOf(1000));

        receiverAccount = new Account();
        receiverAccount.setId(2);
        receiverAccount.setOwner(receiverUser);
        receiverAccount.setCurrency(currency);
        receiverAccount.setBalance(BigDecimal.valueOf(500));

        transaction = new Transaction();
        transaction.setId(1);
        transaction.setAmount(BigDecimal.valueOf(100));
        transaction.setCurrency(currency);
        transaction.setTransactionType(TransactionType.TRANSFER);
        transaction.setSenderUser(senderUser);
        transaction.setSenderAccount(senderAccount);
        transaction.setReceiverUser(receiverUser);
        transaction.setReceiverAccount(receiverAccount);
        transaction.setCreationDate(creationDate);
    }

    @Test
    void testGetId() {
        assertEquals(1, transaction.getId());
    }

    @Test
    void testGetAmount() {
        assertEquals(BigDecimal.valueOf(100), transaction.getAmount());
    }

    @Test
    void testGetCurrency() {
        assertEquals(currency, transaction.getCurrency());
    }

    @Test
    void testGetTransactionType() {
        assertEquals(TransactionType.TRANSFER, transaction.getTransactionType());
    }

    @Test
    void testGetSenderUser() {
        assertEquals(senderUser, transaction.getSenderUser());
    }

    @Test
    void testGetSenderAccount() {
        assertEquals(senderAccount, transaction.getSenderAccount());
    }

    @Test
    void testGetReceiverUser() {
        assertEquals(receiverUser, transaction.getReceiverUser());
    }

    @Test
    void testGetReceiverAccount() {
        assertEquals(receiverAccount, transaction.getReceiverAccount());
    }

    @Test
    void testGetCreationDate() {
        assertNotNull(transaction.getCreationDate());
    }

    @Test
    void testSetId() {
        transaction.setId(2);
        assertEquals(2, transaction.getId());
    }

    @Test
    void testSetAmount() {
        transaction.setAmount(BigDecimal.valueOf(200));
        assertEquals(BigDecimal.valueOf(200), transaction.getAmount());
    }

    @Test
    void testSetCurrency() {
        Currency newCurrency = new Currency();
        newCurrency.setId(2);
        newCurrency.setName("EUR");
        newCurrency.setSymbol("€");
        transaction.setCurrency(newCurrency);
        assertEquals(newCurrency, transaction.getCurrency());
    }

    @Test
    void testSetTransactionType() {
        transaction.setTransactionType(TransactionType.WITHDRAWAL);
        assertEquals(TransactionType.WITHDRAWAL, transaction.getTransactionType());
    }

    @Test
    void testSetSenderUser() {
        User newSenderUser = new User();
        newSenderUser.setId(3);
        newSenderUser.setFirstName("Alice");
        newSenderUser.setLastName("Brown");
        newSenderUser.setUsername("alice.brown@example.com");
        transaction.setSenderUser(newSenderUser);
        assertEquals(newSenderUser, transaction.getSenderUser());
    }

    @Test
    void testSetSenderAccount() {
        Account newSenderAccount = new Account();
        newSenderAccount.setId(3);
        newSenderAccount.setOwner(senderUser);
        newSenderAccount.setCurrency(currency);
        newSenderAccount.setBalance(BigDecimal.valueOf(300));
        transaction.setSenderAccount(newSenderAccount);
        assertEquals(newSenderAccount, transaction.getSenderAccount());
    }

    @Test
    void testSetReceiverUser() {
        User newReceiverUser = new User();
        newReceiverUser.setId(4);
        newReceiverUser.setFirstName("Bob");
        newReceiverUser.setLastName("Johnson");
        newReceiverUser.setUsername("bob.johnson@example.com");
        transaction.setReceiverUser(newReceiverUser);
        assertEquals(newReceiverUser, transaction.getReceiverUser());
    }

    @Test
    void testSetReceiverAccount() {
        Account newReceiverAccount = new Account();
        newReceiverAccount.setId(4);
        newReceiverAccount.setOwner(receiverUser);
        newReceiverAccount.setCurrency(currency);
        newReceiverAccount.setBalance(BigDecimal.valueOf(400));
        transaction.setReceiverAccount(newReceiverAccount);
        assertEquals(newReceiverAccount, transaction.getReceiverAccount());
    }

    @Test
    void testSetCreationDate() {
        transaction.setCreationDate(creationDate);
        assertEquals(creationDate, transaction.getCreationDate());
    }

    @Test
    void testEqualsAndHashCode() {
        Transaction anotherTransaction = new Transaction();
        anotherTransaction.setId(1);
        anotherTransaction.setAmount(BigDecimal.valueOf(100));
        anotherTransaction.setCurrency(currency);
        anotherTransaction.setTransactionType(TransactionType.TRANSFER);
        anotherTransaction.setSenderUser(senderUser);
        anotherTransaction.setSenderAccount(senderAccount);
        anotherTransaction.setReceiverUser(receiverUser);
        anotherTransaction.setReceiverAccount(receiverAccount);
        anotherTransaction.setCreationDate(creationDate);

        assertEquals(transaction, anotherTransaction);
        assertEquals(transaction.hashCode(), anotherTransaction.hashCode());
    }

    @Test
    void testToString() {
        String expected = "Transaction(id=1, amount=100, currency=Currency(id=1, name=USD, symbol=$), transactionType=TRANSFER, senderUser=User(id=1, firstName=Jane, lastName=Doe, username=jane.doe@example.com, password=null, role=ROLE_USER, creationDate=null, isEnabled=true, accountNoExpired=true, accountNoLocked=true, credentialNoExpired=true), senderAccount=Account(id=1, owner=User(id=1, firstName=Jane, lastName=Doe, username=jane.doe@example.com, password=null, role=ROLE_USER, creationDate=null, isEnabled=true, accountNoExpired=true, accountNoLocked=true, credentialNoExpired=true), currency=Currency(id=1, name=USD, symbol=$), balance=1000, creationDate=null), receiverUser=User(id=2, firstName=John, lastName=Smith, username=john.smith@example.com, password=null, role=ROLE_USER, creationDate=null, isEnabled=true, accountNoExpired=true, accountNoLocked=true, credentialNoExpired=true), receiverAccount=Account(id=2, owner=User(id=2, firstName=John, lastName=Smith, username=john.smith@example.com, password=null, role=ROLE_USER, creationDate=null, isEnabled=true, accountNoExpired=true, accountNoLocked=true, credentialNoExpired=true), currency=Currency(id=1, name=USD, symbol=$), balance=500, creationDate=null), creationDate=" + transaction.getCreationDate() + ")";
        assertEquals(expected, transaction.toString());
    }
}