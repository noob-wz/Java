// 功能：遍历二维数组，并求和

public class TwoDimensionalArray03 {
    public static void main(String[] args) {
        int[][] arr = {
            {4, 6},
            {1,4,5,7},
            {-2}
        };
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                sum += arr[i][j];
            }
        }
        System.out.println("数组中所有元素的和为：" + sum);
    }
}
