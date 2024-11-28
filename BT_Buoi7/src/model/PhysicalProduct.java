package model;

public class PhysicalProduct extends Product {
    public PhysicalProduct(String id, String name, double price, int quantity) {
        super(id, name, price, quantity);
    }

    @Override
    public double totalPrice() {
        return getPrice() * getQuantity();
    }


}
