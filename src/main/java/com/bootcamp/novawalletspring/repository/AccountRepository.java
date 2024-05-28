package com.bootcamp.novawalletspring.repository;

import com.bootcamp.novawalletspring.entity.AccountEntity;
import com.bootcamp.novawalletspring.model.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;

import java.util.List;

public interface AccountRepository extends CrudRepository<AccountEntity, Integer>{

    int save(Account account);
    int update(Account account, int id);
    int delete(int id);
    AccountEntity getById(int id);
    AccountEntity getByOwnerId(int ownerId);
    List<AccountEntity> getAll();

}
