import java.util.Scanner;

public class Pyramid03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入空心金字塔层数: ");
        int totalLevel = sc.nextInt();

        // 外部循环：控制行数 (i 必须从 1 到 totalLevel)
        for (int i = 1; i <= totalLevel; i++) {
            
            // 步骤 1: 打印左侧空格 (所有行都遵循统一的简化公式)
            // 空格数 = totalLevel - i
            for (int j = 1; j <= totalLevel - i; j++) {
                System.out.print(" ");
            }
            
            // 步骤 2: 【化繁为简】处理行内容 (使用 if-else if-else 分解)
            
            // --- 模式一：第一行（顶点）---
            if (i == 1) {
                System.out.print("*");
            
            // --- 模式二：最后一行（底部）---
            } else if (i == totalLevel) {
                // 打印 2*i - 1 个星号
                for(int j = 1; j <= 2*i - 1; j++) {
                    System.out.print("*");
                }
                
            // --- 模式三：中间行（空心部分）---
            } else {
                // 打印左侧的星号
                System.out.print("*");
                
                // 打印中间的空格，数量是 2*i - 3
                for (int j = 1; j <= 2*i - 3; j++) {
                    System.out.print(" ");
                }
                
                // 打印右侧的星号
                System.out.print("*");
            }
            
            // 步骤 3: 统一换行
            System.out.println();
        }

        sc.close();
    }
}