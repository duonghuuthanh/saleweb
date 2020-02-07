/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.saleweb.validator;

import com.dht.saleweb.model.Product;
import java.math.BigDecimal;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author duonghuuthanh
 */
@Component
public class PriceValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Product.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Product product = (Product) target;
       
        // Máy tính xách tay trong CSDL hiện tại đang có id là 3
        if (product.getCategory().getId() == 3 &&  
            product.getPrice().compareTo(new BigDecimal(5000000)) < 0)
            errors.rejectValue("price", "product.price.error.priceValidatorMsg");
    }    
}
