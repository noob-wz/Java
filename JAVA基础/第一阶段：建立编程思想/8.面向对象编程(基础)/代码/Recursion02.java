// 目的：深度感知递归的内存调用即：“后进显出”

public class Recursion02 {
    
    public static void main(String[] args) {
        test(10);
    }
    public static void test(int n) {
        // 过程：
        // n == 10
        // （1）n > 2,一直执行test(9),test(8),...,test(2)，这是压栈的过程
        // （2）后进先出 n=2,n=3,...,n=9,n=10
        if (n > 2) {
            test(n-1);
        }
        System.out.println("n=" + n);
    } 
}
/* 运行结果：
--------------------------------
n=2
n=3
n=4
n=5
n=6
n=7
n=8
n=9
n=10
--------------------------------
*/
