package com.store.repository.impl;

import com.store.entity.Users;
import com.store.repository.UserDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
@Repository
public class UsersImpl implements UserDao {
    @Autowired
    SessionFactory sessionFactory;
    @Override
    public Users findById(Integer usersId) {
        Users Users = sessionFactory.getCurrentSession().find(Users.class,usersId);
        return Users;
    }

    @Override
    public Users findByUsername(String userName) {
        Session session = sessionFactory.getCurrentSession();
        return (Users) session.createQuery("from user where  username= :username" ).setParameter("username",userName).getSingleResult();

    }

    @Override
    public List<Users> findAll() {
        List<Users> list = sessionFactory.getCurrentSession().createQuery("from user ").getResultList();
        return list;
    }

    @Override
    public int create(Users entity) {
        int users = (int) sessionFactory.getCurrentSession().save(entity);
        return users;
    }

    @Override
    public void update(Users entity) {
        sessionFactory.getCurrentSession().update(entity);
    }

    @Override
    public Users delete(Integer usersId) {
        Users Users = sessionFactory.getCurrentSession().find(Users.class,usersId);
        sessionFactory.getCurrentSession().update(Users);
        return Users;
    }

    @Override
    public boolean checkByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        List<Users> users =  session.createQuery("from user where  username= :username").setParameter("username",username)
                .getResultList();
        if(users != null){
            return false;
        }
        return true;
    }
}
