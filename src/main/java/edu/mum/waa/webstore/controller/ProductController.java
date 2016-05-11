/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.waa.webstore.controller;

import edu.mum.waa.webstore.domain.Product;
import edu.mum.waa.webstore.service.impl.ProductServiceImpl;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author 984986
 */
@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductServiceImpl proService;

    //prodiuctService
    @RequestMapping
    public String productList(Model model) {

        model.addAttribute("products", proService.getAllProducts());

        return "products";
    }

    @RequestMapping("/product")
    public String getProductById(@RequestParam("id") String productId, Model model) {
        model.addAttribute("product", proService.getProductById(productId));
        return "product";
    }

    @RequestMapping("/all")
    public String allProducts(Model model) {
        model.addAttribute("products", proService.getAllProducts());
        return "products";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddNewProductForm(Model model) {
        Product product = new Product();
        model.addAttribute("newProduct", product);
        return "addProduct";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddNewProductForm(@ModelAttribute("newProduct") Product newProduct, BindingResult result) {

        String[] suppressedFields = result.getSuppressedFields();
        if (suppressedFields.length > 0) {
            throw new RuntimeException("Attempting to bind disallowed fields: " + StringUtils.arrayToCommaDelimitedString(suppressedFields));
        }

        proService.addProduct(newProduct);
        return "redirect:/products";
    }

    @InitBinder
    public void initialiseBinder(WebDataBinder binder) {
        binder.setDisallowedFields("unitsInOrder", "discontinued");
    }
}
