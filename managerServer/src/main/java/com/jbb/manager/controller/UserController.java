package com.jbb.manager.controller;

import com.jbb.manager.service.UserService;
import com.jbb.manager.util.TableResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserController
 * @Author 金斌斌
 * @Description
 * @Date 2018-07-23 16:00
 **/
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("a")
    public String test() {
        return "a";
    }

    @PostMapping("userList")
    public TableResult userList(@RequestBody TableResult result) {
        return userService.userList(result);
    }
}
