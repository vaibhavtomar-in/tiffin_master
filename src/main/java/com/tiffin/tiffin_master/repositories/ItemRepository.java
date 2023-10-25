package com.tiffin.tiffin_master.repositories;

import com.tiffin.tiffin_master.entities.Item;
import com.tiffin.tiffin_master.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Integer> {
}
