package com.store.service.impl;

import com.store.entity.Catalog;
import com.store.entity.Product;
import com.store.repository.CatalogDao;
import com.store.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {
    @Autowired
    CatalogDao catalogDao;
    @Override
    public Catalog findById(Integer catalogId) {

        return catalogDao.findById(catalogId);
    }

    @Override
    public List<Catalog> findAll() {
        return catalogDao.findAll();
    }

    @Override
    public Catalog create(Catalog entity) {
        return catalogDao.create(entity);
    }

    @Override
    public void update(Catalog entity) {
        catalogDao.update(entity);
    }

    @Override
    public Catalog delete(Integer catalogId) {
        return catalogDao.delete(catalogId);
    }

    @Override
    public List<Product> findByKeyWords(String keywords) {
        return catalogDao.findByKeyWords(keywords);
    }
}
