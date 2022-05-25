package eFridge;

public class fridgelist extends Lista {

    void printIngredients() {
        for (Product p : this.products) {
            System.out.println(p.name);
        }
    }
}
