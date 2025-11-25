class AA {
    public boolean isOdd (int n) {
        return n % 2 == 0;
    }
}

public class test {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        AA a = new AA();
        System.out.println(a.isOdd(10));
    }
}
