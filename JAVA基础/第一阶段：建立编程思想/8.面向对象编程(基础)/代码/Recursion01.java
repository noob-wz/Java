// 目的：区分静态成员方法和动态(实例)成员方法，以及不同成员方法的调用方式

public class Recursion01 {
    public static void main(String[] args) {

        // 因为程序启动时，main方法就可以运行，此时只有Recursion01类，还没有实例。此时有两种调用方式：
        // 方式1: test()方法的访问修饰符声明为static，即类的方法
        // 方式2: test()声明为公开的，此时要显示创建类的实例，然后"实例名.test()"调用
        System.out.println(test(10));
    }

    public static int test(int n) {
        // 终止条件：找边界值，边界值是test(n-1）最终为test(1)，所以n-1<1退出
        if (n < 2) 
            return 1;

        return n * test(n-1);
    }
}
