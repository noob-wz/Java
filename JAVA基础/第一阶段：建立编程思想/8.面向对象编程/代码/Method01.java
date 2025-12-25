public class Method01 {
    public static void main(String[] args) {
        Person3 person3 = new Person3();
        System.out.println("person1的年龄：" + person3.age);
        System.out.println("person1的姓名：" + person3.name);
        person3.speak();
        System.out.println(person3.cal01());
        System.out.println(person3.cal02(10000));
        System.out.println(person3.getSum(5, 5));
    }
}

class Person3 {
    int age;
    String name;

    public void speak() {
        System.out.println("我是一个好人！");
    }

    // 成员方法：计算1+2+...+1000
    public int cal01() {
        int sum = 0;
        for (int i = 1; i <= 1000; i++) {
            sum += i;
        }
        return sum;
    }

    // 成员方法：可以接受一个数，计算1+...+n
    public int cal02(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    // 成员方法：计算两个数的和
    public double getSum(double m, double n) {
        return m + n;
    }
}