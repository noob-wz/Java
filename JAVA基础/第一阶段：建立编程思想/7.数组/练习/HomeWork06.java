// 功能：编写类A03，实现数组的赋值功能copyArr，输入旧数组，返回一个新数组，元素和旧数组一样
// 目的：回顾数组拷贝的四种方式

import java.util.Arrays;

public class HomeWork06 {
    public static void main(String[] args) {
        A03 a = new A03();
        int[] arr = {10, 49, 3, 32, 11};
        int[] newArr1 = a.copyArr1(arr);
        int[] newArr2 = a.copyArr2(arr);
        int[] newArr3 = a.copyArr3(arr);
        int[] newArr4 = a.copyArr4(arr);
        int[][] arrays = {newArr1, newArr2, newArr3, newArr4};

        for(int i = 0; i < arrays.length; i++) {
            System.out.print("newArr" + (i + 1) + ": ");
            for (int j = 0; j< arrays[i].length; j++) {
                System.out.print(arrays[i][j] + "\t");
            }
            System.out.println();
        }
    }
}

class A03 {
    // 手动复制数组
    int[] copyArr1(int[] arr) {
        int[] newArr = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }

        return newArr;
    }

    // Arrays.copyOf(源数组，新长度)
    int[] copyArr2(int[] arr) {
        
        return Arrays.copyOf(arr, arr.length);
    }

    // System.arraycopy(源数组, 源起始位置, 目标数组, 目标起始位置, 拷贝长度)
    int[] copyArr3(int[] arr) {
        int[] newArr = new int[arr.length];
        System.arraycopy(arr, 0, newArr, 0, arr.length);

        return newArr;
    }

    // clone()
    int[] copyArr4(int[] arr) {
        return arr.clone();
    }
}

/* 运行结果：
--------------------------------
newArr1: 10	49	3	32	11	
newArr2: 10	49	3	32	11	
newArr3: 10	49	3	32	11	
newArr4: 10	49	3	32	11
--------------------------------
*/
