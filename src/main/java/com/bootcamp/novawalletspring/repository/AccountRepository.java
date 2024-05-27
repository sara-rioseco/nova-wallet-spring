package com.bootcamp.novawalletspring.repository;

import com.bootcamp.novawalletspring.entity.AccountEntity;
import com.bootcamp.novawalletspring.model.Account;
import jakarta.annotation.Nonnull;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;
import org.springframework.lang.NonNullApi;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface AccountRepository {

    int save(@NonNull Account account);
    int update(Account account, int id);
    int delete(int id);
    AccountEntity getById(int id);
    AccountEntity getByOwnerId(int ownerId);
    List<AccountEntity> getAll();

}
