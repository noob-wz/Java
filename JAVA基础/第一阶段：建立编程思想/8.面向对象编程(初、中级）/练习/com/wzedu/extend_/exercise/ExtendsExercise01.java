// 功能：main中 B b = new B(); 会输出什么

package com.wzedu.extend_.exercise;

/**
 * @author wangzeng
 */
public class ExtendsExercise01 {
    public static void main(String[] args) {
        B b = new B();
        // 输出内容步骤分析：
        // （1）执行无参构造器B（），接着this级联调用有参构造器
        // （2）super()执行父类构造器，输出“a"
        // （3）继续执行子类全参构造器的主体，输出“b name"
        // （4）然后执行无参构造器，输出“b"
    }


}

class A {
    A() {
        System.out.println("a");
    }

    A(String name) {
        System.out.println("a name");
    }
}

class B extends A {
    B() {
        this("abc");
        System.out.println("b");
    }

    B(String name) {
        System.out.println("b name");
    }
}

/* 输出结果：
*************************************
a
b name
b
*************************************
*/
