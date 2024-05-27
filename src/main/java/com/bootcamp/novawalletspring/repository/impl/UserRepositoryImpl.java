package com.bootcamp.novawalletspring.repository.impl;

import com.bootcamp.novawalletspring.entity.UserEntity;
import com.bootcamp.novawalletspring.repository.UserRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Override
    @NonNull
    public <S extends UserEntity> S save(S entity) {
        return null;
    }

    @Override
    @NonNull
    public <S extends UserEntity> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    @NonNull
    public Optional<UserEntity> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    @NonNull
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    @NonNull
    public Iterable<UserEntity> findAll() {
        return null;
    }

    @Override
    @NonNull
    public Iterable<UserEntity> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    @NonNull
    public long count() {
        return 0;
    }

    @Override
    @NonNull
    public void deleteById(Integer integer) {

    }

    @Override
    @NonNull
    public void delete(UserEntity entity) {

    }

    @Override
    @NonNull
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    @NonNull
    public void deleteAll(Iterable<? extends UserEntity> entities) {

    }

    @Override
    @NonNull
    public void deleteAll() {

    }
}
