package org.scut.java2022.oyz.controller;

import org.scut.java2022.oyz.dto.Result;
import org.scut.java2022.oyz.entity.User;
import org.scut.java2022.oyz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/user")
public class UserController {


    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public Result getUser(@RequestBody User user) {

        return userService.login(user);
    }

    @RequestMapping("/register")
    public Result register(@RequestBody User user) {
    	return userService.register(user);
    }
}
