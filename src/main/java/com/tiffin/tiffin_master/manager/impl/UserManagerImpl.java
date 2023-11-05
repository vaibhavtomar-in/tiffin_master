package com.tiffin.tiffin_master.manager.impl;

import com.tiffin.tiffin_master.manager.UserManager;
import com.tiffin.tiffin_master.manager.data.User;
import com.tiffin.tiffin_master.provider.UserProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManagerImpl implements UserManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserManagerImpl.class);
    @Autowired
    UserProvider userProvider;
    @Override
    public void addUser(User user) {
        if (!(user.getUserType().equals("SELLER") || user.getUserType().equals("CUSTOMER"))){
            LOGGER.info("badUserRequest");
            throw new RuntimeException("badUserRequest");
        }
        userProvider.addUser(user);

    }
}
