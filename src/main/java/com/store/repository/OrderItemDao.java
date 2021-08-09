package com.store.repository;

import com.store.entity.OrderItem;

public interface OrderItemDao {
    boolean addOrderItem(OrderItem orderItem);
}
