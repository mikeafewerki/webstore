/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.waa.webstore.controller;

import edu.mum.waa.webstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author 984986
 */
@Controller
public class OrderController {
    
    @Autowired
    private OrderService orderService;
    
    @RequestMapping("/order/{productId}/{count}")
    public String processOrder(@PathVariable String productId, @PathVariable("count") int quantity, Model model){
        orderService.processOrder(productId, quantity);
        return "redirect:/products";
    }
}
