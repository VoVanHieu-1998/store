package com.store.repository.impl;

import com.store.entity.Product;
import com.store.repository.ProductDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Repository
public class ProductImpl implements ProductDao {
    @Autowired
    SessionFactory sessionFactory;
    @Override
    public Product findById(Integer productId) {
        Product product = sessionFactory.getCurrentSession().find(Product.class,productId);
        return product;
    }

    @Override
    public List<Product> findAll() {
        List<Product> list = sessionFactory.getCurrentSession().createQuery("from product ").getResultList();
        return list;
    }

    @Override
    public Product create(Product entity) {
        Product product = (Product) sessionFactory.getCurrentSession().save(entity);
        return product;
    }

    @Override
    public void update(Product entity) {
        sessionFactory.getCurrentSession().update(entity);
    }

    @Override
    public Product delete(Integer productId) {
        Product product = sessionFactory.getCurrentSession().find(Product.class,productId);
        sessionFactory.getCurrentSession().update(product);
        return product;
    }

    @Override
    public List<Product> findByIds(String ids) {
        String hql ="FROM product p where p.id in ("+ ids +") ";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        List<Product> list = query.getResultList();
        return list;
    }

    @Override
    public List<Product> findBySpecial(int id) {
        Session session = sessionFactory.getCurrentSession();
        StringBuilder hql = new StringBuilder();
        switch (id){
            case 0://mới
                hql.append("FROM product p order by p.dateCreated DESC ");
                break;
            case 1://bán chạy dùng hàm size kích thước tập hợp
                hql.append("FROM product p order by size(p.productDetails) DESC ");
                break;
            case 2://xem nhiều
                hql.append("FROM product p order by p.viewCount DESC ");
                break;
            case 3://giảm giá
                hql.append("FROM product p order by p.giamgia DESC ");
                break;
        }
        Query query = session.createQuery(hql.toString());
        query.setMaxResults(12);
        List<Product> list = query.getResultList();

        return list;
    }
}
