// 2026-01-01 15:56:48
// 目的：了解封装的用法，以及封装结合构造器使用

public class Encapsulation {
    public static void main(String[] args) {
        Person6 p = new Person6();
        p.setAge(130);
    }
}

class Person6 {
    // 拒绝使用“魔法值”，都使用常量
    private static final int MAX_AGE = 120;
    private static final int MIN_AGE = 0;
    private static final int DEFAULT_AGE = 18;

    public String name;
    private int age;
    private double salary;

    // 无参构造器
    public Person6() {

    }

    // 全参构造器
    // 如果构造器里直接赋值，而 Setter 里写了校验逻辑，那么构造器确实就是一条“走私通道”，完美绕过了安检！
    public Person6(String name, int age, double salary) {

        // 封装的目的不仅仅是隐藏数据，而且要保证任何入口、任何时候，进入对象的数据都是合法的。
        // 所以，构造器和 Setter 统一安检逻辑
        setAge(age);
        setName(name);
        setSalary(salary);
    }

    public void setName(String name) {
        if (name.length() >= 2 && name.length() <= 6) {
            this.name = name;
        } else {
            System.err.println("错误：姓名长度在2-6个字符之间！");
            throw new IllegalArgumentException("非法姓名！");
        }
    }
    public String getName() {
        return name;
    }

    public void setAge(int age) {
        if (age >= MIN_AGE && age <= MAX_AGE) {
            this.age = age;
        } else {
            this.age = 18;

            // 这里规定如果数据设置错误，改成默认值。一般实际项目中，通常是不替用户做决定，而是直接抛出错误
            // 抛出错误 方法1
            System.err.println("错误：年龄必须在" + MIN_AGE + "岁到" + MAX_AGE + "岁之间");

            // 抛出错误 方法2
            throw new IllegalArgumentException("非法年龄！");
        }
    }
    public int getAge() {
        return age;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}