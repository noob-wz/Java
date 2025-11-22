// 功能：用switch将小写类型的char型转为大写（键盘输入），只转换a,b,c,de,其他输出“other"
import java.util.Scanner;

public class Switch02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("请输入你要转化为大写的字母：");
        char ch = sc.next().charAt(0);

        switch(ch) {
            case 'a':
                ch -=32;
                System.out.println("字母a转化为大写" + ch);
                break;
            case 'b':
                ch -=32;
                System.out.println("字母b转化为大写" + ch);
                break;
            case 'c':
                ch -=32;
                System.out.println("字母c转化为大写" + ch);
                break;
            case 'd':
                ch -=32;
                System.out.println("字母d转化为大写" + ch);
                break;
            case 'e':
                ch -=32;
                System.out.println("字母e转化为大写" + ch);
                break;
            default:
                System.out.println("other");
        }

        sc.close();
    }
}
