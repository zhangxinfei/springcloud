package com.fei.user.study.aqs;

import com.fei.user.entity.User;

/**
 * @author: zhangxinfei
 * create at:  2021/3/26  11:14 上午
 * @description: demo
 */
public class SynchronizedDemo {

    /**
     * @Des 逃逸分析（在创建对象后对象没有其他地方使用（也可以说只在当前方法中使用，没有就行返回））
     * ---- 这个里面的sb没有逃逸 会存储到堆内存中
     * @Date 2021/3/26 11:15 上午
     * @Param
     * @Return
     */
    public static StringBuffer craeteStringBuffer(String s1, String s2) {
        StringBuffer sb = new StringBuffer();
        sb.append(s1);
        sb.append(s2);
        return sb;
    }

    /**
     * @Des 逃逸分析（在创建对象后对象没有其他地方使用（也可以说只在当前方法中使用，没有就行返回）
     * ---- 这个里面的sb会发生逃逸 会存储到栈内存中
     * sb被转换成了String对象返回出去了，sb本事没有被返回，所以发生了逃逸
     * @Date 2021/3/26 11:15 上午
     * @Param
     * @Return
     */
    public static String createStringBuffer(String s1, String s2) {
        StringBuffer sb = new StringBuffer();
        sb.append(s1);
        sb.append(s2);
        return sb.toString();
    }


    private StringBuffer stb = new StringBuffer();
    /**
     * @Des 锁的粗化（jvm优化后把连续加锁的地方，统一进行一次加锁）
     * @Date 2021/3/26 4:24 下午
     * @Param
     * @Return
     */
    public void suodecuhua(){
        /**
         * StringBuffer本身是线程安全的，append方法的实现中对这个实例方法进行加锁，
         * 下面进行了两次append，所以会进行两次加锁，如下面的例子（1）
         * jvm优化后会把两次加锁的过程，优化成一次，例如下面的（2）
         *
         */
        //（1）
        synchronized (stb){
            stb.append("1");
        }
        synchronized (stb){
            stb.append("2");
        }
        //(2)
        synchronized(stb){
            stb.append("1");
            stb.append("2");
        }
    }

    /**
     * @Des 锁的消除（jvm会进行逃逸分析，分析出来进行加锁的对象不会被其他线程使用，所以就不会对该对象进行加锁）
     * @Date 2021/3/26 4:34 下午
     * @Param
     * @Return
     */
    public void suodexiaochu(){
        //jvm的优化，jvm不会对同步块进行加锁
        synchronized (new Object()){
            //jvm进行逃逸分析，分析出来new Object()不会被其他线程使用（不会进行逃逸）
            //所以也就不会对他进行加锁

        }
    }

}
