// 目的：了解可变参数的使用
// 功能：计算传入参数的和

public class VarParameter01 {
    public static void main(String[] args) {
        HspMethod n = new HspMethod();
        System.out.println(n.sum(12,12,34,56));
    }
}

class HspMethod {
    public int sum(int... nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }
}