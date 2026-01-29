package com.wz.homework03;

abstract public class Teacher {
    private String name;
    private int age;
    private String post;
    private double salary;
    private double grade;

    public Teacher(String name, int age, String post, double salary, double grade) {
        this.age = age;
        this.name = name;
        this.post = post;
        this.salary = salary;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPost() {
        return post;
    }

    public double getSalary() {
        return salary;
    }

    public double getGrade() {
        return grade;
    }

    // DRY原则：写一个通用introduce方法，避免在子类中 重复自己。因为如果要修改，就要修改三个地方。子类中使用super复用
    public void introduce() {
        System.out.println("姓名：" + getName() + "，年龄：" + getAge() +
                "，职称为：" + getPost() + "，工资是：" + getSalary() +
                "，工资级别是：" + getGrade());
    }
}

class Professor extends Teacher {

    public Professor(String name, int age, double salary) {
        // 高内聚：让类管理自己特有的属性
        super(name, age, "教授", salary, 1.3);
    }

    @Override
    public void introduce() {
        System.out.print("【教授信息】");
        super.introduce();
    }
}

class AssociateProfessor extends Teacher {
    public AssociateProfessor(String name, int age, double salary) {
        // 高内聚：让类管理自己特有的属性
        super(name, age, "副教授", salary, 1.2);
    }

    @Override
    public void introduce() {
        System.out.print("【副教授信息】");
        super.introduce();
    }
}

class Lecturer extends Teacher {
    public Lecturer(String name, int age, double salary) {
        // 高内聚：让类管理自己特有的属性
        super(name, age, "讲师", salary, 1.1);
    }

    @Override
    public void introduce() {
        System.out.print("【讲师信息】");
        super.introduce();
    }
}
