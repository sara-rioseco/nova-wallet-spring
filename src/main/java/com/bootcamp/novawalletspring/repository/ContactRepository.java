package com.bootcamp.novawalletspring.repository;

import com.bootcamp.novawalletspring.entity.Contact;
import com.bootcamp.novawalletspring.entity.User;
import jakarta.annotation.Nonnull;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Integer> {

    @Override
    @Nonnull
    @Transactional
    <S extends Contact> S save(@Nonnull S entity);

    @Override
    @Nonnull
    Optional<Contact> findById(@Nonnull Integer id);

    @Query("SELECT c.contactUser FROM Contact c WHERE c.id = :id")
    User findContactUserByContactId(int id);

    @Override
    boolean existsById(@Nonnull Integer id);

    @Override
    @Nonnull
    Iterable<Contact> findAll();


    @Query("SELECT c FROM Contact c WHERE c.ownerUser.id = :ownerId")
    Iterable<Contact> findAllByOwnerId(int ownerId);

    @Override
    void deleteById(@Nonnull Integer id);

    @Override
    void deleteAll();
}
