package eFridge;

public class Product {
    String name;
    String category;
    Integer quantity;
    Integer alertQuantity = 0;

    Product() {

    }

    Product(String name, String category, Integer quantity, Integer alertQuantity) {
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.alertQuantity = alertQuantity;
    }

    @Override
    public String toString() {
        return this.name + "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "[" + this.category + "]";
    }
}
