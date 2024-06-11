package com.bootcamp.novawalletspring.repository;

import com.bootcamp.novawalletspring.entity.User;
import jakarta.annotation.Nonnull;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    @Override
    @Nonnull
    @Transactional
    <S extends User> S save(@Nonnull S entity);

    @Override
    @Nonnull
    Optional<User> findById(@Nonnull Integer id);

    @Query("SELECT u FROM User u WHERE u.email = :email")
    Optional<User> findByEmail(@Nonnull String email);

    @Override
    boolean existsById(@Nonnull Integer id);

    @Override
    @Nonnull
    Iterable<User> findAll();

    @Override
    void deleteById(@Nonnull Integer id);

    @Override
    void deleteAll();
}
