package com.raduq.shopping.dto;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Raduq on 06/07/2016.
 */
@XmlRootElement
public class ProductsDto implements Serializable{

    private List<ProductDto> products;

    public ProductsDto() {
        products = new ArrayList<>();
    }

    public ProductsDto(List<ProductDto> products) {
        this.products = products;
    }

    public List<ProductDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDto> products) {
        this.products = products;
    }
}
