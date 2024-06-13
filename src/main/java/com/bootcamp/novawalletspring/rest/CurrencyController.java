package com.bootcamp.novawalletspring.rest;

import com.bootcamp.novawalletspring.entity.Currency;
import com.bootcamp.novawalletspring.service.CurrencyService;
import org.springframework.web.bind.annotation.*;

/**
 * The type Currency rest controller.
 */
@RestController
@RequestMapping("api/currency")
public class CurrencyController {

    private final CurrencyService currencyService;

    /**
     * Instantiates a new Currency controller.
     *
     * @param currencyService the currency service
     */
    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    /**
     * Gets currencies.
     *
     * @return the currencies
     */
    @GetMapping
    public Iterable<Currency> getCurrencies() {
        return currencyService.getAllCurrencies();
    }

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
    @GetMapping("/{id}")
    public Currency getById(@PathVariable int id) {
        return currencyService.getCurrencyById(id);
    }

    /**
     * Gets by symbol.
     *
     * @param symbol the symbol
     * @return the by symbol
     */
    @GetMapping("/symbol/{symbol}")
    public Currency getBySymbol(@PathVariable String symbol) {
        return currencyService.getCurrencyBySymbol(symbol);
    }

    /**
     * Create currency.
     *
     * @param currency the currency
     * @return the currency
     */
    @PostMapping
    public Currency createCurrency(@RequestBody Currency currency) {
        return currencyService.createCurrency(currency);
    }

    /**
     * Update currency.
     *
     * @param currency the currency
     * @return the currency
     */
    @PatchMapping
    public Currency updateCurrency(@RequestBody Currency currency) {
        return currencyService.updateCurrency(currency);
    }

    /**
     * Delete currency.
     *
     * @param id the id
     * @return the boolean
     */
    @DeleteMapping("/{id}")
    public boolean deleteCurrency(@PathVariable int id) {
        return currencyService.deleteCurrency(id);
    }
}
