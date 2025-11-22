// 目的：了解转义字符的使用
// 功能：输出一些字符串

/* TODO(2025-11-14 22:39:29) 
 * 
 * 总结：
 * 1、转义字符表示那些具有特殊含义或者键盘上无法直接输入的字符
 * 2、Java提供两套标准输出方法 println 和 print，区别在于是否进行换行。
 *      前者是 “输出内容+换行”，后者 “只输出内容”
 */

public class ChangeChar {
    public static void main(String[] args) {
        // 插入 换行符\n 和 制表符\t
        // 问： 为什么字符串可以输出换行符？照理说换行符是属于字符
        // 编译的时候就已经将字符串中所有的字符包括换行符二进制码存储到内存中，运行输出时一个接一个地把字符发送到输出流
        System.out.println("姓名\t年龄\t城市"); 
        System.out.println("张三\t25\t北京\n");

        // 插入双引号 \"
        // 如果不用转义字符，编译器会认为第一个双引号结束了字符串
        System.out.println("他说：\"Java 很有用。\"");

        // 插入反斜杠 \\
        System.out.println("文件路径是: C:\\Users\\Public\\Doc");

        // Unicode转义
        // \u4f60 代表“你”这个中文字符的 Unicode 码点
        System.out.println("Unicode 示例: \u4f60\u597d");
    }
}

/* 运行结果：
--------------------------------
名    年龄    城市
张三    25      北京

他说："Java 很有用。"
文件路径是: C:\Users\Public\Doc
Unicode 示例: 你好
--------------------------------
*/