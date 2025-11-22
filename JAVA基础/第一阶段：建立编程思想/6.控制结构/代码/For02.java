// 目的：了解循环用法

public class For02 {
    public static void main(String[] args) {
        for(int i = 0; i <= 5; i++) {
            System.out.println(i + " + " + (5 - i) + "= 5");
        }
    }
}

/* 运行结果：
--------------------------------
0 + 5= 5
1 + 4= 5
2 + 3= 5
3 + 2= 5
4 + 1= 5
5 + 0= 5
--------------------------------
*/