package com.store.service;

import com.store.entity.Order;

import java.util.List;

public interface OrderService {
    Order findById(Integer usersId);
    List<Order> findAll();
    Order create(Order entity);
    void update(Order entity);
    Order delete(Integer usersId);
}
