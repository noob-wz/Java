//2026-02-03 22:34:45
// 目的：熟悉 类加载流程 和 对象初始化顺序

public class CodeBlockExercise02 {
    Sample sam1 = new Sample("sam1成员初始化");
    static Sample sam = new Sample("静态成员sam初始化");

    static {
        System.out.println("static块执行");
        if(sam == null) {
            System.out.println("sam is null");
        }
    }

    CodeBlockExercise02() {
        System.out.println("CodeBlockExercise02默认构造器被调用");
    }

    public static void main(String[] args){
        CodeBlockExercise02 a = new CodeBlockExercise02();
    }
}

class Sample {
    Sample(String s) {
        System.out.println(s);
    }

    Sample() {
        System.out.println("Sample默认构造器被调用");
    }
}

/* 输出结果：
*************************************
静态成员sam初始化
static块执行
sam1成员初始化
CodeBlockExercise02默认构造器被调用
*************************************
*/


