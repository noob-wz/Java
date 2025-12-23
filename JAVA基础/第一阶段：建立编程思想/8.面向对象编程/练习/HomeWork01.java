// 目的：梳理对象创建的流程（本质就是new的工作原理）
//  如：分析 Person p = new Person("wangzeng", 27); 这行代码的执行过程。


public class HomeWork01 {
    public static void main(String[] args) {
        Person p = new Person("wangzeng", 27);
        // 创建一个实例（new)一般有六个步骤:
        // 第一步：检查加载类，JVM会在方法区查看是否存在这个类
        //          a. 存在，获取Person类的结构信息和大小
        //          b. 不存在，加载类到方法区，再获取Person类的结构信息和大小
        // 第二步：分配堆内存空间。根据方法区中类的结构信息和大小在堆上分配合适的内存空间
        // 第三步：内存清零。JVM会把堆中分配的所有字段设为二进制0，age为0，name为null
        // 第四步：设置对象头。核心是将对象与方法区中Person类的元数据建立关联
        // 第五步：执行构造器。
        //          a. 执行父类构造器
        //          b. 显示赋值：90覆盖初始化的0
        //          c. 执行构造器主体部分：将常量池中"wangzeng"的起始地址给堆中对象的name属性，方法区中age的值拷贝给对象的age
        // 第六步：建立栈引用。将创建的对象的起始地址赋给引用变量p

        System.out.println(p.name + "" + p.age);
    }
}

class Person {
    int age = 90;
    String name;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
