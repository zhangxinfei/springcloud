package com.fei.user.controller;

import com.fei.user.clients.ProductClients;
import com.fei.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: zhangxinfei
 * create at:  2021/3/5  5:21 下午
 * @description: 测试
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUser")
    public Object getUser(){
        return userService.getUser();
    }
}
