//2026-02-03 22:34:45
// 目的：熟悉 类加载流程 和 对象初始化顺序

class Config {
    static int TIMEOUT = 10;
    static {
        System.out.println("Config Loaded: TIMEOUT=" + TIMEOUT);
        TIMEOUT = 20;
    }
}

public class CodeBlockExercise01 {
    static int DEFAULT_TIMEOUT = Config.TIMEOUT;

    static {
        System.out.println("Service Static Block");
    }

    public CodeBlockExercise01() {
        System.out.println("Service Constructor");
    }

    public static void main(String[] args) {
        System.out.println("Main Start");
        new CodeBlockExercise01();
        System.out.println("Current Timeout: " + Config.TIMEOUT);
    }
}

/* 输出结果：
*************************************
Config Loaded: TIMEOUT=10
Service Static Block
Main Start
Service Constructor
Current Timeout: 20
*************************************
*/
