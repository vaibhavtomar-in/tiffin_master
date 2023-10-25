package com.tiffin.tiffin_master.repositories;

import com.tiffin.tiffin_master.entities.Cart;
import com.tiffin.tiffin_master.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Integer> {
}
