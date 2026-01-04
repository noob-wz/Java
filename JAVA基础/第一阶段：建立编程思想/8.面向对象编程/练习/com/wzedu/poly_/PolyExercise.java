package com.wzedu.poly_;

public class PolyExercise {
    public static void main(String[] args) {
        Sub s = new Sub();

        System.out.println(s.count);
        // 输出 20

        s.display();
        //  输出 20

        Base b = s;
        System.out.println(b == s);
        // 输出 true

        System.out.println(b.count);
        // 输出 10

        b.display();
        // 输出 10  ---> 回答错误，输出 20
    }
}
