package com.store.service;

import com.store.entity.Users;

import java.util.List;

public interface UserService {
    Users findById(Integer usersId);
    List<Users> findAll();
    int create(Users entity);
    void update(Users entity);
    Users delete(Integer usersId);
    Users findByUsername(String userName);
    boolean checkByUsername(String username);
}
