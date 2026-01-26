// 功能：求出数组int[]的最大值{4,-1,9,10,23}，并得到对应的下标

public class Array02 {
    public static void main(String[] args) {
        int[] arr = {4, -1, 9, 10, 23};

        int max = arr[0];
        int index = 0;

        for(int i = 1; i <= 4; i++) {
            if (max < arr[i]) {
                max = arr[i];
                index = i;
            }
        }

        System.out.println("数组中最大的数是：" + max + " ，对应的数组索引是：" + index);
    }
}
/* 运行结果：
--------------------------------
数组中最大的数是：23 ，对应的数组索引是：4
--------------------------------
*/
