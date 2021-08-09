package com.store.service.impl;

import com.store.entity.Product;
import com.store.repository.ProductDao;
import com.store.service.ProductService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductDao productDao;
    @Override
    public Product findById(Integer productId) {
        return productDao.findById(productId);
    }

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public Product create(Product entity) {
        return productDao.create(entity);
    }

    @Override
    public void update(Product entity) {
        productDao.update(entity);
    }

    @Override
    public Product delete(Integer productId) {
        return productDao.delete(productId);
    }

    @Override
    public List<Product> findByIds(String ids) {
        return productDao.findByIds(ids);
    }

    @Override
    public List<Product> findBySpecial(int id) {
        return productDao.findBySpecial(id);
    }

}
