/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.saleweb.controller;

import com.dht.saleweb.model.Cart;
import com.dht.saleweb.service.OrderService;
import com.dht.saleweb.service.ProductService;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author duonghuuthanh
 */
@RestController
@RequestMapping(value = "/api/cart")
public class CartRestApiController {
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderService orderService;
    
    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public void addOrUpdate(HttpSession session,
            @RequestParam(value = "productId") int productId,
            @RequestParam(value = "num") int num) {
        Map<Integer, Cart> d;
        if (session.getAttribute("cart") == null) 
            d = new HashMap<>();
        else
            d = (Map<Integer, Cart>) session.getAttribute("cart");
        
        Cart c;
        if (d.containsKey(productId) == true) {
            c = d.get(productId);
            c.setNum(c.getNum() + 1);
        } else {
            c = new Cart(productService.getProductById(productId), num);
        }
        
        d.put(productId, c);
        
        session.setAttribute("cart", d);
    }
    
    @PostMapping(value = "/pay")
    @ResponseStatus(value = HttpStatus.OK)
    public void payCart(HttpSession session) {   
        Map<Integer, Cart> carts 
                = (Map<Integer, Cart>) session.getAttribute("cart");
        orderService.addOrder(carts.values());
        
        session.removeAttribute("cart");
    }
    
    @PostMapping(value = "/{productId}")
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@PathParam(value = "productId") String productId, 
            HttpSession session) {
        if (session.getAttribute(productId) != null)
            session.removeAttribute(productId);
    }
}
