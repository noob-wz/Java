// 功能：面对过程思想实现零钱通。
// 思路：（1）第一步，拆解和

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SmallChangeSys {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        boolean loop = true;
        String details = "--------------------------------- 零钱通明细 ---------------------------------";
        double money = 0;
        double balance = 0;
        Date date = null;
        String note = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        do {
            // 打印菜单
            System.out.println("\n--------------------------------- 零钱通菜单 ---------------------------------");
            System.out.println("\n\t\t\t" + "1. 零钱通明细" + "\n\t\t\t" + "2. 收益入账" + "\n\t\t\t" + "3. 消费" + "\n\t\t\t" + "4.退出");
            System.out.print("请输入 1-4 ：");

            // 用户输入
            int key = sc.nextInt();

            // 分支执行
            switch(key) {
                // 分支1 ：零钱通明细
                case 1:
                    System.out.println(details);
                    break;
                //  分支2 ：收支明细
                case 2:
                    System.out.print("收益入账金额：");
                    money = sc.nextDouble();
                    balance += money;
                    date = new Date();
                    details += "\n" + "收益明细\t\t\t+" + money + "\t\t\t" + sdf.format(date) + "\t\t\t余额：" + balance;
                    break;
                // 分支 3: 消费
                case 3:
                    System.out.print("消费金额：");
                    money = sc.nextDouble();
                    if (money <= 0 || money > balance) {
                        System.out.println("消费金额应该在 0 ～ " + balance + "之间");
                    } else {
                        balance -= money;
                        System.out.print("消费用途：");
                        note = sc.next();
                        details += "\n" + note + "\t\t\t-" + money + "\t\t\t" + sdf.format(date) + "\t\t\t余额：" + balance;
                    }
                    break;
                case 4:
                    loop = false;
                    break;
                default:
                    System.out.println("输入有误！请输入 1- 4！");
            }

        } while(loop);
        System.out.println("已退出零钱通！");
    }
}
