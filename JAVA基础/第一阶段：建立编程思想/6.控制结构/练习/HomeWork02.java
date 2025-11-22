// 功能：判断一个整数，属于哪个范围：大于0；小于0；等于0
import java.util.Scanner;
public class HomeWork02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("请输入一个整数：");
        int num = sc.nextInt();

        if (num > 0) {
            System.out.println(num + "大于0！");
        } else if (num == 0) {
            System.out.println(num + "等于0！");
        } else {
            System.out.println(num + "小于0！");
        }

        sc.close();

    }
}
