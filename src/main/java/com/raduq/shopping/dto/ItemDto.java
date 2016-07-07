package com.raduq.shopping.dto;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by raduq on 07/07/16.
 */
@XmlRootElement
public class ItemDto implements Serializable {

    private String id;
    private String product_id;
    private String quantity;
    private String amount;

    public ItemDto() {
    }

    public ItemDto(String product_id, String quantity) {
        this.product_id = product_id;
        this.quantity = quantity;
    }

    public ItemDto(String id, String product_id, String quantity, String amount) {
        this.id = id;
        this.product_id = product_id;
        this.quantity = quantity;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
