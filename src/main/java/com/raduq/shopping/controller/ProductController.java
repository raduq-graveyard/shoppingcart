package com.raduq.shopping.controller;

import com.raduq.shopping.model.Product;
import com.raduq.shopping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


/**
 * Created by Raduq on 04/07/2016.
 */
@Controller
@RequestMapping(value = "/store")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/products", produces = "application/json", method = RequestMethod.GET)
    public List<Product> products() {
        return productService.getProducts();
    }

    @RequestMapping(value = "/products/new", produces = "application/json", method = RequestMethod.POST)
    public Product newProduct(@RequestParam String name, @RequestParam String image, @RequestParam Long price){
        return productService.newProduct(name,image,price);
    }

}
