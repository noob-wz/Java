// 功能更：1～100以内的数求和，求出当和第一次大于20的当前数

public class Break02 {
    public static void main(String[] args) {

        for(int i = 1, sum = 0; i <= 100; i++) {
            sum += i;
            if (sum > 20) {
                System.out.println("当在加到" + i + "时，第一次和大于20！");
                break;
            }
        }
    }
}

/* 运行结果：
--------------------------------
当在加到6时，第一次和大于20！
--------------------------------
*/
