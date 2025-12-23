// 功能：定义类A01，定义方法max，实现求某个double数组的最大值，并返回
// 目的：熟悉编写代码要遵循“先完成正常业务，再保证代码健壮性”

public class HomeWork04 {
    public static void main(String[] args) {
        A01 a = new A01();
        double[] arr = {1.5, 0.3, 4.5, 8,3, 2,2};
        // double[] arr = null; //此时调用a.max(arr)会报错空指针异常
        Double res = a.max(arr);

        if (res != null) {
            System.out.println("数组中的最大值是：" + res);
        } else {
            System.out.println("输入数组有误");
        }
    }
}

// 先完成正常业务，再保证代码健壮性
class A01 {
    public Double max(double[] arr) {
        // arr != null，是为了避免空指针异常
        // arr.length > 0 是为了在保证数组有堆空间的情况下，数组至少有一个元素
        if (arr != null && arr.length > 0) {
            double max = arr[0];

            for (int i = 1; i < arr.length; i++) {
                if (max < arr[i]) {
                    max = arr[i];
                }
            }
            return max;
        } else {
            // 为了保证有一个返回值，方法的返回类型从 double 改成 Double
            return null;
        }
    }
}
