// 功能：将数组的元素反转

public class ArrayReverse {
    public static void main(String[] args) {
        int[] arr = {66, 55, 44, 33, 22, 11};

        // 方法一： 对称反转（直接操作原数组）
        for (int i = 0, temp; i < arr.length / 2; i++) {
            temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 -i] = temp;
        }
        System.out.println("第一次反转后：");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("arr[" + i + "]=" + arr[i] + " ");
        }
        System.out.println("");

        // 方法二：逆序赋值（拷贝一个新数组）
        int[] arr1 = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr1[i] = arr[arr.length - 1 - i];
        }
        System.out.println("第二次反转后：");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print("arr1[" + i + "]=" + arr1[i] + " ");
        }

    }
}
/* 运行结果：
--------------------------------
第一次反转后：
arr[0]=11 arr[1]=22 arr[2]=33 arr[3]=44 arr[4]=55 arr[5]=66 
第二次反转后：
arr1[0]=66 arr1[1]=55 arr1[2]=44 arr1[3]=33 arr1[4]=22 arr1[5]=11
--------------------------------
*/