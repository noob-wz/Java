// 功能：动态创建不规则二维数组
// 目的：了解不规则二维数组的声明和初始化

public class TwoDimensionalArray02 {
    public static void main(String[] args) {
        int[][] arr = new int[3][];

        for(int i = 0; i < 3; i++) {
            arr[i] = new int[i+1];
            for(int j = 0; j < arr[i].length; j++) {
                arr[i][j] = i + 1;
            }
        }
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
