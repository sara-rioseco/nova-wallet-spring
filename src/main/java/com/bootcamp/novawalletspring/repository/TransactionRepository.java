package com.bootcamp.novawalletspring.repository;

import com.bootcamp.novawalletspring.entity.Transaction;
import jakarta.annotation.Nonnull;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * The interface Transaction repository.
 */
@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Integer> {

    @Override
    @Transactional
    @Nonnull
    <S extends Transaction> S save(@Nonnull S entity);

    @Override
    @Nonnull
    Optional<Transaction> findById(@Nonnull Integer id);

    /**
     * Find all by user id iterable.
     *
     * @param id the id
     * @return the iterable
     */
    @Query("SELECT transaction FROM Transaction transaction WHERE transaction.receiverUser.id = :id OR transaction.senderUser.id = :id ORDER BY transaction.creationDate DESC")
    Iterable<Transaction> findAllByUserId(Integer id);

    @Override
    @Nonnull
    Iterable<Transaction> findAll();

    @Override
    @Transactional
    void deleteById(@Nonnull Integer id);

    @Override
    @Transactional
    void deleteAll();
}
