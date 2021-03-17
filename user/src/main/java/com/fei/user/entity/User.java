package com.fei.user.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: zhangxinfei
 * create at:  2021/3/12  4:17 下午
 * @description: user entity
 */
@Data
@NoArgsConstructor
public class User {

    private String name;

    private Integer age;

    public User(String name, Integer age){
        this.name = name;
        this.age = age;
    }
}
