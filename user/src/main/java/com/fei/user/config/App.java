package com.fei.user.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: zhangxinfei
 * create at:  2021/8/6  3:56 下午
 * @description:
 */
public class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfig.class);
        System.out.println(ctx.getBean("user"));
    }
}
