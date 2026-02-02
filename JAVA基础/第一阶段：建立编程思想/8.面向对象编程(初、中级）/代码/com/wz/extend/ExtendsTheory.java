// 目的：熟悉继承的本质

package com.wz.extend;

public class ExtendsTheory {
    public static void main(String[] args) {

    }
}

class GrandPa {
    String name = "大头爷爷";
    String hobby = "旅游";
}

class Father extends GrandPa {
    String name = "大头爸爸";
    int age = 39;
}

class Son extends Father {
    String name = "大头儿子";
}