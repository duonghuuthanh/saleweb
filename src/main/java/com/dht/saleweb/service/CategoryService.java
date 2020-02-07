/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.saleweb.service;

import com.dht.saleweb.model.Category;
import com.dht.saleweb.model.Product;
import java.util.List;

/**
 *
 * @author duonghuuthanh
 */
public interface CategoryService {
    List<Category> getCategories();
    List<Product> getProductsByCategory(int cateId);
}
