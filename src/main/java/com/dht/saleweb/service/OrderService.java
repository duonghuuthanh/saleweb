/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.saleweb.service;

import com.dht.saleweb.model.Cart;
import java.util.Collection;

/**
 *
 * @author duonghuuthanh
 */
public interface OrderService {
    void addOrder(Collection<Cart> carts);
}
