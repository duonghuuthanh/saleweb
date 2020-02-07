/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.saleweb.controller;

import com.dht.saleweb.model.Cart;
import com.dht.saleweb.model.Product;
import com.dht.saleweb.service.CategoryService;
import com.dht.saleweb.service.ProductService;
import com.dht.saleweb.validator.WebAppValidator;
import java.math.BigDecimal;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author duonghuuthanh
 */
@Controller
@ControllerAdvice
public class ProductController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;
    @Autowired
    private WebAppValidator productValidator;
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(productValidator);
    }
    
    @ModelAttribute
    public void addAttributes(HttpSession session, Model model) {
        int count = 0;
        
        if (session.getAttribute("cart") != null) {
            Map<Integer, Cart> carts = (Map<Integer, Cart>) session.getAttribute("cart");
            for (Cart c: carts.values())
                count += c.getNum();
        }
        
        model.addAttribute("cartCount", count);
    }
    
    @RequestMapping(value = "/")
    public ModelAndView index(@RequestParam(value = "cat_id", defaultValue = "") String cateId,
            @RequestParam(value = "kw", defaultValue = "") String kw) {
        ModelAndView view = new ModelAndView();
        view.setViewName("index");
        view.addObject("categories", categoryService.getCategories());
        if (cateId.isEmpty())
            view.addObject("products", productService.getProducts(kw));
        else
            view.addObject("products", 
                    categoryService.getProductsByCategory(Integer.parseInt(cateId)));
        
        return view;
    }
    
    @GetMapping(value = "/cart")
    public String cart(Model model, HttpSession session) {
        if (session.getAttribute("cart") != null) {
            Map<Integer, Cart> carts = (Map<Integer, Cart>) session.getAttribute("cart");

            BigDecimal sum = new BigDecimal(0);
            
            for (Cart c: carts.values())
                sum = sum.add(c.getProduct()
                               .getPrice()
                               .multiply(new BigDecimal(c.getNum())));

            model.addAttribute("carts", carts.values());
            model.addAttribute("sum", sum);
        }

        return "cart";
    }
    
    @GetMapping(value = "/products/{product_id}")
    public ModelAndView detail(@PathVariable(value = "product_id") int productId) {
        ModelAndView view = new ModelAndView();
        view.setViewName("detail");
        view.addObject("product", productService.getProductById(productId));
        
        return view;
    }
    
    @GetMapping(value = "/products/add")
    public String addProductView(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryService.getCategories());
        
        return "add-product";
    }
    
    @PostMapping(value = "/products/add")
    public String addProductProcess(Model model, 
            @ModelAttribute(value = "product") @Valid Product product, 
            BindingResult result, HttpServletRequest request) {
        if(result.hasErrors()) {
            model.addAttribute("categories", categoryService.getCategories());

            return "add-product";
        }

        String rootDir = request.getSession()
                                .getServletContext().getRealPath("/");

        productService.addProduct(product, rootDir);
        return "redirect:/";
    }
}
