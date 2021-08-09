package com.store.repository;

import com.store.entity.Catalog;
import com.store.entity.Product;

import java.util.List;

public interface CatalogDao {
    Catalog findById(Integer catalogId);
    List<Catalog> findAll();
    Catalog create(Catalog entity);
    void update(Catalog entity);
    Catalog delete(Integer catalogId);

    List<Product> findByKeyWords(String keywords);
}
