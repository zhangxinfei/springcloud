package com.fei.product.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: zhangxinfei
 * create at:  2021/3/11  10:54 上午
 * @description: nacos confiig test
 */
@RefreshScope
@RestController
public class TestConfigController {

//    @Value("${name}")
//    private String name;
//
//    @GetMapping(value = "/test")
//    public String test(){
//        return name;
//    }
}
