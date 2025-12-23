// 功能：
// （1）定义一个Circle类，包含一个double类型的radius属性代表圆的半径，findArea()方法返回圆的面积
// （2）定义一个PassObject类，定义一个方法printAreas()，该方法的定义如下：public void printAreas(Circle, int times)
//  (3) 在printAreas方法中打印输出1到times之间的每个整数半径值，以及对应的面积。
// （4）在main方法中调用printAreas()方法，调用完毕输出当前半径值。

// 目的：了解面向对象的松耦合编程，和单一职责

public class HomeWork08 {
    public static void main(String[] args) {
        Circle c = new Circle();
        PassObject obj = new PassObject();
        obj.printAreas(c, 5);
    }
}

class Circle {
    double radius;

    public Circle() {

    }

    public double areas() {
        return Math.PI * radius * radius;
    }
}

class PassObject{
    // 选择在对象中传出对象引用，而不是直接创造一个新的对象，符合单一职责原则
    // 单一职责原则：工具类不生产数据，只负责业务逻辑
    public void printAreas(Circle circle, int times) {
        System.out.println("Radius\t\tArea");
        for (int i = 1; i <= times; i++) {
            circle.radius = (double)i;
            System.out.println(circle.radius + "\t\t\t" + circle.areas());
        }
    }
}

/* 运行结果：
--------------------------------
Radius		Area
1.0			3.141592653589793
2.0			12.566370614359172
3.0			28.274333882308138
4.0			50.26548245743669
5.0			78.53981633974483
--------------------------------
*/