package com.raduq.shopping.controller;

import com.raduq.shopping.dto.ProductDto;
import com.raduq.shopping.model.Product;
import com.raduq.shopping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public List<ProductDto> products() {
        return productService.getProducts();
    }

    @RequestMapping(value = "/products/new", produces = "application/json", method = RequestMethod.POST)
    @ResponseBody
    public ProductDto newProduct(@RequestBody ProductDto productDto){
        return productService.newProduct(productDto.getName(), productDto.getImage(),Long.valueOf(productDto.getPrice()));
    }

}
