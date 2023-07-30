package com.csx.cxy.controller;

import com.csx.cxy.entity.User;
import com.csx.cxy.service.UserService;
import com.sun.org.apache.xerces.internal.impl.xpath.XPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("getUserInfo/{userId}")
    public User getUserInfo(@PathVariable Integer userId){
        return userService.getUserInfo(userId);
    }


}
