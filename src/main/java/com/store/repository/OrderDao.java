package com.store.repository;

import com.store.entity.Order;

import java.util.List;

public interface OrderDao {
    Order findById(Integer usersId);
    List<Order> findAll();
    Order create(Order entity);
    void update(Order entity);
    Order delete(Integer usersId);
}
