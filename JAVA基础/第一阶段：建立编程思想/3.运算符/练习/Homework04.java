// 功能：求1-1/2+1/3-1/4+...-1/100的和
// 目的：了解算数运算隐式类型转换的陷阱

public class Homework04 {
    public static void main(String[] args) {
        double sum = 0d;
        for(int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                sum += -1.0 / i;
                // 或者 sum += 1.0d / i     or     sum += 1d / i
                // 或者 sum += (double)1 / i
            } else {
                sum += 1.0 / i;
            }
        }
        System.out.println("和为："+ sum);
    }
}
