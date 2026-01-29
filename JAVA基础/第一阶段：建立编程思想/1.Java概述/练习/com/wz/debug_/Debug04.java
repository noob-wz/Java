// 功能：使用断点调试，追踪对象创建的过程

package com.wz.debug_;

public class Debug04 {
    public static void main(String[] args) {
        // 创建对象的流程
        //  （1）在方法区中加载类的信息
        //  （2）根据类的结构和大小信息在堆上分配内存空间，并初始化为 零值
        //  （3）设置对象头
        //  （5）执行构造器：
        //          1. 父类初始化
        //          2. 显示初始化
        //          3. 构造器主体初始化
        //  （6）设置引用
        Person p = new Person("wz", 25);
        System.out.println(p);
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
