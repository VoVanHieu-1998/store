package com.store.service.impl;

import com.store.entity.OrderItem;
import com.store.entity.OrderItemId;
import com.store.repository.OrderItemDao;
import com.store.service.OrderItemService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class OrderServiceItemImpl implements OrderItemService {
    @Autowired
    OrderItemDao orderItemDao;
    @Override

    public boolean addOrderItem(OrderItem orderItem) {
        return orderItemDao.addOrderItem(orderItem);
    }
}
