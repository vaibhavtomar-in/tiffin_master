package com.tiffin.tiffin_master.controller;

import com.tiffin.tiffin_master.controller.dto.NewUserRequest;
import com.tiffin.tiffin_master.controller.dto.SuccessResponse;
import com.tiffin.tiffin_master.manager.UserManager;
import com.tiffin.tiffin_master.manager.data.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserManager userManager;

    @PostMapping("/add")
    SuccessResponse register(HttpServletRequest request, @RequestBody NewUserRequest newUserRequest){
        userManager.addUser(transform(newUserRequest));
        return new SuccessResponse("user added");
    }
    User transform(NewUserRequest webUser){
        User user = new User();
        user.setUserType(webUser.getType());
        user.setName(webUser.getName());
        user.setPassword(webUser.getPassword());
        user.setUsername(webUser.getUsername());
        return user;
    }
}
