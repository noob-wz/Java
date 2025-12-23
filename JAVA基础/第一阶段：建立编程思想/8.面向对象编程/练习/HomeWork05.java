// TODO(2025-12-23 10:49:53) 
// 目的：分析下面代码的输出结果

public class HomeWork05 {
    int count = 9;

    public void count1() {
        count = 10;
        System.out.println("count1=" + count);
    }

    public void count2() {
        System.out.println("count1=" + count++);
    }

    public static void main(String[] args) {
        // 注意下面两次创建对象，他们是不同的对象，所以每个对象都有自己独立的成员变量

        new HomeWork05().count1(); // 10
        
        HomeWork05 h1 = new HomeWork05();
        h1.count2(); // 9
        h1.count2(); // 10
    }
}

/* 运行结果：
--------------------------------
count1=10
count1=9
count1=10
--------------------------------
*/