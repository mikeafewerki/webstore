/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.waa.webstore.repository.impl;

import edu.mum.waa.webstore.domain.Product;
import edu.mum.waa.webstore.repository.ProductRepository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 984986
 */
@Repository
public class InMemoryProdudctRepository implements ProductRepository{

    private List<Product> listOfProducts;

    public InMemoryProdudctRepository() {
        this.listOfProducts = new ArrayList<Product>();
        
        Product product1 = new Product();
        product1.setProductId("11");
        product1.setName("Jeans");
        product1.setUnitPrice(new BigDecimal(30));
        product1.setUnitsInStock(10);
        product1.setDescription("The latest fashion Jeans.");
        
        Product product2 = new Product();
        product2.setProductId("22");
        product2.setName("Shirt");
        product2.setUnitPrice(new BigDecimal(40));
        product2.setUnitsInStock(10);
        product2.setDescription("Slim fit shirts");
         
        Product product3 = new Product();
        product3.setProductId("33");
        product3.setName("Skirt");
        product3.setUnitPrice(new BigDecimal(50));
        product3.setUnitsInStock(10);
        product3.setDescription("Made in China");
        
        this.listOfProducts.add(product1);
        this.listOfProducts.add(product2);
        this.listOfProducts.add(product3);
    }
   
    @Override
    public List<Product> getAllProducts() {
        
        return listOfProducts;
    }

    @Override
    public Product getProductById(String productId) {
        for(Product p : listOfProducts)
            if(p.getProductId().equals(productId)){
                return p;
            }
        return null;
    }
    
}
