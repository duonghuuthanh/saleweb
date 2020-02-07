/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.saleweb.validator;

import com.dht.saleweb.service.ProductService;
import javax.persistence.NoResultException;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author duonghuuthanh
 */
public class ProductNameValidator implements ConstraintValidator<ProductName, String> {
    @Autowired
    private ProductService productService;

    @Override
    public void initialize(ProductName constraintAnnotation) {
        
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        try {
            return productService.checkProductName(value);
        } catch (NoResultException ex) {
            return false;
        }
    }
}
