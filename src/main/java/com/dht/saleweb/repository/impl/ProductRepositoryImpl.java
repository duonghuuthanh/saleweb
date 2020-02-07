/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.saleweb.repository.impl;

import com.dht.saleweb.model.Product;
import com.dht.saleweb.repository.ProductRepository;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author duonghuuthanh
 */
@Repository

public class ProductRepositoryImpl implements ProductRepository {
    @Autowired
    private SessionFactory sessionFactory;    

    @Override
    public List<Product> getProducts(String kw) {
        List<Product> products;
        Session session = sessionFactory.getCurrentSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Product> cr = builder.createQuery(Product.class);
        Root<Product> root = cr.from(Product.class);

        CriteriaQuery<Product> query = cr.select(root);
        if (!kw.isEmpty()) {
            String pattern = String.format("%%%s%%", kw);
            Predicate p1 = builder.like(root.get("name").as(String.class), pattern);
            Predicate p2 = builder.like(root.get("description").as(String.class), pattern);
            Predicate p3 = builder.like(root.get("manufacturer").as(String.class), pattern);

            query = query.where(builder.or(p1, p2, p3));
        }

        products = session.createQuery(query).getResultList();

        return products;
    }
    
    @Override
    public List<Product> getProductsByPrice(BigDecimal fromPrice, BigDecimal toPrice) {
        List<Product> products;
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Product> cr = builder.createQuery(Product.class);
        Root<Product> root = cr.from(Product.class);

        CriteriaQuery query = cr.select(root);

        Predicate p1 = builder.greaterThanOrEqualTo(root.get("price").as(BigDecimal.class), fromPrice);
        Predicate p2 = builder.lessThanOrEqualTo(root.get("price").as(BigDecimal.class), toPrice);

        query = query.where(builder.and(p1, p2));

        products = session.createQuery(query).getResultList();
        
        return products;
    }

    @Override
    public Product getProductById(int id) {
        Product product;
        
        Session session = sessionFactory.getCurrentSession();
        product = session.get(Product.class, id);
        
        return product;
    }

    @Override
    public void addProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.save(product);
    }
    
    @Override
    public boolean checkProductName(String productName) {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Product> cr = builder.createQuery(Product.class);

        Root<Product> root = cr.from(Product.class);
        CriteriaQuery query = cr.select(root);            
        query.where(builder.equal(builder.upper(root.get("name").as(String.class)), 
                productName.toUpperCase()));

        return session.createQuery(query).getSingleResult() == null;
    }
}
