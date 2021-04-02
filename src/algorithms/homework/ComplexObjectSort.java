package algorithms.homework;

// Sort products by price then quantity, then category
public class ComplexObjectSort {
    public static void main(String[] args) {
        var product1 = new Product();
        product1.category = "Food";
        product1.price = 10;
        product1.quantity = 100;

        var product2 = new Product();
        product2.category = "Food";
        product2.price = 10;
        product2.quantity = 100;
    }
}

class Product {
    public int price;
    public String category;
    public int quantity;
}
