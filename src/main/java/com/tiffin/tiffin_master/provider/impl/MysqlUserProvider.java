package com.tiffin.tiffin_master.provider.impl;

import com.tiffin.tiffin_master.manager.data.User;
import com.tiffin.tiffin_master.provider.UserProvider;
import com.tiffin.tiffin_master.repositories.RoleRepository;
import com.tiffin.tiffin_master.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MysqlUserProvider implements UserProvider {
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRepository userRepository;
    @Override
    public void addUser(User user) {
        com.tiffin.tiffin_master.entities.User newUser = new com.tiffin.tiffin_master.entities.User();
        newUser.setName(user.getName());
        newUser.setPassword(user.getPassword());
        newUser.setUsername(user.getUsername());
        newUser.setCreatedAt(LocalDateTime.now());
        newUser.setLastUpdatedAt(LocalDateTime.now());
        newUser.setRole(roleRepository.getRoles(user.getUserType()));
        userRepository.save(newUser);
    }
}
