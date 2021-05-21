package com.fei.user.study.jvm;

/**
 * @author: zhangxinfei
 * create at:  2021/4/21  2:47 下午
 * @description: 动态年龄判断
 * 测试虚拟机并不是永远地要求对象的年龄必须达到了MaxTenuringThreshold才能晋升老年代，
 * 如果在Survivor空间中相同年龄所有对象大小的总和大于Survivor空间的一半，年龄大于或等于该年龄的对象就可以直接进入老年代，
 * 无需等到MaxTenuringThreshold中要求的年龄
 *  -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails
 *  -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15 -XX:+PrintTenuringDistribution
 *  -Xloggc:H:\coder\jvm_learning\log\heap\half_bigger_than_survivor.log
 *  * -XX:NewRatio=3 指定新生代:老年代的比值
 *
 */
public class HalfBiggerThanSurvivor {

    private static final int _1MB = 1024 * 1024;

    public static void testTenuringThreshold2() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[_1MB / 4];
        //allocation1+allocation2大于survivor空间一半
        allocation2 = new byte[_1MB / 4];
        allocation3 = new byte[4 * _1MB];
//
        allocation4 = new byte[4 * _1MB];
        allocation4 = null;
        allocation4 = new byte[4 * _1MB];
    }

    public static void main(String... args) {
        HalfBiggerThanSurvivor.testTenuringThreshold2();
    }

}
