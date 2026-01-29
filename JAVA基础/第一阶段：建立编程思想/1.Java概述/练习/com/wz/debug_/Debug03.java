package com.wz.debug_;

import java.util.Arrays;

public class Debug03 {
    public static void main(String[] args) {

        // debug 源码
        int[] arr = {8, -1, 199, 70, 10};

        // 排序，追入 sort 的源码
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + "\t");
        }
    }
}
