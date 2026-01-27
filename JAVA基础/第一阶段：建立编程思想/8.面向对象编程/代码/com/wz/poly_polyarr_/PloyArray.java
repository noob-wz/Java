// 功能：现有一个继承，Person类下有Student和Teacher两子类，父类的数据私有。要求：
//  （1）2个Student对象和2个Teacher对象统一放在数组中，并调用每个对象的say方法
//  （2）执行子类特有的方法

// 目的：了解继承的类型抽象、封装的规范写法以及多态

package com.wz.poly_polyarr_;

public class PloyArray {
    public static void main(String[] args) {

        // 创建对象数组
        Person[] persons = {
                new Student("jack", 18, 100),
                new Student("mark", 17, 99.1),
                new Teacher("smith", 38, 4000),
                new Teacher("scott", 48, 20000)
        };

        // 增强循环遍历
        for(Person per : persons) {
            // 多态执行父类子类都有，但存在差异的方法
            per.say();

            // 多态下执行子类特有的方法 —— 向下转型
            if (per instanceof Student) {
                ((Student)per).study();
            }

            if (per instanceof Teacher) {
                ((Teacher)per).teach();
            }
        }


    }
}

// 抽象父类，因为父类 Person 无实际意义
abstract class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 封装后，常规方法中使用数据，最好通过方法
    public void say() {
        System.out.println("姓名是：" + getName() + ", 年龄为：" + getAge());
    }

    // 封装私有数据，开放方法提供访问
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

class Student extends Person {
    double score;

    public Student(String name, int age, double score) {
        super(name, age);
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    @Override
    public void say() {
        System.out.println("学生姓名是：" + getName() + ", 年龄为：" + getAge() + "，成绩是：" + getScore());
    }

    public void study() {
        System.out.println("学生" + getName() + "正在学习");
    }
}

class Teacher extends Person {
    double salary;

    public Teacher(String name, int age, double salary) {
        super(name, age);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public void say() {
        System.out.println("老师姓名是：" + getName() + ", 年龄为：" + getAge() + "，薪水是：" + getSalary());
    }

    public void teach() {
        System.out.println("老师" + getName() + "正在讲课");
    }
}

/* 输出结果：
*************************************
学生姓名是：jack, 年龄为：18，成绩是：100.0
学生jack正在学习
学生姓名是：mark, 年龄为：17，成绩是：99.1
学生mark正在学习
老师姓名是：smith, 年龄为：38，薪水是：4000.0
老师smith正在讲课
老师姓名是：scott, 年龄为：48，薪水是：20000.0
老师scott正在讲课
*************************************
*/
