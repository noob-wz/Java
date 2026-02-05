// 目的：熟悉接口的写法

package com.wz.interface_;

public interface Interface01 {
    // 不推荐，public static final 是冗余的，因为编译器会自动添加
    public static final int i = 10;
    // 静态常量推荐写法
    int j = 10;

    // 不推荐， public abstract 是冗余的，因为编译器会自动添加
    public abstract void print();
    // 抽象方法推荐写法
    void print2();

    // 不推荐， public是冗余的，编译器自动加
    // 这里写上是为了说明，接口中的default不代表访问权限，而是代表默认实现
    public default void say() {
        System.out.println("默认方法");
    }

    // 推荐静态方法写法
    static void write() {
        System.out.println("静态方法");
    }

}
