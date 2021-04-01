package com.fei.user.utils;

import java.util.Map;

/**
 * @author: zhangxinfei
 * create at:  2021/4/1  5:10 下午
 * @description: 类加载器过程--Math
 */
public class Math {

    public static int initData = 0;

    public int compute(){
        int a = 1;
        int b = 2;
        int c = (a+b)*10;
        return c;
    }

    public static void main(String[] args) {
        Math math = new Math();
        math.compute();
    }
}
