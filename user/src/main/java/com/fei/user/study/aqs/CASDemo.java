package com.fei.user.study.aqs;

/**
 * @author: zhangxinfei
 * create at:  2021/3/31  3:29 下午
 * @description: cas举例
 */
public class CASDemo {

    private static volatile Integer m = 1;
//    private Unsafe

    public void AddTwo(){
        new Thread(()->{
            m = m + 2;
            System.out.println("共享变量值：" + m);
        }).start();
    }

    public static void main(String[] args) {
        CASDemo casDemo = new CASDemo();
        for (;;){
            casDemo.AddTwo();
        }
    }

}
