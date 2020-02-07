/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.saleweb.service.impl;

import com.dht.saleweb.model.Product;
import com.dht.saleweb.repository.ProductRepository;
import com.dht.saleweb.service.ProductService;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author duonghuuthanh
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    
    @Override
    @Transactional(readOnly = true)
    public List<Product> getProducts(String kw) {
        return productRepository.getProducts(kw);
    }

    @Override
    @Transactional(readOnly = true)
    public Product getProductById(int productId) {
        return productRepository.getProductById(productId);
    }

    @Override
    @Transactional
    public void addProduct(Product product, String rootDir) {
        MultipartFile img = product.getImgFile();
        if (img != null && !img.isEmpty()) {
            product.setImage("/images/uploads/" + img.getOriginalFilename());
            try {
                img.transferTo(new File(rootDir + "resources" + product.getImage()));
                productRepository.addProduct(product);
            } catch (IOException | IllegalStateException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }

    @Override
    @Transactional(readOnly = true)
    public boolean checkProductName(String productName) {
        return productRepository.checkProductName(productName);
    }
}
