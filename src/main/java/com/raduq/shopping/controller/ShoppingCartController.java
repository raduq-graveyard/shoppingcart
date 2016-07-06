package com.raduq.shopping.controller;

import com.raduq.shopping.model.CommerceItem;
import com.raduq.shopping.model.ShoppingCart;
import com.raduq.shopping.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Raduq on 04/07/2016.
 */
@Controller
@RequestMapping(value = "/cart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @RequestMapping(value = "/shoppingcart", produces = "application/json", method = RequestMethod.GET)
    public ShoppingCart shoppingCart(){
        return shoppingCartService.getShoppingCart();
    }

    @RequestMapping(value = "/shoppingcart/items/{id}", produces = "application/json", method = RequestMethod.DELETE)
    public void deleteItem(@PathVariable("id") Long id){
        shoppingCartService.deleteItem(id);
    }

    @RequestMapping(value = "/shoppingcart/items", produces = "application/json", method = RequestMethod.POST)
    public CommerceItem addItem(@RequestParam Long product_id,@RequestParam Integer quantity){
        return shoppingCartService.addItem(product_id,quantity);
    }
}
