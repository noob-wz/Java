// 功能：定义个圆类Circle，定义属性：半径，提供显示圆周长功能的方法，提供显示圆面积的方法。

public class HomeWork07 {
    public static void main(String[] args) {
        Circle circle = new Circle(4.5);

        System.out.println("圆的周长是：" + circle.circumference());
        System.out.println("圆的面积是：" + circle.area());
    }
}

class Circle {
    double radius;

    // 初始化圆的半径大小
    public Circle(double radius) {
        this.radius = radius;
    }

    // 计算周长
    public double circumference() {
        return 2 * Math.PI * radius;
    }

    // 计算面积
    public double area() {
        return Math.PI * radius * radius;
    }
}

/* 运行结果：
--------------------------------
圆的周长是：28.274333882308138
圆的面积是：63.61725123519331
--------------------------------
*/