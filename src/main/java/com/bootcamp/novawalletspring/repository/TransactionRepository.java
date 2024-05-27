package com.bootcamp.novawalletspring.repository;

import com.bootcamp.novawalletspring.entity.TransactionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CrudRepository<TransactionEntity, Integer> {

}
