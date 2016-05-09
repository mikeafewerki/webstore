/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.waa.webstore.controller;

import edu.mum.waa.webstore.domain.Product;
import edu.mum.waa.webstore.repository.ProductRepository;
import edu.mum.waa.webstore.service.impl.ProductServiceImpl;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author 984986
 */
@Controller
public class ProductController {
    
    @Autowired
    private ProductServiceImpl proService;
    //prodiuctService
    @RequestMapping("/products")
    public String productList(Model model){
        //Product product = new Product("12","iPhone", new BigDecimal(32));
//        product.setCategory("cloths");
//        product.setDescription("men's jeans");
//        product.setManufacturer("columbia");
//        product.setUnitsInStock(20);
        
        model.addAttribute("products", proService.getAllProducts());
        
        return "products";
    }
    
    @RequestMapping("/product")
    public String getProductById(@RequestParam("id") String productId, Model model){
        model.addAttribute("product", proService.getProductById(productId));
        return "product";
    }
}
