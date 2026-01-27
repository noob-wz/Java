// 目的：熟悉下方代码的输出情况
//2026-01-27 18:15:59

public class EqualsExercise02 {
    public static void main(String[] args) {
        int it = 65;
        float fl = 65.0f;

        System.out.println("65 和 65.0f 是否相等？" + (it == fl));
        // true
        // 说明：float 虽然对小数（如 0.1）和超大整数不精确，但它能完美精确地表示一定范围内的整数。

        char ch1 = 'A';
        char ch2 = 12;
        System.out.println("65 和 A 是否相等?" + (it == ch1));
        // true
        System.out.println("12 和 ch2 是否相等?" + (12 == ch2));
        // true

        String str1 = new String("hello");
        String str2 = new String("hello");
        System.out.println("Str1 和 Str2 是否相等？" + (str1 == str2));
        // false

        System.out.println("str1 是否 equals str2? " + (str1.equals(str2)));
        // true
        
        //  System.out.println("hello" == new java.sql.Date());
        // 这行代码编译器会报错，因为java是强类型语言，比较对象必须类型一致或者可以进行转换。

    }
}
