// 功能：冒泡排序从小到达排列 数组{24, 69, 80, 57, 13}

// 思路：
//（1）冒泡排序的思想是，每一次循环都把最大（或最小）的数找出来，需要用到嵌套循环，那么就用嵌套循环的思想来设计程序
// (2) 定维度：
//      a. 外部循环几次，决定了需要冒泡几次。如果从小到大排列，我每次都找到最大的数，那么我就需要冒泡4次，就能确定最终大小顺序。
//      b. 内部循环对应每一次冒泡需要具体怎么做
// (3) 冻结态: 先写出每一次固定i，j的最大边界，然后看哪部循环具体如何实现
//      i               j的最大边界（即每一次固定i，内部循环需要循环几次）
//      0               4
//      1               3
//      2               2
//      3               1
// (4) 找关系：i + j = 4
// (5) 理状态：i,j,temp 都遵循最小作用域原则

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {24, 69, 80, 57, 13};

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0, temp; j < arr.length - i - 1; j++) {
                if(arr[i] > arr[i + 1]) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }




        for (int i = 0; i < arr.length; i++) {
            System.out.print("arr[" + i + "]=" + arr[i] + " ");
        }
    }
}
