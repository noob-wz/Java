// TODO(2025-12-23 10:42:17) 
// 功能：设计一个Dog类，有名字，颜色和年龄属性，定义输出方法show（）显示其信息，并创建对象，进行测试
// 目的：熟悉this的使用

public class HomeWork04 {
    public static void main(String[] args) {
        Dog dog = new Dog("来福", 4, "灰白色");
        dog.show();
    }
}

class Dog {
    String name;
    int age;
    String color;

    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public void show() {
        System.out.println("小狗的姓名是：" + name);
        System.out.println("小狗的年龄是：" + age);
        System.out.println("小狗是" + color + "的");
    }
}

/* 运行结果：
--------------------------------
小狗的姓名是：来福
小狗的年龄是：4
小狗是灰白色的
--------------------------------
*/