// 目的：展示接口的静态属性是可以继承的，可以通过 “接口名.成员名”“实现类名.成员名”“实现类实例.成员名” 访问

package com.wz.interface_;

public class Interface02 {
    public static void main(String[] args) {
        B b = new B();
        System.out.println(A.a);
        System.out.println(B.a);
        System.out.println(b.a);
    }
}

interface A {
    int a = 23;
}

class B implements A {

}
