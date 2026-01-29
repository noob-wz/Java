// 功能：定义一个Person类{name,age,job},初始化Person对象数组，有3个person对象，并按照age从大到小排列，要求：使用冒泡排序

package com.wz.homework01;

public class HomeWork01 {
    public static void main(String[] args) {

        Person[] p = {
                new Person("小王", 17, "厨师"),
                new Person("小李", 22, "飞行员"),
                new Person("小黑", 37, "老师")
        };

        for (int i = 0; i < p.length - 1; i++) {
            for (int j = 0; j < p.length - 1 - i; j++) {
                if (p[j].age < p[j + 1].age) {

                    // ⚠️ Person 在这里只是引用变量声明，右边没有 new 空间。小心当成生成新建堆空间
                    Person temp = p[j];
                    p[j] = p[j + 1];
                    p[j + 1] = temp;
                }
            }
        }

        // 打印对象信息
        for (int i = 0; i < p.length; i++) {
            // 方式1 ：自行拼接字符串
            // System.out.println(p[i].name + " " + p[i].age + " " + p[i].job);
            // 方式2 ：利用toString()方法
            System.out.println(p[i].toString());

        }
    }
}
