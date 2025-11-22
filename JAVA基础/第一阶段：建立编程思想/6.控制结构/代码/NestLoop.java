// 目的：
//  （1）了解一次性输入多个数据是如何被有效读取的
//  （2）了解编码规范中 “循环的最小作用域原则” —— 如果一个变量只服务于当前一次循环，在循环内部声明，不会污染外部环境
//  （3）了解编码规范中 “循环的即时初始化原则” —— 如果一个变量只服务于当前一次循环，却只能在循环外部声明（常见while，dowhile)，重置或者归零的操作必须放在循环体的第一行，这样保证了代码逻辑的清晰性

import java.util.Scanner;

public class NestLoop {
    public static void main(String[] args) {
        // 放在外部不好，要遵循循环中变量的最小作用域原则（第一个位置）
        // 最小作用域原则 —— 除非变量的结果需要在循环结束后继续使用，否则应尽可能在最内层、最小的作用域内声明和初始化变量
        // double score = 0d; 

        double totalScore = 0;
        Scanner sc = new Scanner(System.in);

        // 这个代码只是为了进行演示流程
        for (int i = 1; i <= 3; i++) {
            // 编码规范：最小作用域原则（第二个位置，推荐！）
            double score = 0d; 

            System.out.print("请输入" + i + "班五个人的成绩（中间用空格隔开）：");
            for (int j = 1; j <= 5; j++) {  // 在输入界面一次性输入5个，实际上计算机已经执行五次输入操作，只不过读取一个数据之后又重新开始了一次新的输入
                score = score + sc.nextDouble();
            } 
            System.out.println(i + "班的平均成绩是：" + score / 5);
            totalScore = score + totalScore;

            // 写在结尾对计算机没有区别，但是放在开头就会清晰地告诉读者score接下来要开始一个新的计算周期，这个变量必须是干净的
            // 第三个位置（与第一个位置配对）
            // score = 0;
        }
        System.out.println("三个班的平均分为：" + totalScore / 15);

    }
    
}
