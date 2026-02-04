//2026-02-04 22:26:28
// 功能：编写一个程序，计算圆形的面积。要求圆周率为3.14。不同赋值的位置都写一下
// 目的：final关键字练习

public class FinalExercise01 {
    public static void main(String[] args) {
        Circle c = new Circle(2.5);
        System.out.println(c.area());
    }
}

class Circle {
    private double radius;
    public static final double PI = 3.14;

    Circle(double radius) {
        this.radius = radius;
    }

    public double area() {
        return PI * radius * radius;
    }
}
