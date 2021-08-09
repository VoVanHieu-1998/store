package com.store.service.impl;

import com.store.entity.Order;
import com.store.repository.OrderDao;
import com.store.service.OrderService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDao orderDao;
    @Override
    public Order findById(Integer orderId) {
        return orderDao.findById(orderId);
    }

    @Override
    public List<Order> findAll() {
       return orderDao.findAll();
    }

    @Override
    public Order create(Order entity) {
        return orderDao.create(entity);
    }

    @Override
    public void update(Order entity){
        orderDao.update(entity);
    }

    @Override
    public Order delete(Integer orderId) {
        return orderDao.delete(orderId);
    }
}
