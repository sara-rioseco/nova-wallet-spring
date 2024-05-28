package com.bootcamp.novawalletspring.repository;

import com.bootcamp.novawalletspring.entity.CurrencyEntity;
import com.bootcamp.novawalletspring.entity.CurrencyEntity;
import com.bootcamp.novawalletspring.model.Currency;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CurrencyRepository extends CrudRepository<CurrencyEntity, Integer> {
    int save(Currency currency);
    int update(Currency currency, int id);
    int delete(int id);
    CurrencyEntity getById(int id);
    CurrencyEntity getBySymbol(String symbol);
    List<CurrencyEntity> getAll();
}
