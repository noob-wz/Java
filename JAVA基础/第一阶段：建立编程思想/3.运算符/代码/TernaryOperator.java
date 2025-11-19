// 功能：找到三个数中的最大数
// 目的：了解条件运算符的使用

public class TernaryOperator {
    public static void main(String[] args) {
        double a = 10.0;
        int b = 1;
        float c = 5F;
        double result;
        
        // 尽量不要嵌套使用条件运算符，逻辑不清晰
        // result = (a > b ? a : b) > c ? (a > b ? a : b) : c; 

        result = a > b ? a : b;
        result = result > c ? result : c;

        System.out.println("a, b, c三个数中最大的数是：" + result);
    }
}
