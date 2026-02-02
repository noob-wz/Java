// 目的：了解Object类中的equals方法的用法。本质就是 == ，而 == 既可以判断基本类型，也可以判断引用类型是否相同。
//      （1）如果是基本类型，比较的是值时都相等
//      （2）如果是引用类型，比较的对象地址是否相同
// Object的equals方法只比较的是引用地址。一般JDK中常规的工具子类会重写，如String比较的是地址+内容，包装类比较的是内容

package com.wz.Object_;

public class Equals01 {
    public static void main(String[] args) {
        A a = new A();
        A b = a;
        A c = b;
        System.out.println("a和c" + a.equals(c));
        // 等价于 a == c

        String str1 = "Tom";
        String str2 = new String("Tom");

        System.out.println("str1和Tom" + str1.equals("Tom"));
        // true
        // 这里直接比较字面量成功是因为类加载阶段就会在字符串常量池中存储"Tom"

        System.out.println("str1和\"Tom\"" + (str1 == "Tom"));
        // true
        // 代码中所有的字符串都会存储在字符串常量池中，而 变量存储的是实际是字符串的地址

        System.out.println("str1和str2" + (str1 == str2));
        // false
        // 用了 new，JVM 被强迫在堆内存的普通区域（非常量池区域）又开辟了一个全新的空间，把 "asdf"的地址存进去，然后把这个新空间的地址给 s1

        B bobj = b;
        System.out.println("bobj和a" + bobj.equals(a));
        // true
        // 比较的是实际地址，与变量类型无关

        Integer integer1 = new Integer(1000);
        Integer integer2 = new Integer(1000);


        System.out.println("integer1和integer2 ，equals方法下" + integer1.equals(integer2));
        // true
        // Integer 源码中重写了 Object 的方法，比较的是内容
        System.out.println("integer1和integer2，== 比较时" + (integer1 == integer2));
        // false
        // 比较的操作数是对象，所以比较地址
    }

}

class B {}
class A extends B {}
