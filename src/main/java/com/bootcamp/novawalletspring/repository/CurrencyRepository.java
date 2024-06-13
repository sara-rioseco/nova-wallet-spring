package com.bootcamp.novawalletspring.repository;

import com.bootcamp.novawalletspring.entity.Currency;
import jakarta.annotation.Nonnull;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


/**
 * The interface Currency repository.
 */
public interface CurrencyRepository extends CrudRepository<Currency, Integer> {

    @Override
    @Transactional
    @Nonnull
    <S extends Currency> S save(@Nonnull S entity);

    @Override
    @Nonnull
    Optional<Currency> findById(@Nonnull Integer id);

    /**
     * Find by symbol optional.
     *
     * @param symbol the symbol
     * @return the optional
     */
    @Query("SELECT c FROM Currency c WHERE c.symbol = :symbol")
    Optional<Currency> findBySymbol(String symbol);

    @Override
    @Nonnull
    Iterable<Currency> findAll();

    @Override
    boolean existsById(@Nonnull Integer id);

    @Override
    @Transactional
    void deleteById(@Nonnull Integer integer);

    @Override
    @Transactional
    void deleteAll();
}
