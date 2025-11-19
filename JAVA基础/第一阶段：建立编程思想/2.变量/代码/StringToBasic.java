// 目的：了解基本数据类型和String数据类型的转换

/* TODO(2025-11-17 11:36:22) 
 * 
 * 总结：
 * 第一种：Basic to String
 *      方法1：使用+，两边操作数只要包含一个String类型，其功能会被重载为字符串连接
 *      方法2：使用包装类的toString()方法
 *      方法3：使用 String.valueOF() 方法 ，推荐！
 * 第二种：String to Basic
 *      核心方法：使用包装类的 parseXX()方法
 */

public class StringToBasic {
    public static void main(String[] args) {

        // 第一种情况：基本数据类型 转化成 String类型
        int n1 = 100;
        float f1= 1.1F;
        double d1 = 4.5;
        boolean b1 = true;

        // 方法1: 使用 + 。当+两边的操作数只要任一是String类型，加号的功能会被重载为字符串连接
        String s1 = n1 + ""; 
        String s2 = d1 + "";
        String s3 = b1 + "";
        String s4 = f1 + "";

        System.out.println(s1 + " " + s2 + " " + s3 + " " +s4);

        // 方法2: 使用 String.valueOf() 方法
        String s5 = String.valueOf(n1); // 如果 n1 没有转化成字符串，编译就会报错
        System.out.println(s5); 

        // 方法3: 使用包装类的 toString() 方法
        String s6 = Integer.toString(n1); // 如果 n1 没有转化成字符串，编译就会报错
        String s7 = Float.toString(f1); // 如果 f1 没有转化成字符串，编译就会报错
        System.out.println(s6); 
        System.out.println(s7);

        // 第二种情况：String 转 基本数据类型
        String s8 = "10000";

        // 核心方法： 包装类的 parseXX方法
        int n2 = Integer.parseInt(s8); // 如果s8没有转化为整数类型，那么编译器就会报类型转换错误
        System.out.println(n2);
    }
}

/* 运行结果：
--------------------------------
100 4.5 true 1.1
100
100
1.1
10000
--------------------------------
*/