// 功能：输入一个n，对应输入位置上的斐波那契数
// 目的：练习递归，了解递归中函数重复调用的时间复杂度高，本质上函数栈并不是线性的增加

public class Recursion03 {
    public static void main(String[] args) {
        Recursion03 re = new Recursion03();
        System.out.println(re.fibonacci(7));
    }

    public int fibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            // 这种方式中重复调用了很多次的函数，实践复杂度很高，与效率法则违背。本质上是函数栈不是线性增加
            // 比如fibonacci(n-1) + fibonacci(n-2) 等价于
            // （fibonacci(n-2) + fibonacci(n-3)） + fibonacci(n-2)
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }
}
