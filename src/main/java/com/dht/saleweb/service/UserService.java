/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.saleweb.service;

import com.dht.saleweb.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author duonghuuthanh
 */
public interface UserService extends UserDetailsService {
    void addUser(User user);
    User getUserByUsername(String username);
}
