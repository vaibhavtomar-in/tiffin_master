package com.tiffin.tiffin_master.controller;

import com.tiffin.tiffin_master.controller.dto.NewUserRequest;
import com.tiffin.tiffin_master.controller.dto.SuccessResponse;
import com.tiffin.tiffin_master.controller.dto.UserInfo;
import com.tiffin.tiffin_master.manager.UserManager;
import com.tiffin.tiffin_master.manager.data.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserManager userManager;

    @PostMapping("/connect")
    UserInfo register(HttpServletRequest request, @RequestBody NewUserRequest newUserRequest){
        com.tiffin.tiffin_master.manager.data.UserInfo userInfo = userManager.addUser(transform(newUserRequest));
        return transform(userInfo);
    }
    User transform(NewUserRequest webUser){
        User user = new User();
        user.setUserType(webUser.getType());
        user.setName(webUser.getName());
        user.setPassword(webUser.getPassword());
        user.setUsername(webUser.getUsername());
        user.setAction(webUser.getAction());
        if(webUser.getShopList() != null){
            List<NewUserRequest.Shop> shopList = webUser.getShopList();
            List<User.Shop> shops = new ArrayList<>();
            for (NewUserRequest.Shop shop : shopList){
                User.Shop shop1 = new User.Shop();
                shop1.setName(shop.getName());
                shop1.setAddress(shop.getAddress());
                shop1.setState(shop.getState());
                shop1.setCity(shop.getCity());
                shop1.setLatitude(shop.getLatitude());
                shop1.setLongitude(shop.getLongitude());
                shops.add(shop1);
            }
            user.setShopList(shops);
        }
        return user;
    }
    UserInfo transform(com.tiffin.tiffin_master.manager.data.UserInfo entity){
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(entity.getUserId());
        userInfo.setType(entity.getType());
        return userInfo;
    }

}
