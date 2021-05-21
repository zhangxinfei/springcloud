package com.fei.user.study.aqs;

import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: zhangxinfei
 * create at:  2021/3/30  7:32 下午
 * @description: AQS详情
 */
public class AQSDemo {

    private Integer counter = 0;

    /**
     * 基于AQS去实现加锁和解锁
     */
    private ReentrantLock lock = new ReentrantLock(true);

    /**
     * @Des 需要保证多个线程访问的是同一个ReentrantLock对象
     * 使用debug模式，观察加锁后lock中sync下的state
     * 没有加锁钱state=0，
     * 第一次加锁后变成1，
     * 第二次加锁后变成2，
     * 释放锁好依次减少
     * @Date 2021/3/30 7:37 下午
     * @Param
     * @Return
     */
    public void modifyResource(String threadName){
        System.out.println("通知《管理员》线程：-----》"+threadName+"准备打水");
        lock.lock();
            System.out.println("线程："+threadName+"第一次加锁");
            counter++;
            System.out.println("线程："+threadName+"打第"+counter+"桶水");
            lock.lock();
            System.out.println("线程："+threadName+"第二次加锁");
            counter++;
            System.out.println("线程："+threadName+"打第"+counter+"桶水");
            lock.unlock();
            System.out.println("线程："+threadName+"释放一个锁");
        lock.unlock();
        System.out.println("线程："+threadName+"释放一个锁");
    }

    public static void main(String[] args) throws InterruptedException {
//        AQSDemo aqs = new AQSDemo();
//        new Thread(()->{
//            String threadName = Thread.currentThread().getName();
//            aqs.modifyResource(threadName);
//        },"Thread:线程1").start();
//
////        Thread.sleep(1000);
//        new Thread(()->{
//            String threadName = Thread.currentThread().getName();
//            aqs.modifyResource(threadName);
//        },"Thread:线程2").start();




        ReentrantLock lock = new ReentrantLock(false);//false为非公平锁，true为公平锁
        lock.lock();//加锁
            while (true){
//                if ()
                //进行阻塞
                LockSupport.park();
                //放开阻塞
//                LockSupport.unpark();
            }
    }
}
