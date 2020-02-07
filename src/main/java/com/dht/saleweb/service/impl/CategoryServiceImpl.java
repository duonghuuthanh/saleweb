/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.saleweb.service.impl;

import com.dht.saleweb.model.Category;
import com.dht.saleweb.model.Product;
import com.dht.saleweb.repository.CategoryRepository;
import com.dht.saleweb.service.CategoryService;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author duonghuuthanh
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Category> getCategories() {
        return categoryRepository.getCategories("");
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> getProductsByCategory(int cateId) {
        return categoryRepository.getProductsByCategory(cateId);
    }
}
