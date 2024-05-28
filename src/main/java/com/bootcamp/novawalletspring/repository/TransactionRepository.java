package com.bootcamp.novawalletspring.repository;

import com.bootcamp.novawalletspring.entity.TransactionEntity;
import com.bootcamp.novawalletspring.entity.TransactionEntity;
import com.bootcamp.novawalletspring.model.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends CrudRepository<TransactionEntity, Integer> {
    int save(Transaction transaction);
    int update(Transaction transaction, int id);
    int delete(int id);
    TransactionEntity getById(int id);
    TransactionEntity getByUserId(int id);
    List<TransactionEntity> getAll();
    List<TransactionEntity> getAllByUserId(int userId);
}
