package com.tiffin.tiffin_master.repositories;

import com.tiffin.tiffin_master.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    @Query("select u from User u where u.name = :username")
    User getUser(String username);
}
