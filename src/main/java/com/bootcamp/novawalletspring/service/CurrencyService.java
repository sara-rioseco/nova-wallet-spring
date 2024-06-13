package com.bootcamp.novawalletspring.service;

import com.bootcamp.novawalletspring.entity.Currency;

/**
 * The interface Currency service.
 */
public interface CurrencyService {
    /**
     * Create currency.
     *
     * @param currency the currency
     * @return the currency
     */
    Currency createCurrency(Currency currency);

    /**
     * Gets currency by id.
     *
     * @param id the id
     * @return the currency by id
     */
    Currency getCurrencyById(int id);

    /**
     * Gets currency by symbol.
     *
     * @param symbol the symbol
     * @return the currency by symbol
     */
    Currency getCurrencyBySymbol(String symbol);

    /**
     * Update currency.
     *
     * @param currency the currency
     * @return the currency
     */
    Currency updateCurrency(Currency currency);

    /**
     * Delete currency.
     *
     * @param id the id
     * @return the boolean
     */
    boolean deleteCurrency(int id);

    /**
     * Gets all currencies.
     *
     * @return the all currencies
     */
    Iterable<Currency> getAllCurrencies();
}
