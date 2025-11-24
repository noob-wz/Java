// 功能：打印杨辉三角
public class YangHui {
    public static void main(String[] args) {
        int[][] arr = new int[10][];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = new int[i + 1];
            for(int j = 0; j < arr[i].length; j++) {
                if(j == 0 || j == arr[i].length - 1) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = arr[i-1][j] + arr[i-1][j-1];
                }
            }
        }
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println("");
        }
    }
}

/* 运行结果：
--------------------------------
1	
1	1	
1	2	1	
1	3	3	1	
1	4	6	4	1	
1	5	10	10	5	1	
1	6	15	20	15	6	1	
1	7	21	35	35	21	7	1	
1	8	28	56	70	56	28	8	1	
1	9	36	84	126	126	84	36	9	1
--------------------------------
*/