// TODO(2025-12-21 20:44:21) 
// 目的：熟悉this的用法
// 功能：比较两个人的姓名和年龄是否一致

public class TestPerson {
    public static void main(String[] args) {
        Person p1 = new Person("wangzeng", 18);
        Person p2 = new Person("wangzeng", 18);
        if(p1.compareTo(p2)) {
            System.out.println("两个人的姓名和年龄相等");
        } else {
            System.out.println("两个人的姓名和年龄不一致");
        }
    }
}

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public boolean compareTo(Person p) {
        // if(this.name.equals(name) && this.age == age) {
        //     return true;
        // } else {
        //     return false;
        // }

        return this.name.equals(p.name) && this.age == p.age;
    }
}