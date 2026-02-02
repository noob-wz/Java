// 目的：熟悉多态的静态机制和动态机制


/* 过程分析：
第一步：new Sub() 开始**

 1. **进 Sub 构造器** -> 隐式调用 `super()` (Base 构造器)。
 2. 进 Base 构造器**：
        （1）执行 `print()`。

            关键点：`print()` 被 `Sub` 重写了！虽然现在还在 `Base` 的构造器里，但对象是 `Sub`，所以**动态绑定**到了 `Sub.print()`。
            陷阱：此时 `Sub` 对象的成员变量 `i` **还没有被初始化**（那是 Sub 构造器之后的事）。内存里仅仅全是 0。

        （2）输出 1：`Sub: 0`。
        （3）Base 构造器继续，把 `Base.i` 设为 20（注意这是父类的 i，跟子类 i 无关）。

 3. 回 Sub 构造器：
        （1）现在开始初始化 Sub 的成员变量。`Sub.i` 被赋值为 30。
        （2）执行 `print()`。再次调用 `Sub.print()`。
        （3）输出 2**：`Sub: 30`。
        （4）最后把 `Sub.i` 设为 40。
*/

package com.wzedu.poly_;

class Base1 {
    int i = 10;
    public Base1() {
        // ⚠️ 构造器里调了多态方法
        print();
        i = 20;
    }
    public void print() {
        System.out.println("Base: " + i);
    }
}

class Sub1 extends Base1 {
    int i = 30;
    public Sub1() {
        print();
        i = 40;
    }
    @Override
    public void print() {
        // 注意：此时 Sub1 的 i 初始化了吗？
        System.out.println("Sub1: " + i);
    }
}

public class Test2 {
    public static void main(String[] args) {
        new Sub1();
    }
}

/* 输出结果：
*************************************
Sub1：0
Sub1：30
*************************************
*/
