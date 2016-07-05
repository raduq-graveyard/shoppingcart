package com.raduq.shopping.repository;

import com.raduq.shopping.model.CommerceItem;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Raduq on 04/07/2016.
 */
public interface CommerceItemRepository extends JpaRepository<CommerceItem, Long> {
}
