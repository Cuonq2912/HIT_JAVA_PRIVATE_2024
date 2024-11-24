package model;

public class VinCar extends Car {
    public VinCar() {
    }

    public VinCar(String id, int amount, double price, String name) {
        super(id, amount, price, name);
    }


    @Override
    public double totalPrice() {
        return this.getPrice() + this.getAmount();
    }

    @Override
    public String toString() {
        return super.toString() + "Tong gia tri: " + this.totalPrice();
    }

    public void display(){
        System.out.println(this);
    }

}
