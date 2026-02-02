// 功能：该程序输出什么
//2026-01-02 22:44:05

package com.wzedu.extend_.exercise;

/**
 * @author dchuan
 */
public class ExtendsExercise02 {
    public static void main(String[] args) {
        C2 c = new C2();
    }
}

class A2 {
    public A2() {
        System.out.println("我是A类");
    }
}

class B2 extends A2 {
    public B2() {
        System.out.println("B类的无参构造器");
    }

    public B2(String name) {
        System.out.println(name + "，我是B类的有参构造器");
    }
}

class C2 extends B2 {
    public C2() {
        this("hello");
        System.out.println("C类的无参构造器");
    }

    public C2(String name) {
        super("haah");
        System.out.println(name + "，我是C类的有参构造器");
    }
}

/* 输出结果：
*************************************
我是A类
haah，我是B类的有参构造器
hello，我是C类的有参构造器
C类的无参构造器
*************************************
*/
