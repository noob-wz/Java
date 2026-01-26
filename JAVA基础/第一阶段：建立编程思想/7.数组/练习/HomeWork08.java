// 功能：给定数组 {0, 1, 0, 3, 12}，把所有 0 移到末尾，保持非零元素顺序。结果应为 {1, 3, 12, 0, 0}。
// 目的：了解双指针

public class HomeWork08 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        int[] newArr = new int[arr.length];

        int writeIdx = 0;
        for(int readIdx = 0; readIdx < arr.length; readIdx++) {
            if (arr[readIdx] != 0) {
                newArr[writeIdx] = arr[readIdx];
                writeIdx++;
            }
        }

        while(writeIdx < newArr.length) {
            newArr[writeIdx] = 0;
            writeIdx++;
        }
    }
}
