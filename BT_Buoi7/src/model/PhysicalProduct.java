package model;

public class PhysicalProduct extends Product{
    public PhysicalProduct(String id, String name, double price, int quantity) {
        super(id, name, price, quantity);
    }

    public PhysicalProduct() {
    }

    @Override
    public double totalPrice() {
        return this.getPrice() * this.getQuantity();
    }

    @Override
    public String toString() {
        return super.toString() + "totalPrice= " + totalPrice();
    }
}
