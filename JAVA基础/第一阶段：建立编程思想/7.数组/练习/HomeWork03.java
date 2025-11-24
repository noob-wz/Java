// 目的：
// （1）了解编码规范：
//      a. 计算和输出部分的代码分离
//      b. 使用boolean hasEight 替换 int flag作为标记，意图更加清晰
// （2）大概了解 Integer.MIN_VALUE 和 Integer.MAX_VALUE的使用


public class HomeWork03 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        
        // 使用布尔类型数据来确定是否有 8，很清晰，而不是用1或-1
        // int flag = -1;
        boolean hasEight = false;

        // 最大最小值使用极值或者数组的第一个数
        int max = Integer.MIN_VALUE; 
        int min = Integer.MAX_VALUE;

        int sum = 0;
        int maxIndex = -1;
        int minIndex = -1;

        System.out.print("原数组是：");
        for (int i = 0; i < 10; i++) {
            arr[i] = (int)(Math.random() * 100 + 1);

            // 判断是否有 8
            if (arr[i] == 8) {
                hasEight = true;
            }
            // 求和
            sum += arr[i];

            // 确定最大最小值的索引
            if (max < arr[i]) {
                max = arr[i];
                maxIndex = i;
            }
            if (min > arr[i]) {
                min = arr[i];
                minIndex = i;
            }

            System.out.print(arr[i] + " ");
        }
        System.out.println("");


        System.out.print("数组倒序是：");
        // 数组倒序显示。计算逻辑和输出部分代码分离
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");

        System.out.println("数组所有数的平均值是: " + (double)sum / arr.length + ", 最大值的下标是：" + maxIndex + ", 最小值的下标是：" + minIndex);
        if (hasEight) {
            System.out.println("数组中有8！");
        } else {
            System.out.println("数组中没有8！");
        }
    }
}
