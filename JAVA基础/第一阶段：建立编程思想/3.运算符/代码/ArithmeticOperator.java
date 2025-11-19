// 目的：1、了解表达式的两个属性；2、取余的符号；3、自增和自减的使用

public class ArithmeticOperator {
    public static void main(String[] args) {

        // 取余的正负和被除数的符号永远保持一致
        double a = 10 % 4; 
        double b = -10 % 4;
        double c = 10 % -4;
        double d = -10 % -4;
        System.out.println(a + " " + b + " " + c + " " + d); // 一句输出看a和b的结果

        // 了解表达式的副作用和返回值属性
        int j = 8;
        int k = ++j;
        System.out.println("j=" + j + ", " + "k=" + k);
    }
}
