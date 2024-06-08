package com.bootcamp.novawalletspring.service.impl;

import com.bootcamp.novawalletspring.entity.Currency;
import com.bootcamp.novawalletspring.repository.CurrencyRepository;
import com.bootcamp.novawalletspring.service.CurrencyService;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@CommonsLog
public class CurrencyServiceImpl implements CurrencyService {

    private final CurrencyRepository currencyRepository;

    public CurrencyServiceImpl(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    @Override
    public Currency createCurrency(Currency currency) {
        try {
            return currencyRepository.save(currency);
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public Currency getCurrencyById(int id) {
        try {
            Optional<Currency> cur = currencyRepository.findById(id);
            if (cur.isPresent()) {
                return cur.get();
            }
            else {
                throw new Exception("Error getting currency");
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public Currency getCurrencyBySymbol(String symbol) {
        try {
            Optional<Currency> cur = currencyRepository.findBySymbol(symbol.toUpperCase());
            if (cur.isPresent()) {
                return cur.get();
            }
            else {
                throw new Exception("Error getting currency");
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public Currency updateCurrency(Currency currency) {
        if(currencyRepository.existsById(currency.getId())) {
            try {
                return currencyRepository.save(currency);
            } catch (Exception e) {
                log.error(e.getMessage());
                return null;
            }
        } else {
            log.error("Currency not found");
            return null;
        }
    }

    @Override
    public boolean deleteCurrency(int id) {
        try {
            currencyRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
    }

    @Override
    public Iterable<Currency> getAllCurrencies() {
        try {
            Iterable<Currency> currencies = currencyRepository.findAll();
            if (currencies.iterator().hasNext()) {
                return currencies;
            }
            else {
                throw new Exception("Error getting currencies");
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }
}
