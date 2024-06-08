package com.bootcamp.novawalletspring.repository;

import com.bootcamp.novawalletspring.entity.Account;
import com.bootcamp.novawalletspring.model.TransactionType;
import jakarta.annotation.Nonnull;
import jakarta.transaction.Transactional;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
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

    @Query("SELECT account FROM Account account WHERE account.owner.id = :ownerId")
    Optional<Account> findByOwnerId(int ownerId);

    @Override
    boolean existsById(@Nonnull Integer integer);

    @Override
    @Nonnull
    Iterable<Account> findAll();

    @Override
    long count();

    @Override
    @Transactional
    void deleteById(@Nonnull Integer integer);

    @Override
    @Transactional
    void deleteAll();
}
