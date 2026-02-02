// 功能：功能创建一个类Employee，属性有（名字，性别，年龄，职位，薪水），提供三个构造器，可以初始化：（1）名字，性别，年龄，职位，薪水；（2）名字，性别，年龄；（3）职位，薪水。要求：充分复用构造器
// 目的：了解this的功能之一，构造器互调

public class HomeWork07 {
    
}

class Employee {
    String name;
    char gender;
    int age;
    String job;
    double salary;

    public Employee(String name, char gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public Employee(String job, double salary) {
        this.job = job;
        this.salary = salary;
    }

    public Employee(String name, char gender, int age, String job, double salary) {
        this(name, gender, age);

        // 注意：以下两行代码不能用  this(job, salary); 代替
        // 因为this构造器互调必须放在另一个构造器的第一行。而前面已经有了一个this互调方法
        this.job = job;
        this.salary = salary;
    }
}