public class test {
    public static void main(String[] args) {
        Circle circle = new Circle();
        PassObject obj = new PassObject();
        obj.printAreas(circle, 5);
    }
}

class Circle {
    double radius;

    public double findArea() {
        return Math.PI * radius * radius;
    }
}

class PassObject {
    public void printAreas(Circle c, int times) {
        System.out.println("Radius\t\t" + "Area");
        for (int i = 1; i <= times; i++) {
            c.radius = (double)i;
            System.out.println(c.radius + "\t\t\t" + c.findArea());
        }
    }
}



