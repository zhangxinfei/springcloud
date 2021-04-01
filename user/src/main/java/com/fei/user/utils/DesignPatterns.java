package com.fei.user.utils;

import com.fei.user.entity.User;

/**
 * @author: zhangxinfei
 * create at:  2021/3/24  7:15 下午
 * @description: 设计模式
 */
public class DesignPatterns {

    //单例模式--共享数据
    //volatile 防止指令重排序 new对象不是原子操作
    private volatile static User commonData;

    /**
     * @Des 单例模式 ---- 双重锁定
     * @Date 2021/3/24 7:16 下午
     * @Param
     * @Return
     */
    public static User Singleton1(){
        if (commonData == null){
            synchronized (commonData){
                if (commonData == null){
                    commonData = new User();
                    /**
                     * 使用volatile是为了防止指令重排：
                     * 原因
                     * commonData = new User(); 一共分为三步
                     * 1. 申请内存空间
                     * 2. 实例化对象     new User()
                     * 3. 数据赋值       =
                     * 这三步没法保证原子性，
                     */
                }
            }
        }
        return commonData;
    }

    /**
     * @Des 单例模式 ---- 懒汉式
     * @Date 2021/3/24 7:19 下午
     * @Param
     * @Return
     */
    public static User Singleton2(){
        if (commonData == null){
            commonData = new User();
        }
        return commonData;
    }

    


}

/**
 * @Des: 设计模式 -- 饿汉式
 * @Author: zhangxinfei
 * @Date: 2021/3/24 7:26 下午
 */
class Singleton {
    private static User commData = new User();
    
    /**
     * @Des 设计模式 ---- 饿汉式
     * @Date 2021/3/24 7:25 下午
     * @Param 
     * @Return 
     */
    public static User getCommData(){
        return commData;
    }
}
