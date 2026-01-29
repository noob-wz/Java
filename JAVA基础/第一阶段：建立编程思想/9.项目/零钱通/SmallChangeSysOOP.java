// 设计目的：在 SmallChangeSysOOP 完成所有业务逻辑

// 功能类
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

public class SmallChangeSysOOP {

    // 1. 定义属性
    boolean loop = true;
    String key = "";
    Scanner scanner = new Scanner(System.in);

    // 2. 核心数据
    String details = "--------------------------------- 零钱通明细 ---------------------------------";
    double money = 0;
    double balance = 0;
    Date date = null;
    SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm");

    // 3. 主流程
    public void mainMenu() {
        do {
            System.out.println("--------------------------------- 零钱通菜单 ---------------------------------");
            System.out.println("\t\t\t\t1. 零钱通明细");
            System.out.println("\t\t\t\t2. 收益入账");
            System.out.println("\t\t\t\t3. 消费");
            System.out.println("\t\t\t\t4. 退出");
            System.out.print("请选择（1-4）： ");

            key = scanner.next();

            switch (key) {
                case "1":
                    detail();
                    break;
                case "2":
                    income();
                    break;
                case "3":
                    pay();
                    break;
                case "4":
                    exit();
                    break;
                default:
                    System.out.println("输入错误！重新输入 1 ～ 4 之间的数！");
            }
        } while (loop);
    }

    // ------------------------- 以下是具体的功能方法 --------------------------------

    // 打印零钱通明细
    public void detail() {
        System.out.println(details);
    }

    // 收益入账
    public void income() {
        System.out.print("请输入收益金额：");
        money = scanner.nextDouble();

        // 校验逻辑
        if (money <= 0) {
            System.out.println("收益入账金额需要大于 0");
            return;
        }

        balance += money;
        date = new Date();
        details += "\n收益入账\t+" + money + "\t" + sdf.format(date) + "\t余额：" + balance;
    }

    // 消费
    public void pay() {
        System.out.print("请输入消费金额：");
        money = scanner.nextDouble();

        // 校验逻辑
        if (money <= 0 || money > balance) {
            System.out.println("消费金额需要在 0 ～ " + balance + "之间");
            return;
        }

        System.out.print("消费用途说明：");
        String note = scanner.next();

        balance -= money;
        date = new Date();
        details += "\n" + note + "\t-" + money + "\t" + sdf.format(date) + "\t余额：" + balance;
    }

    // 完成退出
    public void exit() {
        System.out.println("你确认要退出吗? y / n");
        String choice = scanner.next();

        while(true) {
            if (choice.equals("y") || choice.equals("n")) {
                break;
            }
            System.out.println("输入错误！输入 \"y\" or \"n\": ");
            choice = scanner.next();
        }

        // 如果是 y, 终结循环
        if (choice.equals("y")) {
            loop = false;
        }

        // 如果是 n，方法结束，返回 mainMenu 的 loop 循环，继续显示菜单
    }
}
