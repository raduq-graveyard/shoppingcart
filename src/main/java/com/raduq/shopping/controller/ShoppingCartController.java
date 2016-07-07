package com.raduq.shopping.controller;

import com.raduq.shopping.dto.CartDto;
import com.raduq.shopping.dto.ItemDto;
import com.raduq.shopping.model.CommerceItem;
import com.raduq.shopping.model.ShoppingCart;
import com.raduq.shopping.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Raduq on 04/07/2016.
 */
@RestController
@RequestMapping(value = "/cart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @RequestMapping(value = "/shoppingcart", produces = "application/json", method = RequestMethod.GET)
    public ResponseEntity<CartDto> shoppingCart(){
        return ResponseEntity.ok(shoppingCartService.getShoppingCart().toDto());
    }

    @RequestMapping(value = "/shoppingcart/items/{id}", produces = "application/json", method = RequestMethod.DELETE)
    public void deleteItem(@PathVariable("id") String id){
        shoppingCartService.deleteItem(Long.valueOf(id));
    }

    @RequestMapping(value = "/shoppingcart/items", produces = "application/json", method = RequestMethod.POST)
    public ResponseEntity<ItemDto> addItem(@RequestBody ItemDto item){
        return ResponseEntity.ok(shoppingCartService.addItem(Long.parseLong(item.getProduct_id()),Integer.parseInt(item.getQuantity())));
    }
}
