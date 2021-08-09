package com.store.service.impl;

import com.store.entity.Users;
import com.store.repository.UserDao;
import com.store.service.UserService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UsersServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Override
    public Users findById(Integer usersId) {
        return userDao.findById(usersId);
    }

    @Override
    public List<Users> findAll() {
        return userDao.findAll();
    }

    @Override
    public int create(Users entity) {
        return userDao.create(entity);
    }

    @Override
    public void update(Users entity) {
        userDao.update(entity);
    }

    @Override
    public Users delete(Integer usersId) {
        return userDao.delete(usersId);
    }

    @Override
    public Users findByUsername(String userName) {
        return userDao.findByUsername(userName);
    }

    @Override
    public boolean checkByUsername(String username) {
        return userDao.checkByUsername(username);
    }
}
