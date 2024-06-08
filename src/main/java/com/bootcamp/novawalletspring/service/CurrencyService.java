package com.bootcamp.novawalletspring.service;

import com.bootcamp.novawalletspring.entity.Currency;

import java.util.List;

public interface CurrencyService {
    Currency createCurrency(Currency currency);
    Currency getCurrencyById(int id);
    Currency getCurrencyBySymbol(String symbol);
    Currency updateCurrency(Currency currency);
    boolean deleteCurrency(int id);
    Iterable<Currency> getAllCurrencies();
}
