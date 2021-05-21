package com.fei.user.study.jvm;

import com.fei.user.entity.User;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: zhangxinfei
 * create at:  2021/4/1  5:10 下午
 * @description: 类加载器过程--Math
 */
public class Math {

    public static int initData = 666;
    public static User user = new User();

    public int compute(){
        int a = 1;
        int b = 2;
        int c = (a+b)*10;
        return c;
    }

    public static void main(String[] args) {
        Math math = new Math();
        math.compute();
        initData = initData + 1;
    }
}
