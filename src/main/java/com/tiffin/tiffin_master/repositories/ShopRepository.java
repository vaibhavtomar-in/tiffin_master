package com.tiffin.tiffin_master.repositories;

import com.tiffin.tiffin_master.entities.Cart;
import com.tiffin.tiffin_master.entities.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop,Integer> {
}
