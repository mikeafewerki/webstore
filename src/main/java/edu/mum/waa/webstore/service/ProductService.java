/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.waa.webstore.service;

import edu.mum.waa.webstore.domain.Product;
import java.util.List;

/**
 *
 * @author 984986
 */
public interface ProductService {
    List <Product> getAllProducts();
    Product getProductById(String productId);
}
