// 功能：经典猴子吃桃问题： 猴子第一天摘了若干桃子，每天吃掉桃子总数的一半再加一个，到第10天早上发现只剩1个桃子。问第一天摘了多少个桃子？
// 目的：小心递归的陷进。正确的递归设计应该遵循 “先计算、后使用” 的原则，将递归调用的结果存储在一个临时变量中，然后使用该变量进行计算和返回。

public class Recursion04 {
    public static void main(String[] args) {
        eatPeach(1);
    } 

    public static int eatPeach(int day) {
        
        if (day == 10){
            System.out.println("第10天还剩桃子1个");
            return 1;
        } 

        // 错误用法，两次调用eatPeach(day + 1) + 1)
        // System.out.println("第" + day + "天还剩桃子" +  (eatPeach(day + 1) + 1) * 2 + "个");
        // return (eatPeach(day + 1) + 1) * 2;
        
        // 正确用法：先计算，后使用
        int currentDayPeach = (eatPeach(day + 1) + 1) * 2;
        System.out.println("第" + day + "天还剩桃子" +  currentDayPeach + "个");

        return currentDayPeach;
    }
}

/* 运行结果：
--------------------------------
第10天还剩桃子1个
第9天还剩桃子4个
第8天还剩桃子10个
第7天还剩桃子22个
第6天还剩桃子46个
第5天还剩桃子94个
第4天还剩桃子190个
第3天还剩桃子382个
第2天还剩桃子766个
第1天还剩桃子1534个
--------------------------------
*/
