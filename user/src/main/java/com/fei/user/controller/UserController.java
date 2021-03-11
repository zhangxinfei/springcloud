package com.fei.user.controller;

import com.fei.user.clients.ProductClients;
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

    @Resource
    private ProductClients productClients;

    @GetMapping("/getUser")
    public Object getUser(){
        return productClients.getProduct();
    }
}
