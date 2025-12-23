
public class MiGong {
    public static void main(String[] args) {

        // 思路：
        // 1. 先用二维数组创建一个迷宫；
        // 2. 规定迷宫中有障碍的地方为1，无障碍的地方为0；
        int[][] map = new int[8][7];

        // 3. 让迷宫最上面的一行和最下面的一行初始化为 1，即有障碍
        for(int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }

        // 4. 让迷宫最左边的一列和最右边的一列初始化为 1，和个别元素设置为1
        for(int i = 1; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;

        // 5.使用递归回溯的思想解决老鼠出迷宫
        T way = new T();
    }
}
class T {
    
}