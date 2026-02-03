package com.houserent.utils;

import java.util.Scanner;

/**
 * 工具类：处理各种键盘输入
 * 作用：解决 Scanner 的坑，提供健壮的输入校验
 */
public class Utility {
    private static Scanner scanner = new Scanner(System.in);

    /**
     * 读取菜单选择（1-5）
     */
    public static char readMenuSelection() {
        char c;
        for (; ; ) {
            // readKeyBoard 是核心私有方法，下面有定义
            String str = readKeyBoard(1, false);
            c = str.charAt(0);
            if (c != '1' && c != '2' && c != '3' && c != '4' && c != '5' && c != '6') {
                System.out.print("选择错误，请重新输入：");
            } else {
                break;
            }
        }
        return c;
    }

    /**
     * 读取一个字符
     */
    public static char readChar() {
        String str = readKeyBoard(1, false);
        return str.charAt(0);
    }

    /**
     * 读取一个字符，如果回车则返回默认值
     */
    public static char readChar(char defaultValue) {
        String str = readKeyBoard(1, true);
        return (str.length() == 0) ? defaultValue : str.charAt(0);
    }

    /**
     * 读取整数
     */
    public static int readInt() {
        int n;
        for (; ; ) {
            String str = readKeyBoard(10, false);
            try {
                n = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.print("数字输入错误，请重新输入：");
            }
        }
        return n;
    }

    /**
     * 读取整数，如果回车则返回默认值
     */
    public static int readInt(int defaultValue) {
        int n;
        for (; ; ) {
            String str = readKeyBoard(10, true);
            if (str.equals("")) {
                return defaultValue;
            }
            try {
                n = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.print("数字输入错误，请重新输入：");
            }
        }
        return n;
    }

    /**
     * 读取字符串（指定长度）
     */
    public static String readString(int limit) {
        return readKeyBoard(limit, false);
    }

    /**
     * 读取字符串（指定长度），如果直接回车，则返回默认值
     * 【核心功能】：用于修改界面，保留原值
     */
    public static String readString(int limit, String defaultValue) {
        String str = readKeyBoard(limit, true);
        if (str.equals("")) {
            return defaultValue;
        }
        return str;
    }

    /**
     * 读取确认选择（Y/N）
     */
    public static char readConfirmSelection() {
        char c;
        for (; ; ) {
            // 这里为了把 next() 的坑填上，统一转换成大写
            String str = readKeyBoard(1, false).toUpperCase();
            c = str.charAt(0);
            if (c == 'Y' || c == 'N') {
                break;
            } else {
                System.out.print("选择错误，请重新输入：");
            }
        }
        return c;
    }

    /**
     * 【核心底层方法】
     * 所有的输入都走这里，统一用 nextLine() 读取，避免回车符问题
     * @param limit 长度限制
     * @param blankReturn 是否允许空回车
     */
    private static String readKeyBoard(int limit, boolean blankReturn) {
        String line = "";
        while (scanner.hasNextLine()) {
            line = scanner.nextLine(); // 吞掉回车，读取一行

            // 如果长度为0 (也就是用户只按了回车)
            if (line.length() == 0) {
                if (blankReturn) return line; // 如果允许空回车，返回空串
                else continue; // 不允许，就继续循环等待输入
            }

            if (line.length() < 1 || line.length() > limit) {
                System.out.print("输入长度（不能大于" + limit + "）错误，请重新输入：");
                continue;
            }
            break;
        }
        return line;
    }
}