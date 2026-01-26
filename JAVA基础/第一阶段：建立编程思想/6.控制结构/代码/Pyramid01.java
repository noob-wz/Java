import java.util.Scanner;

public class Pyramid01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("请输入你要打印的金字塔层数(最小为1): ");
        int totalLevel = sc.nextInt();
        for (int i = 1; i <= totalLevel; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        sc.close();
    }
}

/* 运行结果：
--------------------------------
*
**
***
--------------------------------
*/