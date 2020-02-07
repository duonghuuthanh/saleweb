/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.saleweb.controller;

import com.dht.saleweb.model.User;
import com.dht.saleweb.service.UserService;
import com.dht.saleweb.validator.WebAppValidator;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author duonghuuthanh
 */
@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private WebAppValidator userValidator;
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(userValidator);
    }
    
    @GetMapping(value = "/login")
    public String loginView(Model model) {
        model.addAttribute("user", new User());

        return "login";
    }
    
    @GetMapping(value = "/register")
    public String registerView(Model model) {
        model.addAttribute("user", new User());
        
        return "register";
    }
    
    @PostMapping(value = "/register")
    public String registerProcess(@ModelAttribute(name = "user") @Valid User user, 
            BindingResult result) {
        if (result.hasErrors()) 
            return "register";
        
        userService.addUser(user);
        
        return "redirect:/login";
    }
}
