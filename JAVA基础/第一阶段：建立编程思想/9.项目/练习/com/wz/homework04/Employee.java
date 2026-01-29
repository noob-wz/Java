package com.wz.homework04;

abstract public class Employee {
    private String name;
    private double salary;
    private int workDays;
    private double grade;

    public Employee(String name, double salary, int workDays, double grade) {
        this.name = name;
        this.salary = salary;
        this.workDays = workDays;
        this.grade = grade;
    }

    public double getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public int getWorkDay() {
        return workDays;
    }

    public double getGrade() {
        return grade;
    }

    public double totalSalary() {
        return workDays * salary * grade;
    }

    public void printSalary() {
        System.out.println(name + "薪水为: " + totalSalary());
    }
}

class Manager extends Employee {
    public Manager(String name, double salary, int workDays) {
        // 高内聚：谁拥有数据，谁就负责维护数据，1.2 是子类特有的
        super(name, salary, workDays, 1.2);
    }

    @Override
    public double totalSalary() {
        return 1000 + super.totalSalary();
    }
}

class Worker extends Employee {
    public Worker(String name, double salary, int workDays) {
        super(name, salary, workDays, 1.0);
    }

    @Override
    public double totalSalary() {
        return super.totalSalary();
    }
}
