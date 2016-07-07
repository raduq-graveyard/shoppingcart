package com.raduq.shopping.service;

import com.raduq.shopping.dto.ProductDto;
import com.raduq.shopping.model.Product;
import com.raduq.shopping.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * This service is responsible for maintaining the products.
 * Created by Raduq on 04/07/2016.
 */
@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    /** Find all the products **/
    public List<ProductDto> getProducts(){
        return repository.findAll()
                .stream().map(p -> new ProductDto(p.getId().toString(), p.getName(), p.getImage(), p.getPrice().toString()))
                .collect(Collectors.toList());
    }

    /** Get a specific product by Id **/
    public Product getProduct(Long product_id) {
        return repository.getOne(product_id);
    }

    /** Create a new product **/
    public ProductDto newProduct(String name, String image, Long price) {
        Product newProduct = new Product();
        newProduct.setName(name);
        newProduct.setImage(image);
        newProduct.setPrice(new BigDecimal(price));
        newProduct = repository.save(newProduct);
        return new ProductDto(newProduct.getId().toString(), name,image,price.toString());
    }
}
