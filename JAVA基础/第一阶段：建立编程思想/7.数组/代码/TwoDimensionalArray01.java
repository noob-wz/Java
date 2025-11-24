// 功能：遍历二维数组
// 目的：通过遍历二维数组，了解二维数组在内存中的结构

public class TwoDimensionalArray01 {
    public static void main(String[] args) {
        int[][] arr = {
            {0,0,0,0,0,0},
            {0,0,1,0,0,0},
            {0,2,0,3,0,0},
            {0,0,0,0,0,0}
        };
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 6; j++) {
                System.out.print("arr[" + i + "][" + j + "]=" + arr[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("二维数组中共有元素" + arr[0].length * arr.length + "个");
    }
}

/* 运行结果：
--------------------------------
arr[0][0]=0 arr[0][1]=0 arr[0][2]=0 arr[0][3]=0 arr[0][4]=0 arr[0][5]=0 
arr[1][0]=0 arr[1][1]=0 arr[1][2]=1 arr[1][3]=0 arr[1][4]=0 arr[1][5]=0 
arr[2][0]=0 arr[2][1]=2 arr[2][2]=0 arr[2][3]=3 arr[2][4]=0 arr[2][5]=0 
arr[3][0]=0 arr[3][1]=0 arr[3][2]=0 arr[3][3]=0 arr[3][4]=0 arr[3][5]=0 
二维数组中共有元素24个
--------------------------------
*/
