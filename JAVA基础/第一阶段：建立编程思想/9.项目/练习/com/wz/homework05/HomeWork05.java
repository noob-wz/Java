// 目的：假定GrandFather, Father 和 Son 在同一个包。问：父类和子类通过this和super都可以调用哪些属性和方法

package com.wz.homework05;

public class HomeWork05 {
    public static void main(String[] args) {

    }
}

class GrandFather {
    String name = "AA";
    private int age = 100;

    public void g1() {};
}

class Father extends GrandFather {
    String id = "001";
    private double score;
    public void f1(){
        // 问：super 可以访问哪些成员（属性和方法）
        // 答：super.name，super.g1()

        // 问：this可以访问 哪些成员
        // 答：this.name,this.g1(),this.id,this.score,this.f1()
    }
}

class Son extends Father {
    String name = "BB";
    private double score;
    public void g1(){}
    private void show() {
        // 问：super 可以访问哪些成员（属性和方法）
        // 答：super 可以访问 super.id , super.f1(), super.name , super.g1()（等价于Father.g1())

        // 问：this 可以访问 哪些成员
        // 答：可以访问 this.name,  show(), id, f1(), name, Son.g1()（等价于Son.g1())
    }
}