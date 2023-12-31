package com.csx.cxy.controller;

import com.csx.cxy.annotation.NoRepeatSubmit;
import com.csx.cxy.common.R;
import com.csx.cxy.entity.User;
import com.csx.cxy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @NoRepeatSubmit
    @GetMapping("getUserInfo")
    public R getUserInfo(@RequestParam String  userId){
        return R.SUCCESS(userService.getUserInfo(userId));
    }


}
