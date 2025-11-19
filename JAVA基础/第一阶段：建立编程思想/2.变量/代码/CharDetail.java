public class CharDetail {
    public static void main(String[] args) {
        // 无论是 普通英文字符、 转义字符、中文字符、数字本身都会转化成unicode的码点值（十进制），然后以二进制存储在计算机中
        // 因为数据类型，所以计算机能够把存储在计算机中的二进制数据以不同的形式输出显示
        char a = 'a';
        char b = '\t';
        char c = '汪';
        char d = 97;   // 字符存储到计算机要经过： 转化成unicode码点值 --> 存储为二进制。直接给整数相当于跳过了第一步

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);  // 输出a ，计算机存的是unicode的码点值，输出根据数据类型来显示
        System.out.println('A' + 12); // char类型数据可以进行算数运算，会自动升级为int类型
        System.out.println("A" + 12); // 输出A12，注意char类型参与运算和String类型参与运算的区别
    }
}

/* 运行结果：
--------------------------------
a
	
汪
a
77
A12
--------------------------------
*/
