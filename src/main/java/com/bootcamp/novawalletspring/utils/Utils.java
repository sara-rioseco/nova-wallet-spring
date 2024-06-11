package com.bootcamp.novawalletspring.utils;

import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;

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
}
