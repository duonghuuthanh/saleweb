/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.saleweb.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author duonghuuthanh
 */
public class Cart implements Serializable {
    private Product product;
    private int num;
    
    public Cart() {
        
    }
    
    public Cart(Product product) {
        this.product = product;
    }
    
    public Cart(Product product, int num) {
        this(product);
        this.num = num;
    }

    /**
     * @return the num
     */
    public int getNum() {
        return num;
    }

    /**
     * @param num the num to set
     */
    public void setNum(int num) {
        this.num = num;
    }

    /**
     * @return the product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(Product product) {
        this.product = product;
    }
    
    
}
