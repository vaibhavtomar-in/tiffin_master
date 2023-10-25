package com.tiffin.tiffin_master.repositories;

import com.tiffin.tiffin_master.entities.Dish;
import com.tiffin.tiffin_master.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishRepository extends JpaRepository<Dish,Integer> {
}
