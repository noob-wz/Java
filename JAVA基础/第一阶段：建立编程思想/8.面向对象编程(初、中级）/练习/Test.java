public class Test {
    public static void main(String[] args) {
        int[] arr = {4, 13, 324, 44, 4};
        Person5 person5 = new Person5(18);


        // 最外层循环每次冒个泡
        for (int i = 0; i <= arr.length - 1; i++) {
//            i=0, j的边界是3
//            i=1, j的边界是2
//            i=2, j的边界是1
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr[" + i + "]=" + arr[i] + "\t");
        }
    }
}

class Person5 {
    int age;


    public Person5(int age) {
        this.age = age;
    }
}

class XiaoYu extends Person5 {


    public XiaoYu(int age) {
        super(age);
    }
}

// 包的功能：（1）解决命名冲突；（2）分类管理：横向区分业务逻辑，纵向高聚合功能组件；（3）访问控制：
