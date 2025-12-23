// TODO(2025-12-23 10:56:35) 
// 目的：分析下面代码的运行结果

public class HomeWork06 {
    public static void main(String[] args) {
        Demo d1 = new Demo();
        Demo d2 = d1;

        d2.m(); // i = 101, j = 100
        System.out.println(d1.i); // i = 101
        System.out.println(d2.i); // i = 101
    }
}

class Demo{
    int i = 100;
    public void m() {
        int j = i++;
        System.out.println("i=" + i);
        System.out.println("j=" + j);
    }
}

/* 运行结果：
--------------------------------
i=101
j=100
101
101
--------------------------------
*/