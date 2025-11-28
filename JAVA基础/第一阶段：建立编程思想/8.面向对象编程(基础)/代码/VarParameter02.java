// 功能：有三个方法，分别实现返回姓名和两门课成绩（总分），返回姓名和三门课成绩（总分），返回姓名和五门课成绩（总分）。封装成一个可变参数的方法
// 目的：了解可变参数直接传入数组的注意点，必须传入的是数组的引用

public class VarParameter02 {
    public static void main(String[] args) {
        HspMethod hsp = new HspMethod();

        // 错误写法！编译器会报错，因为它无法判断  {20, 30, 80, 110, 70} 到底是什么类型（是 int[] 还是 double[] 还是其他）。这种 {...} 简写形式，只有在 定义数组变量时 或 创建匿名数组时 才能使用。
        // hsp.showScore("汪曾", {20, 30, 80, 110, 70});

        // 方式1：零散传入所有变量
        System.out.println("方式1" + hsp.showScore("汪曾", 20, 30, 80, 110, 70));

        // 方式2: 提前存好数组
        int[] scores = {20, 30, 80, 110, 70};
        System.out.println("方式2" + hsp.showScore("汪曾", scores));

        // 方式3：告诉编译器这是一个新的数组
        System.out.println("方式3" + hsp.showScore("汪曾", new int[]{20, 30, 80, 110, 70}));
    }
}

class HspMethod {
    public String showScore(String name, int... scores) {
        int sum = 0;
        for(int i = 0; i < scores.length; i++) {
            sum += scores[i];
        }
        return "姓名: " + name + " 总分: " + sum;
    }
}

/* 运行结果：
--------------------------------
方式1姓名: 汪曾 总分: 310
方式2姓名: 汪曾 总分: 310
方式3姓名: 汪曾 总分: 310
--------------------------------
*/