// 功能：一个char型的26个元素的数组，分别放置'A' - 'Z'。使用for循环访问所有元素并打印出来
// 目的：了解数组：
// （1）索引就是偏移量
// （2）数组中的每一个元素其实就是一个变量，只不过这些变量的数据类型是相同的

public class Array01 {
    public static void main(String[] args) {
        
        char[] arr = new char[26];
        arr[0] = 'A';

        for (int i = 0; i < 26; i++) {
            arr[i] = (char)('A' + i); // 整型变量不可以赋值给字符型变量
            System.out.print(arr[i] + " ");
        }

    }
}
