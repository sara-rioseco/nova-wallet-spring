package com.bootcamp.novawalletspring.repository;

import com.bootcamp.novawalletspring.entity.ContactEntity;
import com.bootcamp.novawalletspring.entity.ContactEntity;
import com.bootcamp.novawalletspring.model.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends CrudRepository<ContactEntity, Integer> {
    int save(Contact contact);
    int update(Contact contact, int id);
    int delete(int id);
    ContactEntity getById(int id);
    ContactEntity getByOwnerId(int ownerId);
    int getContactUserIdByContactId(int contactId);
    List<ContactEntity> getAll();
    List<ContactEntity> getAllByOwnerId(int ownerId);
}
