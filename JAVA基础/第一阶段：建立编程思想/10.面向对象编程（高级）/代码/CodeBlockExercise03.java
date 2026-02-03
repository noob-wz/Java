//2026-02-03 22:34:45
// 目的：熟悉 类加载流程 和 对象初始化顺序

public class CodeBlockExercise03 {

    // 1. 静态变量 singleton
    private static CodeBlockExercise03 singleton = new CodeBlockExercise03();

    // 2. 静态变量 count1 (显式赋值)
    public static int count1;

    // 3. 静态变量 count2 (显式赋值)
    public static int count2 = 0;

    // 4. 实例代码块
    {
        count1++;
        count2++;
        System.out.println("普通代码块执行");
    }

    // 5. 构造器
    private CodeBlockExercise03() {
        System.out.println("执行构造器");
    }

    // 6. 静态方法
    public static CodeBlockExercise03 getInstance() {
        return singleton;
    }

    public static void main(String[] args) {
        CodeBlockExercise03 obj = CodeBlockExercise03.getInstance();
        System.out.println("count1=" + obj.count1);
        System.out.println("count2=" + obj.count2);
    }
}