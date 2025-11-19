// 目的：初步了解键盘输入语句的使用步骤

/* TODO(2025-11-18 11:42:30) 
 * 
 * 步骤：
 * （1）导入外部java.util包下的类
 * （2）创建实例 —— 声明和初始化
 * （3）读取数据
 * （4）关闭对象
 */

import java.util.Scanner; // 把java.util包下的Scanner类导入

public class Input {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 相当于
        // Scanner scanner = null; // 初始化scanner（初始化包含声明） —— 栈内存中为引用变量 scanner 预留分配空间，但不指向任何对象
        // scanner = new Scanner(System.in); // 赋值 在堆内存（Heap）中创建并初始化一个新的 Scanner 对象，并把它的内存地址赋给scanner变量

        System.out.print("请输入你的名字：");
        
        String name = scanner.nextLine();
        System.out.println("你的名字是" + name);

        scanner.close();

    }
}
