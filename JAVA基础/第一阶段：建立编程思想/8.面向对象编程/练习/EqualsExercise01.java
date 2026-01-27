// 目的：重写 Object 的 equals 方法

import java.util.Objects;

public class EqualsExercise01 {
    public static void main(String[] args) {
        Person7 p1 = new Person7("jack", 18, '男');
        Person7 p2 = new Person7("jack", 18, '男');
        Person7 p3 = new Person7("jack", 19, '男');

        System.out.println(p1.equals(p2));
        System.out.println(p1.equals(p3));

    }
}

class Person7 {
    private String name;
    private int age;
    private char gender;

    public Person7(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public char getGender() {
        return gender;
    }

   // 重写 Object 的 equals 方法
    @Override
    public  boolean equals(Object obj) {

        // 防御性编程
        // 校验1: 自反性：如果是同一个引用，直接 true
        if (this == obj) {
            return true;
        }

        // 校验2: 类型检查：如果 obj 是 null 或者类不同，直接 false
        if (obj instanceof Person7) {
            // 由于obj 变量的编译时类型是 Object，编译器看不到子类特有的属性。强转是为了告诉编译器：“我知道它是 Person，请给我 Person 的访问权限。”
            // 而 instanceof 的作用：它只是一个安检门，负责返回 true/false，它不会改变变量本身的类型。而且是运行时视角（关注实际内存中的类型）
            // 所以，在编译期，编译器不能识别name、age等属性是否存在于obj中，因此必须强制转型
            Person7 p = (Person7)obj;
            // Java 14 预览版 / Java 16 正式版 后，引入了 "instanceof 模式匹配"，不需要再用强制类型转型了

            // 错误写法
            // return this.name == p.name && p.age == age && p.gender == gender;
            // 虽然本程序中不会出错，因为 Java 的字符串常量池机制，它恰好能跑通（地址相同）
            // 如果名字是动态生成的（例如 new String("jack") 或者从数据库读出来的），== 会返回 false，即使它们都拼写为 "jack"。

            // 正确写法
            // 注意：this.name：是 String 类型的对象实例！所以，this.name.equals()，调用的是 JDK 自带的 String.equals
            return this.name.equals(p.name) && p.age == age && p.gender == gender;

        }
        return false;
    }

    // 重写 equals 必须重写 hashCode
    @Override
    public int hashCode() {
        // 根据所有参与 equals 比较的属性计算 Hash 值
        return Objects.hash(name, age, gender);
    }
}