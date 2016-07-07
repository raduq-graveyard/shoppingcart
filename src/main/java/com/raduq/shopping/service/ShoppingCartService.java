package com.raduq.shopping.service;

import com.raduq.shopping.dto.ItemDto;
import com.raduq.shopping.model.CommerceItem;
import com.raduq.shopping.model.Product;
import com.raduq.shopping.model.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Raduq on 04/07/2016.
 */
@Service
public class ShoppingCartService {

    @Autowired
    private ProductService productService;
    @Autowired
    private CommerceItemService commerceItemService;

    private ShoppingCart shoppingCart;

    public ShoppingCart getShoppingCart() {
        if (this.shoppingCart == null) {
            this.shoppingCart = new ShoppingCart();
        }
        return this.shoppingCart;
    }

    public void deleteItem(Long id) {
        getShoppingCart().removeItem(id);
    }

    public ItemDto addItem(Long product_id, Integer quantity) {
        Product product = productService.getProduct(product_id);
        CommerceItem item = commerceItemService.save(new CommerceItem(product,quantity));
        getShoppingCart().addItem(item);
        return item.toDto();
    }
}
