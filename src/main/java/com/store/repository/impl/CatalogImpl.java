package com.store.repository.impl;

import com.store.entity.Catalog;
import com.store.entity.Product;
import com.store.repository.CatalogDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
@Transactional
@Repository
public class CatalogImpl implements CatalogDao {
    @Autowired
    SessionFactory sessionFactory;
    @Override
    public Catalog findById(Integer catalogId) {
        Catalog catalog = sessionFactory.getCurrentSession().find(Catalog.class,catalogId);
        return catalog;
    }

    @Override
    public List<Catalog> findAll() {
        List<Catalog> list = sessionFactory.getCurrentSession().createQuery("from catalog ").getResultList();
        return list;
    }

    @Override
    public Catalog create(Catalog entity) {
        Catalog catalog = (Catalog) sessionFactory.getCurrentSession().save(entity);
        return catalog;
    }

    @Override
    public void update(Catalog entity) {
        sessionFactory.getCurrentSession().update(entity);
    }

    @Override
    public Catalog delete(Integer catalogId) {
        Catalog catalog = sessionFactory.getCurrentSession().find(Catalog.class,catalogId);
        sessionFactory.getCurrentSession().update(catalog);
        return catalog;
    }

    @Override
    public List<Product> findByKeyWords(String keywords) {
        String hql ="FROM product p where p.name like :kw or p.catalog.name " +
                "like :kw or p.catalog.nameVN like :kw ";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        query.setParameter("kw","%"+keywords+"%");
        List<Product> list = query.getResultList();
        return list;
    }
}
