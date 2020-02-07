/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.saleweb.repository.impl;

import com.dht.saleweb.model.Category;
import com.dht.saleweb.model.Product;
import com.dht.saleweb.repository.CategoryRepository;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 *
 * @author duonghuuthanh
 */
@Repository
public class CategoryRepositoryImpl implements CategoryRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Category> getCategories(String kw) {
        List<Category> cates;
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Category> cr = builder.createQuery(Category.class);
        Root<Category> root = cr.from(Category.class);

        CriteriaQuery query = cr.select(root);
        if (!kw.isEmpty())
            query = query.where(builder.like(root.get("name").as(String.class),  
                    "%" + kw + "%"));

        cates = session.createQuery(query).getResultList();        
        return cates;
    }

    @Override
    public Category getCategoryById(int id) {
        Category cat;
        Session session = sessionFactory.getCurrentSession();
        cat = session.get(Category.class, id);
        
        return cat;
    }

    @Override
    public List<Product> getProductsByCategory(int id) {
        List<Product> products = null;
        Session session = sessionFactory.getCurrentSession(); 
        Category cate = session.get(Category.class, id);
        if (cate != null) {
            Hibernate.initialize(cate.getProducts());
            products = cate.getProducts();
        }

        return products;
    }
}
