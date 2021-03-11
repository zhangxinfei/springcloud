package com.fei.product.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: zhangxinfei
 * create at:  2021/3/5  5:28 下午
 * @description: product
 */
@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Value("${server.port}")
    private String port;

    @GetMapping(value = "/getProduct")
    public Map<String,Object> getProduct(){
        System.out.println("进入商品服务=====" + port);
        Map<String,Object> map = new HashMap();
        map.put("name","苹果");
        map.put("price",50);
        return map;
    }
}
