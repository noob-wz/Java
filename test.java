public class test {

    
    public static void main(String[] args) {
        T t = new T();
        Person p = new Person();
        t.test2(p);
    }
}

class Person {
    String name = "wangzeng";
}

class T {
    public void test2(Person p) {
        System.out.println(p.name);
    }
}



