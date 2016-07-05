package com.raduq.shopping.service;

import com.raduq.shopping.model.CommerceItem;
import com.raduq.shopping.repository.CommerceItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Raduq on 04/07/2016.
 */
@Service
public class CommerceItemService {

    @Autowired
    private CommerceItemRepository repository;

    public CommerceItem save(CommerceItem item){
        return this.repository.save(item);
    }
}
