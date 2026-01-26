// 功能：一个char型的26个元素的数组，分别放置'A' - 'Z'。使用for循环访问所有元素并打印出来
// 目的：了解数组：
// （1）索引就是偏移量
// （2）数组中的每一个元素其实就是一个变量，只不过这些变量的数据类型是相同的

public class Array01 {
    public static void main(String[] args) {
        
        char[] arr = new char[26];

        // 循环体内字符串拼接使用 StringBuilder，而不使用 + ，因为加号运行期会创建新空间
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {

            arr[i] = (char)('A' + i);
            sb.append(arr[i]).append(" ");
        }

        System.out.println(sb.toString());

    }
}

/* 输出结果：
*************************************
A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
*************************************
*/
