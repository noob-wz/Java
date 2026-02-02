// 功能：创建一个Cale计算类，在其中定义两个变量代表两个操作数，定义四个方法实现求和、差、乘、商（要求商为0时进行提示）并创建两个对象，分别测试
// 目的：初步了解“先完成基础代码逻辑，再优化代码健壮性”

public class HomeWork03 {
    public static void main(String[] args) {
        Cale cale = new Cale(14.5, 3.5);
        System.out.println("和：" + cale.addition());
        System.out.println("差：" + cale.minus());
        System.out.println("乘：" + cale.multiplication());
        Double div = cale.division();
        if (div != null) {
            System.out.println("除：" + div);
        }
    }
}

class Cale {
    double num1;
    double num2;

    public Cale(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    // 计算加法
    public double addition() {
        return num1 + num2;
    }

    // 计算减法
    public double minus() {
        return num1 - num2;
    }

    // 计算乘法
    public double multiplication() {
        return num1 * num2;
    }

    // 计算除法
    public Double division() {
        if(num2 == 0) {
            System.out.println("除数不能为0！");
            return null;
        }
        return num1 / num2;
    }
}

/* 运行结果：
--------------------------------
和：18.0
差：11.0
乘：50.75
除：4.142857142857143
--------------------------------
*/