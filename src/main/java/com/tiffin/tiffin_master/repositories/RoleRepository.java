package com.tiffin.tiffin_master.repositories;

import com.tiffin.tiffin_master.entities.Role;
import com.tiffin.tiffin_master.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
    @Query("select r from Role r where r.name = :role")
    Role getRoles(String role);
}
