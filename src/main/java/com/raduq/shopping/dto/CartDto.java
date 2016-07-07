package com.raduq.shopping.dto;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by raduq on 07/07/16.
 */
@XmlRootElement
public class CartDto implements Serializable{

    private List<ItemDto> items;
    private String amount;

    public CartDto() {
        this.items = new ArrayList<>();
    }

    public CartDto(List<ItemDto> items, String amount) {
        this.items = items;
        this.amount = amount;
    }

    public List<ItemDto> getItems() {
        return items;
    }

    public void setItems(List<ItemDto> items) {
        this.items = items;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
