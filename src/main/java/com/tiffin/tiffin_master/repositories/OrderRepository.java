package com.tiffin.tiffin_master.repositories;

import com.tiffin.tiffin_master.entities.Order;
import com.tiffin.tiffin_master.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {
}
