// 目的：利用 debug 找到代码异常点。
//  以异常点所在行为基点：
//      （1）在 还没F8步过 的时候，变量界面就会提醒异常。
//      （2）在 F8步过之后，变量界面结束提醒找不到变量。而在 console 控制台界面会输出异常

package com.wz.debug_;

public class Debug02 {
    public static void main(String[] args) {

        // debug 数组
        int[] arr = {1, 2, 14, 13, 34, 15, 98};
        for (int i = 0; i <= arr.length; i++) {
            System.out.println("arr[" + i + "] = " + arr[i]);
        }
    }
}
