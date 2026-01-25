// 目的： 判断下面的赋值语句是否正确

public class Homework02 {
    public static void main(String[] args) {
//        int num1 = (int)"18"; // 错误，要使用 Interger.parseInt("18")
//        int num2 = 18.0; // 错误，double赋值给int，类型不匹配。要直接用 18 或者（int)18.0
        double num3 = 3d; // 正确。d的作用是定义数值类型为double
        double num4 = 8; // 正确。会发生隐式类型转换

        int i = 48;
//        char ch = i + 1; // 错误。高精度数据类型赋值给低精度，数据类型不匹配

        byte b = 19; // 正确。字面量整数的数值大小编译期就已经确定，不会改变，且其使用空间在byte数据类型的有限范围内，JVM会进行隐式转换
//        short s = b + 2; // 错误，算数运算中最低的数据类型为int，也就是说表达式 b+2中的b会提升为int，表达式结果也为int，赋值给低精度类型不匹配
    }
}
