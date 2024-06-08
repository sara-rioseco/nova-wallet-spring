package com.bootcamp.novawalletspring.rest;

import com.bootcamp.novawalletspring.entity.Currency;
import com.bootcamp.novawalletspring.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/currency")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @GetMapping
    public Iterable<Currency> getCurrencies() {
        return currencyService.getAllCurrencies();
    }

    @GetMapping("/{id}")
    public Currency getById(@PathVariable int id) {
        return currencyService.getCurrencyById(id);
    }

    @GetMapping("/symbol/{symbol}")
    public Currency getBySymbol(@PathVariable String symbol) {
        return currencyService.getCurrencyBySymbol(symbol);
    }

    @PostMapping
    public Currency createCurrency(@RequestBody Currency currency) {
        return currencyService.createCurrency(currency);
    }

    @PatchMapping
    public Currency updateCurrency(@RequestBody Currency currency) {
        return currencyService.updateCurrency(currency);
    }

    @DeleteMapping("/{id}")
    public boolean deleteCurrency(@PathVariable int id) {
        return currencyService.deleteCurrency(id);
    }
    
}
