package com.bootcamp.novawalletspring.repository;


import com.bootcamp.novawalletspring.entity.UserEntity;
import com.bootcamp.novawalletspring.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {
    int save(User user);
    int update(User user, int id);
    int delete(int id);
    UserEntity getById(int id);
    UserEntity getByEmail(String email);
    List<UserEntity> getAll();
}
