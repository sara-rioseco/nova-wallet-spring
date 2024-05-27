package com.bootcamp.novawalletspring.service.impl;

import com.bootcamp.novawalletspring.repository.CurrencyRepository;
import com.bootcamp.novawalletspring.model.Currency;
import com.bootcamp.novawalletspring.service.CurrencyService;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CommonsLog
public class CurrencyServiceImpl implements CurrencyService {

    private final CurrencyRepository currencyRepository;

    public CurrencyServiceImpl(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    @Override
    public boolean createCurrency(Currency currency) {
        if (currency != null
                && currency.getName() !=null
                && !currency.getName().isBlank()
                && currency.getSymbol() !=null
                && currency.getSymbol().length() == 3
                && !currency.getSymbol().isBlank()
                && currencyRepository.getCurrencyBySymbol(currency.getSymbol()) == null) {
            return currencyRepository.addCurrency(currency);
        } else {
            System.out.println("Error creating currency");
            return false;
        }
    }

    @Override
    public Currency getCurrencyById(int id) {
        return currencyRepository.getCurrencyById(id);
    }

    @Override
    public boolean updateCurrency(Currency currency) {
        if (currency != null
                && currency.getName() !=null
                && !currency.getName().isBlank()
                && currency.getSymbol() !=null
                && currency.getSymbol().length() == 3
                && !currency.getSymbol().isBlank()
                && currencyRepository.getCurrencyById(currency.getId()) != null) {
            return currencyRepository.updateCurrency(currency);
        } else {
            System.out.println("Error updating currency");
            return false;
        }
    }

    @Override
    public boolean deleteCurrency(int id) {
        if (currencyRepository.getCurrencyById(id) != null) {
            return currencyRepository.deleteCurrency(id);
        } else {
            System.out.println("Error deleting currency");
            return false;
        }
    }

    @Override
    public List<Currency> getAllCurrencies() {
        return currencyRepository.getAllCurrencies();
    }
}
