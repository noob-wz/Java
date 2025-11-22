// 功能：根据指定月份，打印该月份所属的季节

import java.util.Scanner;

public class Switch03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("来查看所属季节，请输入当前月份：");
        
        int month = sc.nextInt();

        switch (month) {
            case 3:
            case 4:
            case 5:
                System.out.println( month + "属于春季！");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println( month + "属于夏季！");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println( month + "属于秋季！");
                break;
            case 12:
            case 1:
            case 2:
                System.out.println( month + "属于冬季！");
                break;
            default:
                System.out.println("输入月份有误！");
        }

        sc.close();
    }
}