package com.store.repository;

import com.store.entity.Product;

import java.util.List;

public interface ProductDao {
    Product findById(Integer productId);
    List<Product> findAll();
    Product create(Product entity);
    void update(Product entity);
    Product delete(Integer productId);

    List<Product> findByIds(String ids);
    List<Product> findBySpecial(int id);
}
