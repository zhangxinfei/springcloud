package com.fei.user.study.sjms;

/**
 * @author: zhangxinfei
 * create at:  2021/5/17  4:52 下午
 * @description:
 */
public class HungrySingletonTest {

    public static void main(String[] args) {
        HungrySingleton instance = HungrySingleton.getInstance();
        HungrySingleton instance1 = HungrySingleton.getInstance();
        System.out.println(instance==instance1);
    }
}

/**
 * @Des 单例模式--饿汉式
 * @Date 2021/5/17 4:54 下午
 * @Param 
 * @Return 
 */
class HungrySingleton {
    private static HungrySingleton instance = new HungrySingleton();
    
    private HungrySingleton(){
        
    }
    
    public static HungrySingleton getInstance(){
        return instance;
    }
}
