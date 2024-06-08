package com.bootcamp.novawalletspring.repository;

import com.bootcamp.novawalletspring.entity.Account;
import jakarta.annotation.Nonnull;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends CrudRepository<Account, Integer> {

    @Override
    @Transactional
    @Nonnull
    <S extends Account> S save(@Nonnull S entity);

    @Override
    @Nonnull
    Optional<Account> findById(@Nonnull Integer id);

    @Query("SELECT acc FROM Account acc WHERE acc.owner.id = :ownerId")
    Optional<Account> findByOwnerId(int ownerId);

    @Override
    boolean existsById(@Nonnull Integer integer);

    @Override
    @Nonnull
    Iterable<Account> findAll();

    @Override
    @Transactional
    void deleteById(@Nonnull Integer integer);

    @Override
    @Transactional
    void deleteAll();
}
