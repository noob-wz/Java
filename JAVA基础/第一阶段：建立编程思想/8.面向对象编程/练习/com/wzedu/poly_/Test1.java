package com.wzedu.poly_;

public class Test1 {
    public static void main(String[] args) {
        Father f = new Son();
        System.out.println("Property: " + f.price);
        // 输出 100

        f.show();
        // 输出 200
    }
}

class Father {
    int price = 100;
    void show() { System.out.println("Father: " + price); }
}

class Son extends Father {
    int price = 200; // 属性遮蔽
    @Override
    void show() { System.out.println("Son: " + price); }
}
