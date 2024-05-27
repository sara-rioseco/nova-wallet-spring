package com.bootcamp.novawalletspring.service;

import com.bootcamp.novawalletspring.model.Currency;

import java.util.List;

public interface CurrencyService {
    boolean createCurrency(Currency currency);
    Currency getCurrencyById(int id);
    boolean updateCurrency(Currency currency);
    boolean deleteCurrency(int id);
    List<Currency> getAllCurrencies();
}
