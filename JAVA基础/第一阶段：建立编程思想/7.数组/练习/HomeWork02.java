// 功能：已知有一个升序数组，要求插入一个元素，该数组顺序依然是升序。比如：
// {10,12,45,90}，添加23后，数组依然为升序

// 思路：
// （1）先找出要插入的位置，这个位置用index来标记
// （2）对原数组进行扩容，根据标记，来差异化赋值。此处有两种实现方式：
//       1. 方式1: 结构化拆解。通过比较当前遍历索引 i 与分界点 index 的关系，将整个赋值过程清晰地划分为三个互斥的区域
//       2. 方式2: 游标的同步和错位

/* 目的：理解结构化拆解；理解双指针的同步和错位
 */


public class HomeWork02 {
    public static void main(String[] args) {
        int[] arr = {10, 12, 45, 90};
        int[] newArr = new int[arr.length + 1];
        int index = -1; // 如果不初始化，就没有明确赋值，编译器就会报错

        for(int i = 0; i < arr.length; i++) {
            if(23 <= arr[i]) {
                index = i;
                break;
            }
        }

        if(index == -1) {
            index = arr.length;
        }

        System.out.println("方式1: ");
        // 方式1 根据索引不同，结构化拆解
        for(int i = 0; i < newArr.length; i++) {
            if(index > i) {
                newArr[i] = arr[i];
            } else if(index == i) {
                newArr[i] = 23;
            } else {
                newArr[i] = arr[i - 1];
            }
            System.out.print(newArr[i] + " ");
        }
        
        System.out.println("");
        System.out.println("方式2: ");
        // 方式2 双指针的同步与错位
        for(int i = 0, j = 0; i < newArr.length; i++){
            if(i != index) {
                newArr[i] = arr[j];
                j++;
            } else {
                newArr[i] = 23;
            }
            System.out.print(newArr[i] + " ");
        }
    }
}
