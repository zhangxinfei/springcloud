package com.fei.user.entity;

import lombok.Data;

/**
 * @author: zhangxinfei
 * create at:  2021/3/12  4:17 下午
 * @description: user entity
 */
@Data
public class User1 {

    static {
        System.out.println("执行User静态代码");
    }

    private String name;

    private Integer age;

    public User1(String name, Integer age){
        this.name = name;
        this.age = age;
    }

    public User1(){
        sout();
    }
    public void sout(){
        System.out.println("执行User方法");
    }
}
