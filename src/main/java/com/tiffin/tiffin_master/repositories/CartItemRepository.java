package com.tiffin.tiffin_master.repositories;

import com.tiffin.tiffin_master.entities.CartItem;
import com.tiffin.tiffin_master.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem,Integer> {
}
