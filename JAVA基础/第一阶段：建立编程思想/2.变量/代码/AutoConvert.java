public class AutoConvert {
    public static void main(String[] args){
        int n1 = 10;
        double n2 = n1 + 1.1; // n1+1.1，其中n1会自动提升为double类型

        // float n3 = n1 + 1.1; // 这种写法下，相当于double转化成float，是不兼容的
        float n3 = n1 + 1.1f; // 加字面量后缀，定义数据类型，n1也会转化成float
        float n4 = (float)(n1 + 1.1); // 和n3结果一样
    }
}