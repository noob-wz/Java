// 功能：对数组 arr 进行扩容，在末尾添加指定元素。如果添加成功，显示“添加成功”，并询问“是否继续添加 y/n”

// 目的：
// （1）了解数组扩容的原理；
// （2）了解条件判断中方法调用的陷阱；

import java.util.Scanner;

public class ArrayAdd {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4};
        Scanner sc = new Scanner(System.in);

        do {
            // 创建新数组，系统默认初始化数组元素都为0
            int[] newArr = new int[arr.length + 1];

            // 拷贝原数组arr中的左右元素到新数组newArr
            for (int i = 0; i < arr.length; i++) {
                newArr[i] = arr[i];
            }

            // 在新数组末尾添加元素
            System.out.print("请输入你要添加的数（要求为整数）：");
            newArr[newArr.length - 1] = sc.nextInt();

            // 将数组引用指向新数组
            arr = newArr;
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }

            System.out.println("添加成功！是否继续添加？ y / n");

            // 错误！
            // sc.next()方法在条件结构中重复调用，系统会一直等待用户输入，造成逻辑错误
            // if (sc.next().equals("n")) {
            //     System.out.println("你已退出添加！");
            //     break;
            // } else if (sc.next().equals("y")) {
            //     System.out.print("好的，继续添加！");
            // } else {
            //     System.out.println("输出错误！添加停止！");
            //     break;
            // }

            String str = sc.next();
            if (str.equals("n")) {
                System.out.println("你已退出添加！");
                break;
            } else if (str.equals("y")) {
                System.out.print("好的，继续添加！");
            } else {
                System.out.println("输出错误！添加停止！");
                break;
            }
        } while(true);

        sc.close();
    } 
}

/* 运行结果：
--------------------------------
请输入你要添加的数（要求为整数）：12
1 3 4 12 添加成功！是否继续添加？ y / n
y
好的，继续添加！请输入你要添加的数（要求为整数）：34
1 3 4 12 34 添加成功！是否继续添加？ y / n
y
好的，继续添加！请输入你要添加的数（要求为整数）：56
1 3 4 12 34 56 添加成功！是否继续添加？ y / n
y
好的，继续添加！请输入你要添加的数（要求为整数）：90
1 3 4 12 34 56 90 添加成功！是否继续添加？ y / n
n
你已退出添加！
--------------------------------
*/