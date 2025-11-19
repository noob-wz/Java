// 目的：了解 String的存储和输出机制

// 功能：
// 实现如下效果：
// 姓名    年龄    成绩    性别    爱好
// XX      XX     XX     XX      XX

// 要求：
// 1.用变量将姓名、年龄、成绩、性别、爱好存储
// 2.使用+
// 3.添加适当的注释
// 4.添加转义字符，使用一条语句输出

/* TODO(2025-11-17 13:10:38) 
 * 
 * 总结：
 *  字符串存储和输出是把字符串分为一个个“字符单元”，然后按每一个字符对应unicode码点值进行存储，然后输出时，通过工具把字符码点值进行对应“图形显示”或“功能输出”
 */

public class Homework01 {
    public static void main(String[] args) {
        String name = "jack";
        int age = 27;
        double score = 100.0;
        char gender = '男';
        String hobby = "swimming";

        // 字符串存储是把字符串分为一个个“字符单元”，然后按每一个字符对应unicode码点值进行存储，然后输出时，通过工具把字符码点值进行对应“图形显示”或“功能输出”
        System.out.println("姓名\t年龄\t成绩\t性别\t爱好\n" + 
            name + "\t" + age + "\t" + score + "\t" + gender + "\t" + hobby);
    }
}

/* 运行结果：
--------------------------------
姓名	年龄	成绩	性别	爱好
jack	27	100.0	男	swimming
--------------------------------
*/