package com.tiffin.tiffin_master.manager.impl;

import com.tiffin.tiffin_master.exception.LogitracError;
import com.tiffin.tiffin_master.exception.LogitrackException;
import com.tiffin.tiffin_master.manager.UserManager;
import com.tiffin.tiffin_master.manager.data.User;
import com.tiffin.tiffin_master.manager.data.UserInfo;
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
    public UserInfo addUser(User user) {
        if (user.getAction().equals("REGISTER") && user.getUserType() == null){
            LOGGER.info("badUserRequest");
            throw new LogitrackException(LogitracError.INVALID_INFO);
        }
        if (user.getAction().equals("REGISTER") && !(user.getUserType().equals("SELLER") || user.getUserType().equals("CUSTOMER"))){
            LOGGER.info("badUserRequest");
            throw new LogitrackException(LogitracError.INVALID_INFO);
        }
        if (user.getUsername().equals("")){
            throw new LogitrackException(LogitracError.USERNAME_INVALID);
        }
        User user1 = userProvider.getUser(user);
        if(user1 == null && user.getAction().equals("REGISTER")){
            return userProvider.addUser(user);
        } else if (user1 == null && user.getAction().equals("LOGIN")) {
            throw new LogitrackException(LogitracError.USERNAME_DOES_NOT_EXIST);
        } else if (user1.getUsername().equals(user.getUsername()) && !user1.getPassword().equals(user.getPassword()) && user.getAction().equals("LOGIN")) {
            throw new LogitrackException(LogitracError.PASSWORD_INCORRECT);
        }else if (user1.getUsername().equals(user.getUsername()) && user.getAction().equals("REGISTER")) {
            throw new LogitrackException(LogitracError.USERNAME_UNAVAILABLE);
        } else if (user.getShopList() == null && user.getAction().equals("REGISTER")) {
            throw new LogitrackException(LogitracError.SHOP_LIST_ABSENT);
        } else if(user1.getUsername().equals(user.getUsername()) && user1.getPassword().equals(user.getPassword()) && user.getAction().equals("LOGIN")){
            UserInfo info = new UserInfo();
            info.setUserId(user1.getUserId());
            info.setType(user1.getUserType());
            return info;
        }
        return null;
    }
}
