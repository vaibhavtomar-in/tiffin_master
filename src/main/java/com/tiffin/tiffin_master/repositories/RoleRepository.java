package com.tiffin.tiffin_master.repositories;

import com.tiffin.tiffin_master.entities.Role;
import com.tiffin.tiffin_master.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Integer> {
}
