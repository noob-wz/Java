// 功能：1～100以内的数求和，并且求出当第一次大于20的当前数

// 分析：既要求1-100的数的和，又要找到第一次和大于20的数。换句话说，不能用break中断循环，又要
//      只输出第一次的数。怎么办？
// 解决办法：布尔标记。当第一次找到这个数时，做两件事，打印这个数，并且把开关锁死，防止后续再继续触发打印。

public class Break02 {
    public static void main(String[] args) {
        int sum = 0;

        // 定义标记位：表示“是否找到了目标”
        boolean isFound = false;

        for (int i = 0; i <= 100; i++) {
            sum += i;

            // 双重判断条件
            // 条件A ：sum > 20
            // 条件B : 之前必须没有找到过
            if (sum > 20 && !isFound) {
                // !isFound 等价于 isFound == false

                System.out.println("当在加到" + i + "时，第一次和大于20！");

                // 关键步骤：把标记改为 true
                // 下一次循环时，条件B (!isFound) 就不满足了，也就不会再进来了
                isFound = true;
            }
        }
        System.out.println("和：" + sum);
    }
}

/* 运行结果：
--------------------------------
当在加到6时，第一次和大于20！
和：5050
--------------------------------
*/
