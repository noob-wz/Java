// 功能：求1-1/2+1/3-1/4+...-1/100的和
// 目的：了解算数运算隐式类型转换的陷阱

public class HomeWork04 {
    public static void main(String[] args) {
        int totalSum = 0;
        for(int i = 1; i <= 100; i++) {
            for (int j = 1; j <= i; j++) {
                totalSum += j;
            }
        }
        System.out.println("和为："+ totalSum);
    }
}
