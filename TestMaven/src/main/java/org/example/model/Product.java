package org.example.model;

public class Product {
    protected int id;
    protected String name;
    protected int price;
    protected int category_id;

    public Product() {
    }

    public Product(int id, String name, int price, int category_id) {
        this.category_id = category_id;
        this.price = price;
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category_id=" + category_id +
                '}';
    }
}
