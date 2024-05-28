package com.bootcamp.novawalletspring.service.impl;

import com.bootcamp.novawalletspring.entity.CurrencyEntity;
import com.bootcamp.novawalletspring.model.Currency;
import com.bootcamp.novawalletspring.repository.CurrencyRepository;
import com.bootcamp.novawalletspring.service.CurrencyService;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@CommonsLog
public class CurrencyServiceImpl implements CurrencyService {

    @Autowired
    CurrencyRepository currencyRepository;

    @Override
    public boolean createCurrency(Currency currency) {
        if (currency != null
                && currency.getName() !=null
                && !currency.getName().isBlank()
                && currency.getSymbol() !=null
                && currency.getSymbol().length() == 3
                && !currency.getSymbol().isBlank()
                && currencyRepository.getBySymbol(currency.getSymbol()) == null) {
            return currencyRepository.save(currency) > 0;
        } else {
            System.out.println("Error creating currency");
            return false;
        }
    }

    @Override
    public Currency getCurrencyById(int id) {
        return new Currency(currencyRepository.getById(id));
    }

    @Override
    public boolean updateCurrency(Currency currency) {
        if (currency != null
                && currency.getName() !=null
                && !currency.getName().isBlank()
                && currency.getSymbol() !=null
                && currency.getSymbol().length() == 3
                && !currency.getSymbol().isBlank()
                && currencyRepository.getById(currency.getId()) != null) {
            return currencyRepository.update(currency, currency.getId()) > 0;
        } else {
            System.out.println("Error updating currency");
            return false;
        }
    }

    @Override
    public boolean deleteCurrency(int id) {
        if (currencyRepository.getById(id) != null) {
            return currencyRepository.delete(id) > 0;
        } else {
            System.out.println("Error deleting currency");
            return false;
        }
    }

    @Override
    public List<Currency> getAllCurrencies() {
        List<CurrencyEntity> currencies = currencyRepository.getAll();
        List<Currency> result = new ArrayList<>();
        for (CurrencyEntity currency : currencies) {
            result.add(new Currency(currency));
        }
        return result;
    }
}
