package com.tiffin.tiffin_master.repositories;

import com.tiffin.tiffin_master.entities.ItemDay;
import com.tiffin.tiffin_master.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemDayRepository extends JpaRepository<ItemDay,Integer> {
}
