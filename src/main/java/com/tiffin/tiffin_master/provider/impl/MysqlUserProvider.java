package com.tiffin.tiffin_master.provider.impl;

import com.tiffin.tiffin_master.entities.Shop;
import com.tiffin.tiffin_master.manager.data.User;
import com.tiffin.tiffin_master.manager.data.UserInfo;
import com.tiffin.tiffin_master.provider.UserProvider;
import com.tiffin.tiffin_master.repositories.RoleRepository;
import com.tiffin.tiffin_master.repositories.ShopRepository;
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
    @Autowired
    ShopRepository shopRepository;
    @Override
    public UserInfo addUser(User user) {
        com.tiffin.tiffin_master.entities.User newUser = new com.tiffin.tiffin_master.entities.User();
        newUser.setName(user.getName());
        newUser.setPassword(user.getPassword());
        newUser.setUsername(user.getUsername());
        newUser.setCreatedAt(LocalDateTime.now());
        newUser.setLastUpdatedAt(LocalDateTime.now());
        newUser.setRole(roleRepository.getRoles(user.getUserType()));
        userRepository.save(newUser);
        for(User.Shop shop : user.getShopList()){
            Shop entity = new Shop();
            entity.setName(shop.getName());
            entity.setAddress(shop.getAddress());
            entity.setState(shop.getState());
            entity.setCity(shop.getCity());
            entity.setLatitude(shop.getLatitude());
            entity.setLongitude(shop.getLongitude());
            shopRepository.save(entity);
        }
        UserInfo info = new UserInfo();
        info.setUserId(newUser.getId());
        info.setType(newUser.getRole().getName());
        return info;
    }

    @Override
    public User getUser(User user) {
        com.tiffin.tiffin_master.entities.User user1 = userRepository.getUser(user.getUsername());
        if (user1 == null){
            return null;
        }else{
            return transform(user1);
        }
    }
    User transform(com.tiffin.tiffin_master.entities.User entity){
        User user = new User();
        user.setUserId(entity.getId());
        user.setUsername(entity.getUsername());
        user.setName(entity.getName());
        user.setPassword(entity.getPassword());
        user.setUserType(entity.getRole().getName());
        return user;
    }
}
