// 功能：编写类A02， 定义方法find, 实现查找某字符串数组中的元素查找，并返回索引

public class HomeWork05 {
    public static void main(String[] args) {
        A02 a = new A02();
        String[] arr = {"wangzeng", "yuhuiqi", "laifu"};
        if (a.find(arr,"wangzeng") != -1){
            System.out.println("数组中第" + (a.find(arr, "wangzeng") + 1) + "个数，和\"wangzeng\"一致");
        } else {
            System.out.println("数组中没有要找的字符串");
        }
    }
}

class A02 {
    public int find(String[] arr, String str) {
        int index = -1;
        for(int i = 0; i < arr.length; i++) {
            if (arr[i].equals(str)) {
                index = i;
                break;
            }
        }
        return index;
    }
}

/* 运行结果：
--------------------------------
数组中第1个数，和"wangzeng"一致
--------------------------------
*/