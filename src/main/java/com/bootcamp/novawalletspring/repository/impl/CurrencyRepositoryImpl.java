package com.bootcamp.novawalletspring.repository.impl;

import com.bootcamp.novawalletspring.entity.CurrencyEntity;
import com.bootcamp.novawalletspring.repository.CurrencyRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CurrencyRepositoryImpl implements CurrencyRepository {

    @Override
    @NonNull
    public <S extends CurrencyEntity> S save(S entity) {
        return null;
    }

    @Override
    @NonNull
    public <S extends CurrencyEntity> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    @NonNull
    public Optional<CurrencyEntity> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    @NonNull
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    @NonNull
    public Iterable<CurrencyEntity> findAll() {
        return null;
    }

    @Override
    @NonNull
    public Iterable<CurrencyEntity> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(CurrencyEntity entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends CurrencyEntity> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
