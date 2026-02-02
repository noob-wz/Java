// 功能：定义员工类，包含姓名和月工资，以及计算年工资getAnnual方法。普通员工和经理继承员工，经理类多奖金bonus和管理manage方法，
//      普通员工多work方法，普通员工和经理类要求重写getAnnual方法。其他要求：
//          （1）测试类中多个showEmpAnnual(Employee e)，实现获取任何员工对象的年工资，并在main方法中调用该方法
//          （2）测试类中添加一个方法，testWork,如果是普通员工，则调用work方法，如果是经理，则调用manage方法

package com.wz.poly_.polyparameter_;

public class PloyParameter {
    public static void main(String[] args) {
        Test t = new Test();
        Manager m = new Manager("李经理", 40000, 80000);
        Worker w = new Worker("小王", 6000);
        t.showEmpAnnual(m);
        t.showEmpAnnual(w);
        t.testWork(m);
        t.testWork(w);

    }
}

abstract class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    abstract public double getAnnual();
}

// 普通员工
class Worker extends Employee {
    public Worker(String name, double salary) {
        super(name, salary);
    }

    // 子类特有方法
    public void work() {
        System.out.println("工人" + getName() + "正在工作");
    }

    @Override
    public double getAnnual() {
        // 不要直接打印，遵循单一原则，讲计算和展示分离
        return getSalary() * 12;
    }
}

// 经理
class Manager extends Employee {
    private double bonus;

    public Manager(String name, double salary, double bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void manage() {
        System.out.println("经理" + getName() + "正在管理");
    }

    //
    @Override
    public double getAnnual() {
        return getSalary() * 12 + bonus;
    }
}

// 测试类
class Test {
    public void showEmpAnnual(Employee e) {
        System.out.println(e.getName() + "的年薪水是：" + e.getAnnual());
    }

    public void testWork(Employee e) {
        if (e instanceof Worker) {
            ((Worker)e).work();
        } else if (e instanceof Manager) {
            ((Manager)e).manage();
        }
    }
}

/* 输出结果：
*************************************
李经理的年薪水是：560000.0
小王的年薪水是：72000.0
经理李经理正在管理
工人小王正在工作
*************************************
*/
