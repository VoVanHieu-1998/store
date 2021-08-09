package com.store.repository.impl;

import com.store.entity.OrderItem;
import com.store.entity.OrderItemId;
import com.store.repository.OrderItemDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public class OrderItemImpl implements OrderItemDao {
    @Autowired
    SessionFactory sessionFactory;
    @Override

    public boolean addOrderItem(OrderItem orderItem) {
        Session session = sessionFactory.getCurrentSession();
        OrderItemId id =(OrderItemId) session.save(orderItem);
        if (id!=null){
            return true;
        }else {
            return false;
        }
    }
}
