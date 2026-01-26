// 功能：用switch将小写类型的char型转为大写（键盘输入），只转换a,b,c,de,其他输出“other"
import java.util.Scanner;

public class Switch02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("请输入你要转化为大写的字母：");
        char ch = sc.next().charAt(0);

        switch(ch) {
            case 'a':
            case 'b':
            case 'c':
            case 'd':
            case 'e':
                System.out.print("字母" + ch + "转化为大写为: ");
                ch -=32;
                System.out.println(ch);
                break;
            default:
                System.out.println("other");
        }

        sc.close();
    }
}
