// 目的：了解构造器重载和成员变量的两层初始化保障机制
public class Constructor01 {
    public static void main(String[] args) {
        Person2 p1 = new Person2();
        Person2 p2 = new Person2("wangzeng", 27);
        System.out.println("无参构造器初始化对象p1，它的姓名是" + p1.name + "，它的年龄是：" + p1.age);
        System.out.println("有参构造器初始化对象p2，它的姓名是" + p2.name + "，它的年龄是：" + p2.age);
    }
}

class Person2 {
    // 未直接初始化，因为JVM会进行内存清零，并且创建实例时会进行初始化
    String name;
    int age;

    // 无参构造器
    public Person2() {
        // 等价于 name = null; 因为编译器默认会给name编译成this
        this.name = null;
        this.age = 18;
    }

    // 有参构造器
    public Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
