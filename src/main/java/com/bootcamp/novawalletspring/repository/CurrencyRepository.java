package com.bootcamp.novawalletspring.repository;

import com.bootcamp.novawalletspring.entity.CurrencyEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepository extends CrudRepository<CurrencyEntity, Integer> {

}
