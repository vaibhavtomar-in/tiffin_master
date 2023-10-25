package com.tiffin.tiffin_master.repositories;

import com.tiffin.tiffin_master.entities.SellerLocation;
import com.tiffin.tiffin_master.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerLocationRepository extends JpaRepository<SellerLocation,Integer> {
}
