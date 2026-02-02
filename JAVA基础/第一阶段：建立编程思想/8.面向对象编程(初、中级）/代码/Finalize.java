// 目的：了解 Object 的 finalize 方法

public class Finalize {
    public static void main(String[] args) {
        Car bmw = new Car("宝马");

        bmw = null;
        // 删除GC Roots: bmw对象引用置空，那么远来指向的那块堆空间没有了 GC Roots，就会被认定为垃圾对象
        // 垃圾回收器销毁之前，会调用该对象的 finalize 方法。程序员就可以在这个方法中写入自己的业务逻辑，比如释放资源
        // 如果 Car 类中没有重写，调用 Object 的 finalize 方法，默认什么都不做

        // 由于垃圾回收机制按需发生，所以需要主动触发垃圾回收器，即时运行（不一定发生）
        System.gc();

        System.out.println("程序退出了...");
        // 输出显示 “程序退出了...” 在 “宝马 车就要被销毁了...” 之前，是因为System.gc() 只是发了一个"通知"，而不是下了一道"死命令"。而且，倒垃圾（GC）和写遗言（finalize）是在另一个独立的线程里完成的。
        // finalize 不是在main主线程里运行的

        /* ASCII 时序图
            *************************************
            ```
            时间轴 (Time)
              |
              |   [Main 线程] (老板)                 [Finalizer 线程] (保洁员)
              |   -----------------                 ---------------------
              |           |                                   |
              |   1. bmw = null (制造垃圾)                     | (睡觉中...)
              |           |                                   |
              |   2. System.gc() (按铃呼叫)                    |
              |           | ----------------通知发送---------> |
              |           |                                   | (被唤醒，伸个懒腰...)
              |   3. 继续跑下一行 (不等待!)                     |
              |           |                                   | (准备开始干活...)
              |   4. SOUT("程序退出了...")                      |
              |           |                                   |
              |   5. 程序结束 (JVM关闭)                        | (刚拿起扫把...)
              |           |                                   |
              v           X (Main线程死亡)                     X (还没来得及扫，被迫强制下班)

            ```
            *************************************
            */
    }
}

class Car {
    private String name;

    public Car(String name) {
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println(name + " 车就要被销毁了...");
    }
}

/* 输出结果：
*************************************
程序退出了...
宝马 车就要被销毁了...
*************************************
*/



