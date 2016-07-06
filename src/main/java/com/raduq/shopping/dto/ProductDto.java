package com.raduq.shopping.dto;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by Raduq on 06/07/2016.
 */
@XmlRootElement
public class ProductDto implements Serializable{

    private String id;
    private String name;
    private String image;
    private String price;

    public ProductDto() {
    }

    public ProductDto(String name, String image, String price) {
        this.name = name;
        this.image = image;
        this.price = price;
    }

    public ProductDto(String id,String name, String image, String price) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
