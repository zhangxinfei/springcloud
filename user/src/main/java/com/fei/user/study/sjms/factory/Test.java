package com.fei.user.study.sjms.factory;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: zhangxinfei
 * create at:  2021/5/20  5:55 下午
 * @description:
 */
public class Test {


    public static void main(String[] args) throws Exception {
//        Teacher teacher = new Teacher();
//        teacher.name = "原老师";
//        teacher.age = 28;
//
//        Student student1 = new Student();
//        student1.name = "原学生";
//        student1.age = 18;
//        student1.teacher = teacher;
//
//        Student student2 = (Student) student1.clone();
//        System.out.println("-------------拷贝后-------------");
//        System.out.println(student2.name);
//        System.out.println(student2.age);
//        System.out.println(student2.teacher.name);
//        System.out.println(student2.teacher.age);
//
//        System.out.println("-------------修改老师的信息后-------------");
//// 修改老师的信息
//        teacher.name = "新老师";
//        System.out.println("student1的teacher为： " + student1.teacher.name);
//        System.out.println("student2的teacher为： " + student2.teacher.name);

        Teacher teacher = new Teacher();
        Teacher teacher1 = (Teacher) teacher.clone();

        System.out.println(teacher);
        System.out.println(teacher1);
    }
}

class Teacher implements Cloneable {
    public String name;
    public int age;
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Student implements Cloneable, Serializable {
    public String name;
    public int age;
    public Teacher teacher;
    public Object clone() throws CloneNotSupportedException {
        // 浅复制时：
        return super.clone();

        // 深复制时：
//        Student student = (Student) super.clone();
//        // 本来是浅复制，现在将Teacher对象复制一份并重新赋值进来
//        student.teacher = (Teacher) this.teacher.clone();
//        return student;
    }
}