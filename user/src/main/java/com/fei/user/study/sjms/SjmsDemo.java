package com.fei.user.study.sjms;

import lombok.Synchronized;

/**
 * @author: zhangxinfei
 * create at:  2021/5/13  7:04 下午
 * @description: 设计模式举例
 */
public class SjmsDemo {


    public static void main(String[] args) {
        //这个在单线程下可以正常使用
//        LazySingleton instance = LazySingleton.getInstance();
//        LazySingleton instance1 = LazySingleton.getInstance();
//        System.out.println(instance == instance1);

        new Thread(()->{
            LazySingleton instance = LazySingleton.getInstance();
            System.out.println(instance);
        }).start();

        new Thread(()->{
            LazySingleton instance = LazySingleton.getInstance();
            System.out.println( instance);
        }).start();
    }
}

//单例模式--懒汉式
class LazySingleton{

    //加上volatile防止指令重排
    private volatile static LazySingleton instance;
    private LazySingleton(){

    }

    //这个在单线程下可以正常使用
    public static LazySingleton getInstance(){
        if (instance == null){
            //多线程下加锁使用
            synchronized(LazySingleton.class){
                //防止在多线程下并发进入到 if (instance == null)，这个时候就需要再进行一次判断
                if (instance == null){
                    instance = new LazySingleton();
                }
            }

        }
        return instance;
    }
}