// 目的：演示java的开发步骤

// 总结：
// 以下对代码进行详细说明：
// 1. public class Hello 表示Hello是一个public(公有)类型的类
// 2. Hello {} 大括号代表类的开始和结束
// 3. public static void main(String[] args) 代表的是主方法，它是程序执行的入口
// 4. main(String[] args) {} 大括号代表方法的开始和结束
// 5. System.out.printlin("hello, world!"); 表示输出"hello, world!"到屏幕
// 6. ;分号表示语句的结束

// 另外，修改后的Hello.java源文件需要重新编译生成.class文件再执行，才能生效

public class Hello {    
    public static void main(String[] args) {
        System.out.println("hello, world!");
    }
}

class Tiger {
    public static void main(String[] args) {
        System.out.println("hello, tiger!");
    }
}

class Dog {
    public static void main(String[] args){
        System.out.println("hello,dog!");
    }
}
