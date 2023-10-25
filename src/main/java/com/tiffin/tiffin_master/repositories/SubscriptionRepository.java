package com.tiffin.tiffin_master.repositories;

import com.tiffin.tiffin_master.entities.Subscription;
import com.tiffin.tiffin_master.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription,Integer> {
}
