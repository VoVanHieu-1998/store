package com.store.service;

import com.store.entity.Catalog;
import com.store.entity.Product;

import java.util.List;

public interface CatalogService {
    Catalog findById(Integer catalogId);
    List<Catalog> findAll();
    Catalog create(Catalog entity);
    void update(Catalog entity);
    Catalog delete(Integer catalogId);
    List<Product> findByKeyWords(String keywords);
}
