/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.waa.webstore.service.impl;

import edu.mum.waa.webstore.domain.Product;
import edu.mum.waa.webstore.repository.ProductRepository;
import edu.mum.waa.webstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 984986
 */
@Service
public class OrderServiceImpl implements OrderService {
    
    @Autowired
    private ProductRepository proRepo;

    @Override
    public void processOrder(String productId, int count) {
        Product product = proRepo.getProductById(productId);
        if(product !=null && product.getUnitsInStock()> count){
            product.setUnitsInOrder(count);
            product.setUnitsInStock(product.getUnitsInStock() - count);
        }
        else{
            throw new IllegalArgumentException();
        }
    }
    
}
