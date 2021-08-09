package com.store.repository.impl;

import com.store.entity.Order;
import com.store.repository.OrderDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class OrderImpl implements OrderDao {
    @Autowired
    SessionFactory sessionFactory;
    @Override
    public Order findById(Integer orderId) {
        Order Order = sessionFactory.getCurrentSession().find(Order.class,orderId);
        return Order;
    }

    @Override
    public List<Order> findAll() {
        List<Order> list = sessionFactory.getCurrentSession().createQuery("from order1 ").getResultList();
        return list;
    }

    @Override
    public Order create(Order entity) {
        Order Order = (Order) sessionFactory.getCurrentSession().save(entity);
        return Order;
    }

    @Override
    public void update(Order entity) {
        sessionFactory.getCurrentSession().update(entity);
    }

    @Override
    public Order delete(Integer orderId) {
        Order Order = sessionFactory.getCurrentSession().find(Order.class,orderId);
        sessionFactory.getCurrentSession().update(Order);
        return Order;
    }
}
