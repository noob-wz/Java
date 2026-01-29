// 目的：了解断点调试三大法宝之一：看变量（F8逐行执行）。且有两种方式：
//          方法1: 变量界面
//          方法2: 鼠标放在变量上

package com.wz.debug_;

public class Debug01 {
    public static void main(String[] args) {

        // debug 数组
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += i;
            System.out.println(" i = " + i);
            System.out.println(" sum = " + sum);
        }

        System.out.println("end...");
    }
}
