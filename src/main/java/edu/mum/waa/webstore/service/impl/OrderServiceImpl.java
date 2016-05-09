/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.waa.webstore.service.impl;

import edu.mum.waa.webstore.domain.Product;
import edu.mum.waa.webstore.service.OrderService;
import edu.mum.waa.webstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 984986
 */
@Service
public class OrderServiceImpl implements OrderService {
    
    @Autowired
    private ProductService proService;

    @Override
    public void processOrder(String productId, int count) {
        Product product = proService.getProductById(productId);
        if(product !=null && product.getUnitsInStock()> count){
            product.setUnitsInOrder(count);
            product.setUnitsInStock(product.getUnitsInStock() - count);
        }
        else{
            throw new IllegalArgumentException();
        }
    }
    
}
