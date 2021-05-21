package com.fei.user.study.jvm;

import com.fei.user.entity.User;
import sun.misc.Launcher;
import sun.misc.Resource;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;

/**
 * @author: zhangxinfei
 * create at:  2021/4/1  3:31 下午
 * @description: 类加载器
 */
public class TestJDKClassLoader {

    public static void main(String[] args) throws Exception {
//        Class cl = User.class;
//        Method method = cl.getMethod("sout");
//        method.invoke(cl.newInstance());
//        Class clazz = Class.forName("com.fei.user.entity.User");
//        Method method = clazz.getMethod("sout");
//        method.invoke(clazz.newInstance());
//        Object user = new User();
//        Class userClass = user.getClass();


        System.out.println(String.class.getClassLoader());
        System.out.println(com.sun.crypto.provider.DESKeyFactory.class.getClassLoader());
        System.out.println(TestJDKClassLoader.class.getClassLoader());

        System.out.println();
        ClassLoader appClassLoader = ClassLoader.getSystemClassLoader();
        ClassLoader extClassloader = appClassLoader.getParent();
        ClassLoader bootstrapLoader = extClassloader.getParent();
        System.out.println("the bootstrapLoader : " + bootstrapLoader);
        System.out.println("the extClassloader : " + extClassloader);
        System.out.println("the appClassLoader : " + appClassLoader);
        System.out.println(); System.out.println("bootstrapLoader加载以下文件:");
        URL[] urls = Launcher.getBootstrapClassPath().getURLs();
        for (int i = 0; i < urls.length; i++) {
            System.out.println(urls[i]);
        }
        System.out.println();
        System.out.println("extClassloader加载以下文件:");
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println();
        System.out.println("appClassLoader加载以下文件:");
        System.out.println(System.getProperty("java.class.path"));

    }

}
