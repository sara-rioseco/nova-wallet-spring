package com.bootcamp.novawalletspring.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@Data
public class TransactionItem {
    private String type;
    private String amount;
    private String symbol;
    private String currency;
    private String date;
}
