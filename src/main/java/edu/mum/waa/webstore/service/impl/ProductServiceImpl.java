/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.waa.webstore.service.impl;

import edu.mum.waa.webstore.domain.Product;
import edu.mum.waa.webstore.repository.ProductRepository;
import edu.mum.waa.webstore.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 984986
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository proRepo;
    
    @Override
    public List<Product> getAllProducts() {
        return proRepo.getAllProducts();
    }
    
}
