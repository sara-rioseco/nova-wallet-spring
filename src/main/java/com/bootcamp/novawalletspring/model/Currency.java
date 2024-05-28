package com.bootcamp.novawalletspring.model;

import com.bootcamp.novawalletspring.entity.CurrencyEntity;
import lombok.Data;

@Data
public class Currency {
    private int id;
    private String name;
    private String symbol;

    public Currency(int id, String name, String symbol) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
    }

    public Currency(String name, String symbol) {
        this(0, name, symbol);
    }

    public Currency(CurrencyEntity currency) {
        this(currency.getId(), currency.getName(), currency.getSymbol());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
