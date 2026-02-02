// 功能：编写类Book，定义方法updatePrice,实现更改某本书的价格，具体：如果价格>150,则更改为150，如果价格>100，更改为100，否则不变

public class HomeWork02 {
    public static void main(String[] args) {
        Book book1 = new Book(152);
        Book book2 = new Book(45);
        Book book3 = new Book(130);

        book1.updatePrice();
        book2.updatePrice();
        book3.updatePrice();

        System.out.println("book1 = " + book1.price 
        + "\nbook2 = " + book2.price
        + "\nbook3 = " + book3.price
        );
    }
}

class Book {
    double price;

    public Book(double price) {
        this.price = price;
    }

    public void updatePrice() {
        if (this.price > 150) {
            this.price = 150;
        } else if (this.price > 100) {
            this.price = 100;
        } 
    }
}

