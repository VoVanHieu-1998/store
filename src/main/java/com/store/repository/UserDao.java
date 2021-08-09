package com.store.repository;

import com.store.entity.Users;

import java.util.List;

public interface UserDao {
    Users findById(Integer usersId);
    Users findByUsername(String userName);
    List<Users> findAll();
    int create(Users entity);
    void update(Users entity);
    Users delete(Integer usersId);
    boolean checkByUsername(String username);
}
