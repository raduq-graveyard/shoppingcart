package com.raduq.shopping.service;

import com.raduq.shopping.model.Product;
import com.raduq.shopping.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Raduq on 04/07/2016.
 */
@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    /** Find all the products **/
    public List<Product> getProducts(){
        List<Product> products = new ArrayList<>();
        products = repository.findAll();
        return products;
    }

    public Product getProduct(Long product_id) {
        return repository.getOne(product_id);
    }

    public Product newProduct(String name, String image, Long price) {
        Product newProduct = new Product();
        newProduct.setName(name);
        newProduct.setImage(image);
        newProduct.setPrice(new BigDecimal(price));
        return repository.save(newProduct);
    }
}
