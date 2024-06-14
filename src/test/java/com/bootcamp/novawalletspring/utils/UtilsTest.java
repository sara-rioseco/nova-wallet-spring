package com.bootcamp.novawalletspring.utils;

import com.bootcamp.novawalletspring.entity.Currency;
import com.bootcamp.novawalletspring.entity.Transaction;
import com.bootcamp.novawalletspring.entity.User;
import com.bootcamp.novawalletspring.model.TransactionItem;
import com.bootcamp.novawalletspring.model.TransactionType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UtilsTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void testGetInitial() {
        String initial = Utils.getInitial("hello");
        assertEquals("H", initial);
    }

    @Test
    void testCapitalize() {
        String capitalized = Utils.capitalize("hello");
        assertEquals("Hello", capitalized);
    }

    @Test
    void testFormatDate() {
        Timestamp timestamp = Timestamp.valueOf(LocalDateTime.of(2023, 6, 13, 12, 0));
        String formattedDate = Utils.formatDate(timestamp);
        assertEquals("13-06-2023", formattedDate);
    }

    @Test
    void testFormatTime() {
        Timestamp timestamp = Timestamp.valueOf(LocalDateTime.of(2023, 6, 13, 12, 0));
        String formattedTime = Utils.formatTime(timestamp);
        assertEquals("12:00 p. m.", formattedTime);
    }

    @Test
    void testFormatBigDecimalAsCurrency_USD() {
        Currency currency = mock(Currency.class);
        when(currency.getSymbol()).thenReturn("USD");

        String formatted = Utils.formatBigDecimalAsCurrency(BigDecimal.valueOf(1000), currency);
        assertEquals("$1,000.00", formatted);
    }

    @Test
    void testFormatBigDecimalAsCurrency_Other() {
        Currency currency = mock(Currency.class);
        when(currency.getSymbol()).thenReturn("EUR");

        String formatted = Utils.formatBigDecimalAsCurrency(BigDecimal.valueOf(1000), currency);
        assertEquals("1.000,00 €", formatted);
    }

    @Test
    void testFormatTransactions() {
        User sender = mock(User.class);
        User receiver = mock(User.class);
        User currentUser = mock(User.class);
        Currency currency = mock(Currency.class);
        when(currency.getSymbol()).thenReturn("USD");

        Transaction transaction1 = new Transaction();
        transaction1.setAmount(BigDecimal.valueOf(1000));
        transaction1.setTransactionType(TransactionType.DEPOSIT);
        transaction1.setCreationDate(Timestamp.valueOf(LocalDateTime.of(2023, 6, 13, 12, 0)));
        transaction1.setCurrency(currency);
        transaction1.setSenderUser(sender);
        transaction1.setReceiverUser(receiver);

        Transaction transaction2 = new Transaction();
        transaction2.setAmount(BigDecimal.valueOf(500));
        transaction2.setTransactionType(TransactionType.WITHDRAWAL);
        transaction2.setCreationDate(Timestamp.valueOf(LocalDateTime.of(2023, 6, 13, 13, 0)));
        transaction2.setCurrency(currency);
        transaction2.setSenderUser(sender);
        transaction2.setReceiverUser(receiver);

        Iterable<Transaction> transactions = Arrays.asList(transaction1, transaction2);
        when(currentUser.getId()).thenReturn(1);
        when(sender.getId()).thenReturn(1);

        List<TransactionItem> transactionItems = Utils.formatTransactions(transactions, currentUser);

        assertNotNull(transactionItems);
        assertEquals(2, transactionItems.size());

        TransactionItem item1 = transactionItems.get(0);
        assertEquals("$1,000.00", item1.getAmount());
        assertEquals("Deposit", item1.getType());
        assertEquals("On 13-06-2023 at 12:00 p. m.", item1.getDate());
        assertEquals("USD", item1.getCurrency());
        assertEquals("", item1.getSymbol());

        TransactionItem item2 = transactionItems.get(1);
        assertEquals("$500.00", item2.getAmount());
        assertEquals("Withdrawal", item2.getType());
        assertEquals("On 13-06-2023 at 01:00 p. m.", item2.getDate());
        assertEquals("USD", item2.getCurrency());
        assertEquals("-", item2.getSymbol());
    }

    @Test
    void testFormatTransactions_NoTransactions() {
        Iterable<Transaction> transactions = Arrays.asList();
        User currentUser = mock(User.class);

        List<TransactionItem> transactionItems = Utils.formatTransactions(transactions, currentUser);

        assertNull(transactionItems);
    }
}