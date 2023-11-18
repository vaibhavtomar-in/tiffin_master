package com.tiffin.tiffin_master.manager.impl;

import com.tiffin.tiffin_master.manager.UserManager;
import com.tiffin.tiffin_master.manager.data.User;
import com.tiffin.tiffin_master.manager.data.UserInfo;
import com.tiffin.tiffin_master.provider.UserProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserManagerImpl implements UserManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserManagerImpl.class);
    @Autowired
    UserProvider userProvider;
    @Override
    public UserInfo addUser(User user) {
        if (!(user.getUserType().equals("SELLER") || user.getUserType().equals("CUSTOMER"))){
            LOGGER.info("badUserRequest");
            throw new RuntimeException("badUserRequest");
        }
        if (user.getUsername().equals("")){
            throw new RuntimeException("ENTER VALID USERNAME");
        }
        User user1 = userProvider.getUser(user);
        if(user1 == null && user.getAction().equals("REGISTER")){
            return userProvider.addUser(user);
        } else if (user1 == null && user.getAction().equals("LOGIN")) {
            throw new RuntimeException("USERNAME DOES NOT EXIST");
        } else if (user1.getUsername().equals(user.getUsername()) && !user1.getPassword().equals(user.getPassword()) && user.getAction().equals("LOGIN")) {
            throw new RuntimeException("PASSWORD INCORRECT");
        }else if (user1.getUsername().equals(user.getUsername()) && user.getAction().equals("REGISTER")) {
            throw new RuntimeException("USERNAME NOT AVAILABLE");
        }else if(user1.getUsername().equals(user.getUsername()) && user1.getPassword().equals(user.getPassword()) && user.getAction().equals("LOGIN")){
            UserInfo info = new UserInfo();
            info.setUserId(user1.getUserId());
            info.setType(user1.getUserType());
            return info;
        }
        return null;
    }
}
