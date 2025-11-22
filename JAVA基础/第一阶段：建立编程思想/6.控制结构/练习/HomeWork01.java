// 功能：某人有100000元，每经过一次路口，需要交费，规则如下：
// （1）当现金 > 50000 时，每次交 5%
// （2）当现金 <= 50000 时，每次交 1000
// 编程计算该人可以经过多少次路口（要求while,break方式完成）

// 目的：了解循环的结构化拆解

public class HomeWork01 {
    public static void main(String[] args) {
        int money = 100000;
        int n = 0;

        while (true) {  
            // 只有一层循环，但循环条件分为两种，需要把循环条件结构化拆解为两个部分
            if (money > 50000) {
                money *= 0.95;
                n++;
            } else if (money >= 1000) {
                money -= 1000;
                n++;
            } else {
                System.out.println("余额已不足！");
                break;
            }
        }
        System.out.println("一共经过了" + n + "次路口");
    }
}
/* 运行结果：
--------------------------------
余额已不足！
一共经过了62次路口
--------------------------------
*/