// 功能：如果李三不还钱，则老韩将一致使出五连鞭，直到李三说出还钱（dowhile实现）
// TODO(2025-11-20 20:52:36) 

/* TODO(2025-11-20 20:52:41) 
 * 总结：
 * 1. 字符串比较，比较的是内存地址，如果看字符串内容是否一致，用.equal()方法
 */

import java.util.Scanner;

public class DoWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
//        do {
//            System.out.print("还钱吗？y/n");
//            if (sc.next().charAt(0) == 'y') {
//            // if(sc.next() == "y") { // 字符串比较== ，比较的是内存的起始地址
//                break;
//            }
//            System.out.println("看我闪电五连鞭！");
//        } while (true);

//         等价于
         do {
             System.out.println("看我闪电五连鞭！");
             System.out.println("还钱吗？y/n");
         } while (sc.next().charAt(0) != 'y');

        sc.close();
    }
}
