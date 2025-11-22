import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};

        Scanner sc = new Scanner(System.in);

        do {
            int[] newArr = new int[arr.length-1];
            for (int i = 0; i < newArr.length; i++) {
                newArr[i] = arr[i];
            }
            arr = newArr;
            System.out.print("缩减后的数组为：");
            for (int i = 0; i < arr.length; i++) {
                System.out.print("arr[" + i + "]=" + arr[i] + " ");
            }
            System.out.println("");

            if (arr.length > 1) {
                System.out.print("缩减完成！是否继续缩减？ y/n");
                if (sc.next().charAt(0) == 'y') {
                    System.out.println("好的，继续缩减！");
                } else {
                    System.out.println("退出缩减！");
                    break;
                }
            } else {
                System.out.println("已经不能再缩减！");
            }
            
        } while(true);

        sc.close();
    }
}