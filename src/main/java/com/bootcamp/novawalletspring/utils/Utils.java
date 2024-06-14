package com.bootcamp.novawalletspring.utils;

import com.bootcamp.novawalletspring.entity.Currency;
import com.bootcamp.novawalletspring.entity.Transaction;
import com.bootcamp.novawalletspring.entity.User;
import com.bootcamp.novawalletspring.model.TransactionItem;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class Utils {
    /**
     * Gets initial.
     *
     * @param word the word
     * @return the initial
     */
    public static String getInitial(String word) {
        return String.valueOf(word.charAt(0)).toUpperCase();
    }

    /**
     * Capitalize string.
     *
     * @param word the word
     * @return the string
     */
    public static String capitalize(String word) {
        return getInitial(word) + word.substring(1).toLowerCase();
    }

    /**
     * Format date string.
     *
     * @param timestamp the java.sql timestamp
     * @return the string
     */
    public static String formatDate(Timestamp timestamp){
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return formatDate.format(timestamp.toLocalDateTime());
    }

    /**
     * Format time string.
     *
     * @param timestamp the java.sql timestamp
     * @return the string
     */
    public static String formatTime(Timestamp timestamp){
        DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("hh:mm a");
        return formatTime.format(timestamp.toLocalDateTime());
    }

    /**
     * Format big decimal as currency string.
     *
     * @param bigDecimal the big decimal
     * @param currency   the currency
     * @return the string
     */
    public static String formatBigDecimalAsCurrency(BigDecimal bigDecimal, Currency currency){
        return NumberFormat.getCurrencyInstance(Objects.equals(currency.getSymbol(), "USD") ? Locale.US : Objects.equals(currency.getSymbol(), "EUR") ? Locale.ITALY : null).format(bigDecimal);
    }

    /**
     * Format transactions list.
     *
     * @param transactions the transactions
     * @param currentUser  the current user
     * @return the list
     */
    public static List<TransactionItem> formatTransactions(Iterable<Transaction> transactions, User currentUser) {
        if (transactions.iterator().hasNext()) {
            List<TransactionItem> formattedTr = new ArrayList<>();
            transactions.forEach(tr -> {
                TransactionItem transaction = new TransactionItem();
                transaction.setAmount(NumberFormat.getCurrencyInstance(Locale.US).format(tr.getAmount()));
                transaction.setType(capitalize(tr.getTransactionType().name()));
                transaction.setDate("On " + formatDate(tr.getCreationDate()) + " at " + formatTime(tr.getCreationDate()));
                transaction.setCurrency(tr.getCurrency().getSymbol());
                transaction.setSymbol(
                        (Objects.equals(String.valueOf(tr.getTransactionType()), "WITHDRAWAL")
                                || (Objects.equals(String.valueOf(tr.getTransactionType()), "TRANSFER")
                                && Objects.equals(currentUser.getId(), tr.getSenderUser().getId())))
                                ? "-" : "");
                formattedTr.add(transaction);
            });
            return formattedTr;
        }
        return null;
    }
}
