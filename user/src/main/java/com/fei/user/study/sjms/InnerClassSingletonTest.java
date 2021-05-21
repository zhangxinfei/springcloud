package com.fei.user.study.sjms;

import java.lang.reflect.Constructor;

/**
 * @author: zhangxinfei
 * create at:  2021/5/17  4:58 下午
 * @description:
 */
public class InnerClassSingletonTest {

    public static void main(String[] args) throws Exception {
//        InnerClassSingleton instance = InnerClassSingleton.getInstance();
//        InnerClassSingleton instance1 = InnerClassSingleton.getInstance();
//        System.out.println(instance == instance1);

//        new Thread(()->{
//            InnerClassSingleton instance = InnerClassSingleton.getInstance();
//            System.out.println(instance);
//        }).start();
//
//        new Thread(()->{
//            InnerClassSingleton instance = InnerClassSingleton.getInstance();
//            System.out.println(instance);
//        }).start();

        //反射攻击
        Constructor<InnerClassSingleton> declaresConstrutor = InnerClassSingleton.class.getDeclaredConstructor();
        //使用setAccessible(true),设置方法的访问权限，设置为true可以访问private方法
        declaresConstrutor.setAccessible(true);
        InnerClassSingleton innerClassSingleton = declaresConstrutor.newInstance();

        InnerClassSingleton instance = InnerClassSingleton.getInstance();
        System.out.println(innerClassSingleton == instance);
    }
}

/**
 * @Des 懒汉式--内部类加载方式
 * @Date 2021/5/17 5:01 下午
 * @Param
 * @Return
 */
class InnerClassSingleton{
    private static class InnerClassHolder{
        private static InnerClassSingleton instance = new InnerClassSingleton();
    }

    private InnerClassSingleton(){
        if (InnerClassHolder.instance != null){
            throw new RuntimeException("单例不允许创建多个实例");
        }
    }

    public static InnerClassSingleton getInstance(){
        return InnerClassHolder.instance;
    }

}
