package com.tiffin.tiffin_master.provider;

import com.tiffin.tiffin_master.manager.data.User;
import com.tiffin.tiffin_master.manager.data.UserInfo;

public interface UserProvider {
    UserInfo addUser(User user);
    User getUser(User user);
}
