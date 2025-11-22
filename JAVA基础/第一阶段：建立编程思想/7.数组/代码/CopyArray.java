// 目的：了解数组复制的四种方法
import java.util.Arrays;

public class CopyArray {
    public static void main(String[] args) {
        // 原数组 arr1
        int[] arr1 = {10, 23, 30};

        // 创建新的数组对象，并将新的对象地址赋给引用变量arr2(独立空间)
        // 数组对象在口语中一般简化为数组，但这里的数组本质上是数组对象，而不是引用变量
        int[] arr2 = new int[arr1.length]; // 数组的长度是固定的，所以新数组长度要和原数组保持一致
        int[] arr3 = new int[arr1.length];
        int[] arr4;
        int[] arr5;

        // 方法1: 利用 for 循环遍历，将原数组中的元素拷贝到新数组
        // 所有方法的根本原理
        for (int i = 0; i <= arr1.length - 1; i++) {
            arr2[i] = arr1[i];
            System.out.print("arr2[" + i + "]=" + arr2[i] + " ");
        }
        System.out.println("");

        // 方法2: 使用系统自带的System.arraycopy()方法
        //               原数组地址 起始位置  新数组地址 起始位置 拷贝长度
        System.arraycopy(arr1, 0, arr3, 0, arr1.length);
        for (int i = 0; i <= arr3.length - 1; i++) {
            System.out.print("arr3[" + i + "]=" + arr3[i] + " ");
        }
        System.out.println("");

        // 方法3: 使用Arrays.copyOf()方法
        // 1. 该方法 自动创建并返回指定长度 的数组
        // 2. 将原数组拷贝到新数组中
        arr4 = Arrays.copyOf(arr1, arr1.length);
        for (int i = 0; i <= arr4.length - 1; i++) {
            System.out.print("arr4[" + i + "]=" + arr4[i] + " ");
        }
        System.out.println("");
        

        // 方法4: 调用 clone() 并进行强制类型转换
        arr5 = arr1.clone();
        for (int i = 0; i <= arr5.length - 1; i++) {
            System.out.print("arr5[" + i + "]=" + arr5[i] + " ");
        }
    }
}

/* 运行结果：
--------------------------------
arr2[0]=10 arr2[1]=23 arr2[2]=30 
arr3[0]=10 arr3[1]=23 arr3[2]=30 
arr4[0]=10 arr4[1]=23 arr4[2]=30 
arr5[0]=10 arr5[1]=23 arr5[2]=30 
--------------------------------
*/