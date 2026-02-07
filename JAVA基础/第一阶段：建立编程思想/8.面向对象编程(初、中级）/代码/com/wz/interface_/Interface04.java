// 目的：当父类和父接口中同时出现相同名称的字段，无论是否是静态变量还是实例变量。分析是否有误。
// 总结：
// （1）如果一个字段名在父类和父接口中同时出现，并且都是可访问的，那么这个引用就是有歧义的，必须产生编译错误。
// （2）虽然当父类静态

package com.wz.interface_;

public class Interface04 extends AA implements BB{
    public void pX() {
        System.out.println(i);
        // 发生编译错误。Java规定：如果一个字段名在父类和父接口中同时出现，并且都是可访问的，那么这个引用就是有歧义的 (Ambiguous)，必须产生编译错误。

        // 正确方式：明确访问方向
        System.out.println(BB.i);
        System.out.println(super.i);

    }

    public static void main(String[] args) {
        new Interface04().pX();
        // 等同于 this.i。有两个路径，既可以是：实例访问实例变量。也可以是：实例访问静态变量
    }
}

class AA {
    int i = 1;
}

interface BB {
    int i = 0;
}