package com.bootcamp.novawalletspring.repository;

import com.bootcamp.novawalletspring.entity.ContactEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends CrudRepository<ContactEntity, Integer> {

}
