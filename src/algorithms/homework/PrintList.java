package algorithms.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Product {
    public int price;
    public String category;
    public int quantity;

    public Product(int price, String category, int quantity) {
        this.price = price;
        this.category = category;
        this.quantity = quantity;
        }

        public int getPrice() {
            return price;
        }
        public String getCategory() {
            return category;
        }
        public int getQuantity() {
            return quantity;
        }
}

class SortPrice implements Comparator<Product> {
    public int compare(Product product1, Product product2) {
        return product1.price - product2.price;
    }
}

class SortQuantity implements Comparator<Product> {
    public int compare(Product product1, Product product2) {
        return product1.quantity - product2.quantity;
    }
}

class SortCategory implements Comparator<Product> {
    public int compare(Product product1, Product product2) {
        return product1.category.compareTo(product2.category);
    }
}

// Sort products by price then quantity, then category
public class PrintList {
    public static void main(String[] args) {
        ArrayList<Product> productList = new ArrayList<>();

        var product1 = new Product(10, "Food", 100);
        var product2 = new Product(9, "Drink", 110);
        var product3 = new Product(9, "Drink", 100);
        var product4 = new Product(9, "Food", 110);
        var product5 = new Product(10, "Drink", 110);
        var product6 = new Product(10, "Drink", 100);
        var product7 = new Product(9, "Food", 100);
        var product8 = new Product(10, "Food", 110);

        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        productList.add(product5);
        productList.add(product6);
        productList.add(product7);
        productList.add(product8);

        Collections.sort(productList, new SortPrice()
                .thenComparing(new SortQuantity())
                .thenComparing(new SortCategory()));

        for (Product product : productList) {
            System.out.println(product.getPrice() + ", "
                    + product.getCategory() + ", "
                    + product.getQuantity()
            );
        }
    }
}