package com.fei.user.study.jvm;

import java.io.FileInputStream;
import java.lang.reflect.Method;

/**
 * @author: zhangxinfei
 * create at:  2021/4/7  5:29 下午
 * @description:
 */
public class TomcatClassLoader {

    static class MyClassLoader extends ClassLoader {
        private String classPath;

        public MyClassLoader(String classPath) {
            this.classPath = classPath;
        }

        private byte[] loadByte(String name) throws Exception {
            name = name.replaceAll("\\.", "/");
            FileInputStream fis = new FileInputStream(classPath + "/" + name + ".class");
            int len = fis.available();
            byte[] data = new byte[len];
            fis.read(data);
            fis.close();
            return data;

        }

        protected Class<?> findClass(String name) throws ClassNotFoundException {
            try {
                byte[] data = loadByte(name);
                return defineClass(name, data, 0, data.length);
            } catch (Exception e) {
                e.printStackTrace();
                throw new ClassNotFoundException();
            }
        }

        /**
         * 重写类加载方法，实现自己的加载逻辑，不委派给双亲加载
         *
         * @param name
         * @param resolve
         * @return
         * @throws ClassNotFoundException
         */
        protected Class<?> loadClass(String name, boolean resolve)
                throws ClassNotFoundException {
            synchronized (getClassLoadingLock(name)) {
                // First, check if the class has already been loaded
                Class<?> c = findLoadedClass(name);

                if (c == null) {
                    // If still not found, then invoke findClass in order
                    // to find the class.
                    long t1 = System.nanoTime();

                    //非自定义的类还是走双亲委派加载
                    if (!name.startsWith("com.fei.user")) {
                        c = this.getParent().loadClass(name);
                    } else {
                        c = findClass(name);
                    }

                    // this is the defining class loader; record the stats
                    sun.misc.PerfCounter.getFindClassTime().addElapsedTimeFrom(t1);
                    sun.misc.PerfCounter.getFindClasses().increment();
                }
                if (resolve) {
                    resolveClass(c);
//                    注意:同一个JVM内，两个相同包名和类名的类对象可以共存，因为他们的类加载器可以不一 样，
//                    所以看两个类对象是否是同一个，除了看类的包名和类名是否都相同之外，还需要他们的类 加载器也是同一个才能认为他们是同一个。
                }
                return c;
            }
        }


        public static void main(String args[]) throws Exception {
            MyClassLoader classLoader = new MyClassLoader("/Users/zhangxinfei/Documents/project/springcloud/user/src/main/java");
            Class clazz = classLoader.loadClass("com.fei.user.entity.User");
            Object obj = clazz.newInstance();
            Method method = clazz.getDeclaredMethod("sout", null);
            method.invoke(obj, null);
            System.out.println(clazz.getClassLoader());

            System.out.println();
            MyClassLoader classLoader1 = new MyClassLoader("/Users/zhangxinfei/Documents/project/springcloud/user/src/main/java");
            Class clazz1 = classLoader1.loadClass("com.fei.user.entity.User1");
            Object obj1 = clazz1.newInstance();
            Method method1 = clazz1.getDeclaredMethod("sout", null);
            method1.invoke(obj1, null);
            System.out.println(clazz1.getClassLoader());
        }
    }
}