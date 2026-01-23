// 功能：将个人信息打印输出
// 目的：考察对转义字符的使用 以及 java两种不同输出方法的区别

public class Homework01 {
    public static void main(String[] args){
        System.out.println("姓名\t性别\t籍贯\t住址"); // println 输出内容的同时在字符串末尾加\n
        System.out.println("汪曾\t男\t安徽\t上海");

        // 等价于

        /*
        System.out.print("姓名\t性别\t籍贯\t住址\n"); // print只输出内容不换行
        System.out.print("汪曾\t男\t安徽\t上海"); 
        */

        // 等价于
        // System.out.println("姓名\t性别\t籍贯\t住址\n汪曾\t男\t安徽\t上海"); // 和上面两行代码等价
    }
}

/* 运行结果：
--------------------------------
姓名    性别    籍贯     住址
汪曾    男      安徽    上海
--------------------------------
*/